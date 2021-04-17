package com.android.example.appdebug


import android.content.Context
import android.content.Intent
import android.net.Uri

class Util {

    /**
     * This function opens an URL
     */

    fun openPage(ctx: Context, url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        ctx.startActivity(intent)
    }


    /**
     * This function computes the factorial of a given number
     */
    fun factorial(n: Int): Long {
        return if (n == 1) n.toLong() else n*factorial(n-1)
    }

    /**
     * This function generates a random list of Integer
     */

    fun randomList(size: Int): List<Int> {
        val list = mutableListOf<Int>()
        for (i in 0..size - 1) {
            list.add(random(10000))
        }
        return list
    }

    /**
     * This function returns a random number less than n
     */
    fun random(n: Int) = (Math.random() * n).toInt()
}