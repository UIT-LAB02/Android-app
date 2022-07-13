package com.example.kakao_app.GuestBook.SearchPackage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.kakao_app.R

class ImageData(val PedImage : Int)

class PedHolder(v : View) : RecyclerView.ViewHolder(v){

    var imageView : ImageView = v.findViewById(R.id.ped_image)

    val PedImages = imageView
}
class PedAdapter (val Datalist : ArrayList<ImageData>) : RecyclerView.Adapter<PedHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PedHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.ped_item_view, parent, false)
        return PedHolder(itemView)
    }

    override fun onBindViewHolder(holder: PedHolder, position: Int) {
        holder.PedImages.setImageResource(Datalist[position].PedImage)
    }

    override fun getItemCount(): Int {
        return Datalist.size
    }

}