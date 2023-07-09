package com.example.wip

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class ImageShow : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val db = FirebaseDatabase.getInstance()
    private val root = db.reference.child("Image")

    private var adapter: ImageAdapter? = null
    private var list: ArrayList<ImageModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_show)


        recyclerView = findViewById(R.id.rc_Image)
        recyclerView.setHasFixedSize(true)
        recyclerView.setLayoutManager(LinearLayoutManager(this))

        list = ArrayList<ImageModel>()
        adapter = ImageAdapter(this, list!!)
        recyclerView.setAdapter(adapter)
        root.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (dataSnapshot in snapshot.children) {
                    val model: ImageModel? = dataSnapshot.getValue(ImageModel::class.java)
                    if (model != null) {
                        list!!.add(model)
                    }
                }
                adapter!!.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }
}