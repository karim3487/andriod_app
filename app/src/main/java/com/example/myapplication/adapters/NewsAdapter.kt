package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.News
import com.example.myapplication.R

class NewsAdapter(private val newsList: ArrayList<News>) :
    RecyclerView.Adapter<NewsAdapter.NewsHolder>() {

    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_news, parent,
            false)
        return NewsHolder(itemView, mListener)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        mListener = listener
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        val currentItem = newsList[position]
        holder.tvFrom.text = currentItem.from
        holder.tvTitle.text = currentItem.title
    }

    override fun getItemCount(): Int {
        return newsList.size

    }

    class NewsHolder(newsItem: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(newsItem) {
        val tvFrom : TextView = itemView.findViewById(R.id.tv_from)
        val tvTitle : TextView = itemView.findViewById(R.id.tv_title)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }

    }
}