package com.example.wip

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ImageAdapter(imageShow: ImageShow, mlist: ArrayList<ImageModel>) : RecyclerView.Adapter<ImageAdapter.MyViewHolder>() {
    private var mList: ArrayList<ImageModel>? = null
    private var context: Context? = null

    fun ImageAdapter(context: Context?, mList: ArrayList<ImageModel>?) {
        this.context = context
        this.mList = mList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.MyViewHolder {
        val v: View = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context!!).load(mList!![position].imageUrl).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return mList!!.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView

        init {
            imageView = itemView.findViewById<ImageView>(R.id.m_image)
        }
    }
}
