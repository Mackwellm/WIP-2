package com.example.wip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class ListOfTasks : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private val db = FirebaseDatabase.getInstance()
    private val root = db.reference.child("Tasks")
    private var adapter: MyAdapter? = null
    private var list: ArrayList<TaskModel?>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_tasks)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.setLayoutManager(LinearLayoutManager(this))

        list = ArrayList<TaskModel?>()
        adapter = MyAdapter(this, list!!)
        recyclerView.setAdapter(adapter)
        root.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (dataSnapshot in snapshot.children) {
                    val model: TaskModel? = dataSnapshot.getValue(TaskModel::class.java)
                    list!!.add(model)
                }
                adapter!!.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }
}