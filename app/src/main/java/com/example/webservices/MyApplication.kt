package com.example.webservices

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager


class MyApplication : Application() {

    companion object{
        private var instance : MyApplication?=null

        fun getInstance(): MyApplication? {
            return instance
        }

        fun hasNetwork(): Boolean?{
            return instance?.isNetworkConnected() ?: false
        }
    }

    override fun onCreate() {
        super.onCreate()
        if(instance==null){
            instance = this
        }
    }

    private fun isNetworkConnected() : Boolean {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetwork = cm.activeNetworkInfo

        return activeNetwork !=null && activeNetwork.isConnectedOrConnecting
    }

}