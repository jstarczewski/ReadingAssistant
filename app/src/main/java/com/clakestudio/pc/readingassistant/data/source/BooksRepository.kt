package com.clakestudio.pc.readingassistant.data.source

import com.clakestudio.pc.readingassistant.data.Book
import com.clakestudio.pc.readingassistant.data.source.local.BooksLocalDataSource
import com.clakestudio.pc.readingassistant.util.Dispose
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class BooksRepository(private val booksLocalDataSource: BooksDataSource) : BooksDataSource, Dispose {

    var cachedBooks: List<Book> = ArrayList()
    var cacheIsDirty = false
    var allDisposable: MutableList<Disposable> = arrayListOf()

    override fun getBooks(): List<Book> {

    }


    override fun saveBook(book: Book) {
        booksLocalDataSource.saveBook(book)
    }

    override fun addDisposable(disposable: Disposable) {

    }

    override fun clearDisposable() {

    }


    companion object {

        private var INSTANCE: BooksRepository? = null

        @JvmStatic
        fun getInstance(booksLocalDataSource: BooksDataSource) =
                INSTANCE ?: synchronized(BooksRepository::class.java) {
                    INSTANCE ?: BooksRepository(booksLocalDataSource)
                            .also { INSTANCE = it }
                }

        @JvmStatic
        fun destroyInstance() {
            INSTANCE = null
        }
    }

}