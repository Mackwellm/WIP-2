package com.example.wip

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.MimeTypeMap
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class AddImage : AppCompatActivity() {

    private lateinit var  uploadBtn: Button
    private lateinit var  ShowBtn: Button
    private lateinit var image:ImageView
    private lateinit var progress: ProgressBar
    private lateinit var listOfT: Button
    private lateinit var root: DatabaseReference
    private lateinit var strRef: StorageReference

    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_image)

        listOfT = findViewById<Button>(R.id.listOfTask)
        listOfT.setOnClickListener {
            val intent = Intent(this, ListOfTasks::class.java)
            startActivity(intent)
        }

        root = FirebaseDatabase.getInstance().getReference().child("Image")
        strRef = FirebaseStorage.getInstance().getReference()

        uploadBtn = findViewById(R.id.upload_btn)
        ShowBtn = findViewById(R.id.show_btn)
        image = findViewById(R.id.imageVw)
        progress = findViewById(R.id.prBar)

        progress.visibility = View.INVISIBLE
        ShowBtn.setOnClickListener {
            startActivity(
                Intent(
                    this@AddImage,
                    ListOfTasks::class.java
                )
            )
        }

        image.setOnClickListener {
            val gallery = Intent()
            gallery.action = Intent.ACTION_GET_CONTENT
            gallery.type = "image/*"
            startActivityForResult(gallery, 2)
        }

        uploadBtn.setOnClickListener {
            if (imageUri != null) {
                uploadToFbase(imageUri!!)
            } else {
                Toast.makeText(this@AddImage, "Please Select Image", Toast.LENGTH_SHORT).show()
            }
        }
    }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
                super.onActivityResult(requestCode, resultCode, data)
                if (requestCode == 2 && resultCode == RESULT_OK && data != null) {
                    imageUri = data.data
                    image.setImageURI(imageUri)
                }
            }

            private fun uploadToFbase(imageUri: Uri) {
                val fileRef = strRef.child(System.currentTimeMillis().toString() + "." + getFileExtension(imageUri))
                fileRef.putFile(imageUri).addOnSuccessListener {
                    fileRef.downloadUrl.addOnSuccessListener { uri ->
                        val model = ImageModel(uri.toString())
                        val modelId = root.push().key
                        root.child(modelId!!).setValue(model)
                        progress.visibility = View.INVISIBLE
                        Toast.makeText(this@AddImage, "Uploaded Successfully", Toast.LENGTH_SHORT)
                            .show()
                        image.setImageResource(R.drawable.baseline_add_photo_alternate_24)
                    }
                }.addOnProgressListener { progress.visibility = View.VISIBLE }
                    .addOnFailureListener {
                        progress.visibility = View.INVISIBLE
                        Toast.makeText(this@AddImage, "Uploading Failed !!", Toast.LENGTH_SHORT).show()
                    }
            }

            private fun getFileExtension(mUri: Uri): String? {
                val cr = contentResolver
                val mime = MimeTypeMap.getSingleton()
                return mime.getExtensionFromMimeType(cr.getType(mUri))
            }
        }