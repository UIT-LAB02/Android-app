package com.example.kakao_app.GuestBook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kakao_app.R

class Data(val LankingText: String)

class LankHolder(v : View) : RecyclerView.ViewHolder(v){

    var lanktext : TextView = v.findViewById(R.id.lankText)

    val LankText = lanktext

}

class LankAdapter(val DataList : ArrayList<Data>) : RecyclerView.Adapter<LankHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LankHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.lank_item_recycler, parent, false)
        return LankHolder(itemView)
    }

    override fun onBindViewHolder(holder: LankHolder, position: Int) {
        holder.LankText.text = DataList[position].LankingText

    }

    override fun getItemCount(): Int {
        return DataList.size
    }


}

