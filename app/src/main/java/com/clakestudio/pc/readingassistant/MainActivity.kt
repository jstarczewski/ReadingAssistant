package com.clakestudio.pc.readingassistant

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.clakestudio.pc.readingassistant.books.BooksActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, BooksActivity::class.java))

    }
}
