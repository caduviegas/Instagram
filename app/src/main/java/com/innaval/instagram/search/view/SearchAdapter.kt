package com.innaval.instagram.search.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.innaval.instagram.R
import com.innaval.instagram.common.model.UserAuth

class SearchAdapter (
    private val itemClick: (String) -> Unit
) : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    var items: List<UserAuth> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class SearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: UserAuth) {
            itemView.findViewById<ImageView>(R.id.search_img_user).setImageURI(user.photoUri)
            itemView.findViewById<TextView>(R.id.search_txt_username).text = user.name
            itemView.setOnClickListener {
                itemClick.invoke(user.uuid)
            }
        }
    }

}