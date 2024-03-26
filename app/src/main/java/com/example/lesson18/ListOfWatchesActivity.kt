package com.example.lesson18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.lesson18.databinding.ActivityListOfWatchesBinding
import com.example.lesson18.recyclerList.Watch
import com.example.lesson18.recyclerList.WatchAdapter
//-Создать список Recycler View с заметками
//-Заметка: заголовок, текст, дата (можно рандомную)
//-Хранить список заметок можно в отдельном Object (как стаитичяеский)
//-На том же экране добавить поля для создания заметик (получается 2-3 поля и кнопка)
//-Добавление заметок реализовать с помощью notify методов (только не notifyDataChanged)
//-Реализовать вывод сообщения через клик по заметке
class ListOfWatchesActivity : AppCompatActivity() {
    lateinit var binding: ActivityListOfWatchesBinding
    private val adapter=WatchAdapter()
    private val imageIdList= listOf(
        R.drawable.watch1,
        R.drawable.watch2,
        R.drawable.watch3,
        R.drawable.watch4,
        R.drawable.watch5,
        R.drawable.watch6,
        R.drawable.watch7,
        R.drawable.watch8,)
    private var index=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityListOfWatchesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    private fun init()= with(binding){
        recyclerWatches.layoutManager=GridLayoutManager(this@ListOfWatchesActivity,2)
        recyclerWatches.adapter=adapter
        buttonWatch.setOnClickListener {
            val watch = Watch(imageIdList[index], "Watch $index ",1000)
            adapter.addWatch(watch)
            index++
        }
    }
}