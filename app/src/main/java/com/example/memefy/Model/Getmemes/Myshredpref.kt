package com.example.memefy.Model.Getmemes

import android.content.Context

class MySharedPref(context: Context) {

    companion object {
        private const val FILE_KEY = "user_info"
        private const val SUBREDDIT_NAME = "subreddit"
    }

    private val sharedPref = context.getSharedPreferences(FILE_KEY, Context.MODE_PRIVATE)

    fun saveUsername(name: Int){
        sharedPref.edit()
            .putInt(SUBREDDIT_NAME, name)
            .apply()
    }

    fun getUsername(): Int? {
        return sharedPref.getInt(SUBREDDIT_NAME, 0)
    }
}