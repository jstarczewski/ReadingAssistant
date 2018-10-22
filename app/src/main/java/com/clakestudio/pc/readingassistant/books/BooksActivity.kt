package com.clakestudio.pc.readingassistant.books

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.clakestudio.pc.readingassistant.R
import com.clakestudio.pc.readingassistant.util.obtainViewModel
import com.clakestudio.pc.readingassistant.util.replaceFragmentInActivity

class BooksActivity : AppCompatActivity() {

   private lateinit var booksViewModel : BooksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        setupViewFragment()

        booksViewModel = obtainViewModel().apply {
        }

    }
    private fun setupViewFragment() {
        supportFragmentManager.findFragmentById(R.id.contentFrame) ?:
                BooksFragment.newInstance().let {
                    replaceFragmentInActivity(it, R.id.contentFrame)
                }
    }

    fun obtainViewModel() : BooksViewModel  = obtainViewModel(BooksViewModel::class.java)
}
