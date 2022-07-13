package com.example.kakao_app.GuestBook.SearchPackage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.kakao_app.R

class Data(val im_search: Int)

class SearchHolder(v : View) : RecyclerView.ViewHolder(v){

    var imageView : ImageView = v.findViewById(R.id.im_search)

    val im_search = imageView
}

class SearchAdapter (val DataList:ArrayList<Data>) : RecyclerView.Adapter<SearchHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.search_item_recycler, parent, false)
        return SearchHolder(itemView)
    }

    override fun onBindViewHolder(holder: SearchHolder, position: Int) {
        holder.im_search.setImageResource(DataList[position].im_search)

    }

    override fun getItemCount(): Int {
        return DataList.size
    }

}