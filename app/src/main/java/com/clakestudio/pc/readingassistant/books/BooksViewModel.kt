package com.clakestudio.pc.readingassistant.books

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.databinding.ObservableArrayList
import android.util.Log
import com.clakestudio.pc.readingassistant.data.Book
import com.clakestudio.pc.readingassistant.data.source.BooksRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class BooksViewModel(
        context: Application,
        private val booksRepository: BooksRepository
) : AndroidViewModel(context) {

    private var compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val books: ObservableArrayList<Book> = ObservableArrayList()
    val snackbarMessage = SingleLiveEvent<Int>()

    private fun loadBooks() {

        /**
         * Change error handling system
         * */

        val disposable = booksRepository.getBooks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    this.books.clear()
                    this.books.addAll(it)
                    loadBooks()
                },
                        { t: Throwable -> t.printStackTrace() })
        compositeDisposable.add(disposable)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun unsubscribeViewModel() {
        compositeDisposable.clear()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun start() = loadBooks()

}