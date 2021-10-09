package com.masdiq.simplecrudapp.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masdiq.simplecrudapp.R
import com.masdiq.simplecrudapp.response.PostsResponse
import kotlinx.android.synthetic.main.row_items.view.*

class MyAdapter(private val context: Context, private val userlList: List<PostsResponse>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.row_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = userlList[position].title
        holder.place.text = userlList[position].place
        holder.content.text = userlList[position].content
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.tv_title!!
        var place = itemView.tv_place!!
        var content = itemView.tv_content!!
    }

    override fun getItemCount(): Int {
        return userlList.size
    }
}