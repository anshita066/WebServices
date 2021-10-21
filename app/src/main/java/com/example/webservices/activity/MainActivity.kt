package com.example.webservices.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.webservices.adapters.MyAdapter
import com.example.webservices.model.DataModel
import com.example.webservices.model.Post
import com.example.webservices.R
import com.example.webservices.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity:AppCompatActivity() {

    lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    var dataList = ArrayList<Post>()
    lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.rvDetails)
        recyclerView.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager=linearLayoutManager
        myAdapter = MyAdapter(baseContext , dataList)
        recyclerView.adapter=myAdapter



        getDetails()


    }

    private fun getDetails(){
        val detailData = ApiClient.getClient.getData()

        detailData.enqueue(object : Callback<DataModel?>{

            override fun onResponse(call: Call<DataModel?>, response: Response<DataModel?>) {
                val responseBody = response.body()!!
                val xy = responseBody?.posts
                dataList.addAll(xy)
                myAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<DataModel?>, t: Throwable) {
                Log.d("MainActivity" , "onFailure:" + t.message)

            }

        })


    }
}