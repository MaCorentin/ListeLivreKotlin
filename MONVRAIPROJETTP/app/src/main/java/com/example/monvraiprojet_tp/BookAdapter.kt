package com.example.monvraiprojet_tp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_List_Item.view.*


class Adaptor : RecyclerView.Adapter<MyViewHolder>() {

    private lateinit var myListener : onItemClickListener
    interface onItemClickListener{
        fun onItemClick(position : Int)
    }
    var listItem : List<Book> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val rowView = LayoutInflater.from(parent.context).inflate(R.layout.booklist, parent, false)

        return MyViewHolder(rowView,myListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.updateItem(listItem[position])
    }

    override fun getItemCount(): Int = listItem.size

    fun setOnItemClickListener(listener: onItemClickListener){
        myListener = listener
    }


}

class MyViewHolder (itemView : View, listener: Adaptor.onItemClickListener) : RecyclerView.ViewHolder(itemView) {
    init{

        itemView.setOnClickListener {
            listener.onItemClick(adapterPosition)
        }

    }

    fun updateItem(book: Book){

        itemView.textAdapter1.setText(book.auteur)
        itemView.textAdapter2.setText(book.titre)
    }
    }