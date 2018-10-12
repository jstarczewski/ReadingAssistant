package com.clakestudio.pc.readingassistant.books

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.clakestudio.pc.readingassistant.R

class BooksActivity : AppCompatActivity() {

   private lateinit var booksViewModel : BooksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)
    }
}
