package com.csis365.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.csis365.assignment1.service.FruitService
import com.csis365.assignment1.service.dto.Fruit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FruitActivity : AppCompatActivity() {
    private lateinit var rvFruitList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFruitList = findViewById(R.id.rv_fruitdetail)
        rvFruitList.layoutManager = LinearLayoutManager(this)


        val fruitService = buildService()
        fruitService.getAllFruit().enqueue(object : Callback<List<Fruit>> {
            override fun onResponse(call: Call<List<Fruit>>, response: Response<List<Fruit>>) {
                Log.i("asdf", "onResponse()")
            }
            override fun onFailure(call: Call<List<Fruit>>, t: Throwable){
                Log.i("asdf", "dog was unable to be summoned")
            }
        })
        rvFruitList.adapter = MyItemAdapter(
            fruitService.getAllFruit()
        )

    }

    private fun buildService(): FruitService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://fruityvice.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(FruitService::class.java)
    }
}