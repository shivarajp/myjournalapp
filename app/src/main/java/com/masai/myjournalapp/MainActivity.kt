package com.masai.myjournalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.masai.myjournalapp.adapter.OnTaskItemClicked
import com.masai.myjournalapp.adapter.RoutineAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnTaskItemClicked {

    private val routineList: MutableList<String> = mutableListOf()
    lateinit var mAdapter: RoutineAdapter
    lateinit var dbHandler: DatabaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        routineList.add("hello")
        routineList.add("hello")
        routineList.add("hello")
        routineList.add("hello")

        mAdapter = RoutineAdapter(this, routineList, this)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = mAdapter

        dbHandler = DatabaseHandler(this)

        addBtn.setOnClickListener {
            dbHandler.insertRoutine("Drink water", "Healthy to mind and skin", "Tue")
        }

        update.setOnClickListener {
            dbHandler.updateRoutine(1, "Drink Milk", "For stronger bones", "Mon")
        }

        delete.setOnClickListener {
            dbHandler.deleteRoutine(2)
        }



    }

    override fun onEditClicked(task: String) {

    }

    override fun onDeleteClicked(task: String) {

    }
}