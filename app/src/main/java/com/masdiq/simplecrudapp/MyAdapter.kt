package com.masdiq.simplecrudapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.masdiq.simplecrudapp.retrofit.MyDataItem
import kotlinx.android.synthetic.main.row_items.view.*

class MyAdapter(private val context: Context, private val userlList: List<MyDataItem>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.row_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = userlList[position]
        Glide.with(holder.itemView.context)
            .load(item.imageURL)
            .apply(RequestOptions())
            .into(holder.image)
        holder.title.text = userlList[position].title
        holder.subtitle.text = userlList[position].subtitle
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.tv_title!!
        var subtitle = itemView.tv_subtitle!!
        var image = itemView.image!!
    }

    override fun getItemCount(): Int {
        return userlList.size
    }
}