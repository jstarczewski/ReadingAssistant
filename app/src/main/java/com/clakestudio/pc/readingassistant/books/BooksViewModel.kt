package com.clakestudio.pc.readingassistant.books

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import com.clakestudio.pc.readingassistant.data.Book
import com.clakestudio.pc.readingassistant.data.source.BooksRepository
import com.clakestudio.pc.readingassistant.util.DisposableManager

class BooksViewModel(
        context: Application,
        private val booksRepository: BooksRepository
) : AndroidViewModel(context) {

    private val context: Context = context.applicationContext

    val infoLabel = ObservableField<String>()
    val books: ObservableArrayList<Book> = ObservableArrayList()

    fun start() {
        booksRepository.saveBook(Book("elo", "dziala", "czy nie dziala", "12"))
        loadBooks()
    }

    private fun loadBooks() {


        var books: List<Book> = booksRepository.getBooks()
        for (book: Book in books)
            this.books.add(book)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun unsubscribeViewModel() {
        DisposableManager.getInstance().clearDisposables()
    }

}