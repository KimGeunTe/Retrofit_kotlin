package com.example.retrofit.VP

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofit.VO.PhotoVO
import com.example.retrofit.databinding.PhotoTemplateBinding

class photo_VP_Adapter(val context: Context, val PhotoList:MutableList<PhotoVO>):RecyclerView.Adapter<photo_VP_Adapter.ViewHolder>(){

    private lateinit var binding:PhotoTemplateBinding

    class ViewHolder(val binding: PhotoTemplateBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = PhotoTemplateBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            when(position){
                position -> {
                    Glide.with(context)
                        .load(PhotoList[position].url.regular)
                        .placeholder(ColorDrawable(Color.parseColor(PhotoList[position].color)))
                        .into(holder.binding.img1)
                }
            }
    }

    override fun getItemCount(): Int {
        return PhotoList.size
    }

}