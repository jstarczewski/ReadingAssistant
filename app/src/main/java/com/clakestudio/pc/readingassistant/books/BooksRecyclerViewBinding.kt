package com.clakestudio.pc.readingassistant.books

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.clakestudio.pc.readingassistant.data.Book

object BooksRecyclerViewBinding {

    @BindingAdapter("app:books")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, books: ArrayList<Book>) {
        with(recyclerView.adapter as BooksAdapter) {
            replaceData(books)
        }
    }

}