package com.example.listlanguange

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.listlanguange.model.CustomeObject
import com.mandiri.simpleviewmodel.databinding.ListLayoutBinding

class MyAdapter(private val data : List<CustomeObject>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        return MyViewHolder(ListLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val datas = data[position]
        val imageUrl = datas.link
        Glide.with(holder.itemView)
            .load(imageUrl?.replace("\"",""))
            .into(holder.img)
        holder.textName.text = datas.name
        holder.textDesc.text = datas.desc

    }

    override fun getItemCount() : Int = data.size

    class MyViewHolder(val binding : ListLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        val textName = binding.textTitle
        val img = binding.imageAvatar
        val textDesc = binding.textDesc
    }


}