package com.example.lesson18.recyclerList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson18.R
import com.example.lesson18.databinding.WatchItemBinding
//-Создать список Recycler View с заметками
//-Заметка: заголовок, текст, дата (можно рандомную)
//-Хранить список заметок можно в отдельном Object (как стаитичяеский)
//-На том же экране добавить поля для создания заметик (получается 2-3 поля и кнопка)
//-Добавление заметок реализовать с помощью notify методов (только не notifyDataChanged)
//-Реализовать вывод сообщения через клик по заметке
class WatchAdapter : RecyclerView.Adapter<WatchAdapter.WatchHolder>() {
    val watchList = ArrayList<Watch>()


    class WatchHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = WatchItemBinding.bind(item)
        fun bind(watch: Watch) = with(binding) {
            imageWatch.setImageResource(watch.imageId)
            textWatch.text = watch.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.watch_item, parent, false)
        return WatchHolder(view)
    }

    override fun getItemCount(): Int {
        return watchList.size
    }

    override fun onBindViewHolder(holder: WatchHolder, position: Int) {
        holder.bind(watchList[position])
    }
fun  addWatch(watch: Watch){
    watchList.add(watch)
    notifyDataSetChanged()
}
}



