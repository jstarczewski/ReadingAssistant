package com.clakestudio.pc.readingassistant.data.source.local

import com.clakestudio.pc.readingassistant.data.Book
import com.clakestudio.pc.readingassistant.data.source.BooksDataSource
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class BooksLocalDataSource(private val booksDao: BooksDao) : BooksDataSource {

    override fun getBooks(): Flowable<List<Book>> {
        return booksDao.getBooks()
    }

    override fun saveBook(book: Book) {

        Flowable.fromCallable { booksDao.insertBook(book) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }

    companion object {
        private var INSTANCE: BooksLocalDataSource? = null

        @JvmStatic
        fun getInstance(booksDao: BooksDao): BooksLocalDataSource {
            if (INSTANCE == null) {
                synchronized(BooksLocalDataSource::javaClass) {
                    INSTANCE = BooksLocalDataSource(booksDao)
                }
            }
            return INSTANCE!!
        }

    }


}