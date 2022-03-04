package com.csis365.assignment1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.csis365.assignment1.service.dto.Fruit

class MyItemAdapter(val data: List<Fruit>) : RecyclerView.Adapter<MyItemAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_fruit_detail, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyItemAdapter.MyViewHolder, position: Int) {
        holder.textView.text = data[position].name
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            textView = view.findViewById(R.id.tv_fruit_detail)
        }
    }
}

