package com.example.restomenu

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FoodsActivity : AppCompatActivity() {
    private lateinit var rvFoods: RecyclerView
    private val list = ArrayList<Food>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foods)

        rvFoods = findViewById(R.id.rv_foods)
        rvFoods.setHasFixedSize(true)

        list.addAll(listFoods)
        showRecyclerList()
    }private val listFoods: ArrayList<Food>
        get(){
            val dataName = resources.getStringArray(R.array.data_name)
            val dataDescription = resources.getStringArray(R.array.data_description)
            val dataHarga = resources.getStringArray(R.array.data_name)
            val dataPhoto = resources.getStringArray(R.array.data_photo)
            val listFood = ArrayList<Food>()
            for (i in dataName.indices){
                val food = Food(dataName[i],dataDescription[i], dataHarga[i], dataPhoto[i])
                listFood.add(food)
            }
            return listFood
        }

    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvFoods.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvFoods.layoutManager = LinearLayoutManager(this)
        }

        val listHeroAdapter = ListMenuAdapter(list)
        rvFoods.adapter = listHeroAdapter
        listHeroAdapter.setOnItemClickCallback(object : ListMenuAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Food) {
                showSelectedHero(data)
            }
        })
    }


    private fun showSelectedHero(hero: Food) {
        Toast.makeText(this, "Kamu memilih " + hero.name, Toast.LENGTH_SHORT).show()
    }
}