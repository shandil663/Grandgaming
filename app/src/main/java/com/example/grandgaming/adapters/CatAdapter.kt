package com.example.grandgaming.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.grandgaming.R
import com.example.grandgaming.data.model.APIItemItem
import com.example.grandgaming.ui.BiggerCatImage

class CatAdapter(
    private val context: Context,
    private val list: List<APIItemItem>) :
    RecyclerView.Adapter<CatAdapter.CatViewHolder>() {

    class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.catImages)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.catviewitem, parent, false)
        return CatViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(list[position].url).placeholder(R.drawable.loading).error(R.drawable.error)
            .into(holder.image)

        holder.itemView.setOnClickListener{
            val intent = Intent(context,BiggerCatImage::class.java)
            intent.putExtra("url",list[position].url)
            context.startActivity(intent)
        }
    }
}