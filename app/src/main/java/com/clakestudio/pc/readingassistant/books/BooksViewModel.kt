package com.clakestudio.pc.readingassistant.books

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import android.databinding.ObservableField
import com.clakestudio.pc.readingassistant.data.Book
import com.clakestudio.pc.readingassistant.data.source.BooksRepository
import com.clakestudio.pc.readingassistant.data.source.local.BooksLocalDataSource
import com.clakestudio.pc.readingassistant.data.source.local.LibraryDatabase
import com.clakestudio.pc.readingassistant.util.DisposableManager

class BooksViewModel(
        context: Application
) : AndroidViewModel(context) {

    private val context: Context = context.applicationContext //Application Context to avoid leaks.
    val infoLabel = ObservableField<String>()


    fun start() {

        var booksdb = LibraryDatabase.getInstance(context)
        var booksRepository = BooksRepository.getInstance(BooksLocalDataSource.getInstance(booksdb.booksDao()))
        booksRepository.saveBook(Book("elo", "twojastara", "je", "12"))

        infoLabel.set(booksRepository.getBooks().toString())

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun unsubscribeViewModel() {
        DisposableManager.getInstance().clearDisposables()
    }

}