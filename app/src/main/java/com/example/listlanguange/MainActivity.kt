package com.example.listlanguange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CpuUsageInfo
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listlanguange.model.CustomeObject
import com.mandiri.simpleviewmodel.R
import com.mandiri.simpleviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var recycleView : RecyclerView
    private lateinit var adapter: MyAdapter
    private lateinit var recycleViewModel: RecycleViewModel
    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle("Warrior List")


        initViewModel()
        recycleView = binding.recycleView
        recycleView.layoutManager = LinearLayoutManager(this)
        subscribe()
        initUI()
    }

    private fun initUI() {
        val listBio = mutableListOf<CustomeObject>(
            CustomeObject("Aldi","Tank","https://reqres.in/img/faces/7-image.jpg"),
            CustomeObject("Humam","Tank","https://reqres.in/img/faces/8-image.jpg"),
            CustomeObject("Condro","Tank","https://reqres.in/img/faces/9-image.jpg"),
            CustomeObject("Rani","Tank","https://reqres.in/img/faces/10-image.jpg"),
            CustomeObject("Alfi","Tank","https://reqres.in/img/faces/11-image.jpg"),
        )
        recycleViewModel.initList(listBio)
        binding.apply {
            buttonInput.setOnClickListener{
                if (editTextName.text.isNotBlank() && editTextDesc.text.isNotBlank() && editTextLink.text.isNotBlank()){
                    recycleViewModel.increment(editTextName.text.toString(),editTextDesc.text.toString(),editTextLink.text.toString())
                    adapter.notifyItemInserted(recycleViewModel.customDialog.value!!.size-1)
                }
                editTextName.text.clear()
                editTextDesc.text.clear()
                editTextLink.text.clear()
            }
        }
    }

    private fun subscribe() {
        recycleViewModel.customDialog.observe(this){customDialog ->
            adapter = MyAdapter(customDialog)
            recycleView.adapter = adapter
        }
    }

    private fun initViewModel() {
        recycleViewModel = ViewModelProvider(this)[RecycleViewModel::class.java]
    }
}