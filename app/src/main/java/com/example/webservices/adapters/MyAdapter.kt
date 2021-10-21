package com.example.webservices.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.webservices.adapters.MyAdapter.MyViewHolder
import com.example.webservices.model.Post
import com.example.webservices.R
import com.squareup.picasso.Picasso

class MyAdapter(private val context: Context, private val dataList: List<Post>) : RecyclerView.Adapter<MyViewHolder>(){
    class MyViewHolder (itemView: View) :RecyclerView.ViewHolder(itemView){
        var image:ImageView
        var txt_name : TextView
        var message : TextView

        init {
            image=itemView.findViewById(R.id.imageView)
            txt_name=itemView.findViewById(R.id.tv_userid)
            message=itemView.findViewById(R.id.tv_title)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item , parent , false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.txt_name.text = dataList[position].name
        holder.message.text = dataList[position].message
        val profileImgURL = dataList[position].profileImage
//        Glide.with(context).load(profileImgURL)
//            .into(holder.image)

        Picasso.get().load(profileImgURL)
//            .placeholder(R.mipmap.ic_launcher)
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}