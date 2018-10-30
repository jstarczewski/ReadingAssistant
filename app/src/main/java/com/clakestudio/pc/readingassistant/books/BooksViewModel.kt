package com.clakestudio.pc.readingassistant.books

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import android.databinding.ObservableArrayList
import android.util.Log
import com.clakestudio.pc.readingassistant.data.Book
import com.clakestudio.pc.readingassistant.data.source.BooksRepository
import com.clakestudio.pc.readingassistant.util.DisposableManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class BooksViewModel(
        context: Application,
        private val booksRepository: BooksRepository
) : AndroidViewModel(context) {

    private val context: Context = context.applicationContext

    val books: ObservableArrayList<Book> = ObservableArrayList()


    private fun loadBooks() {

        /**
         * Turns out that Disposable Manager is redutant and caused problems with refreshing ui
         * -it will be remvoed after merge
         *
         * */

       val disposable = booksRepository.getBooks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    this.books.clear()
                    this.books.addAll(it)
                    loadBooks()
                    Log.e("Lista ->", books.toString())
                }, { t: Throwable -> t.printStackTrace() })
        DisposableManager.getInstance().addDisposable(disposable)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun unsubscribeViewModel() {
        DisposableManager.getInstance().clearDisposables()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun start() {
        loadBooks()
    }
}