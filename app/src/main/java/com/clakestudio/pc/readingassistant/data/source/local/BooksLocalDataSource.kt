package com.clakestudio.pc.readingassistant.data.source.local

import com.clakestudio.pc.readingassistant.data.Book
import com.clakestudio.pc.readingassistant.data.source.BooksDataSource
import com.clakestudio.pc.readingassistant.util.DisposableManager
import com.clakestudio.pc.readingassistant.util.Dispose
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class BooksLocalDataSource(private val booksDao: BooksDao) : BooksDataSource {

    // makes testing harder
    val disposableManager: DisposableManager = DisposableManager.getInstance()

    override fun getBooks(): List<Book> {

        var books: List<Book> = ArrayList()

        val booksDisposable = booksDao.getBooks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ list -> books = list }, { t: Throwable? -> t?.printStackTrace() })
        disposableManager.addDisposable(booksDisposable)
        return books
    }

    /*
    .subscribe({ books -> cachedBooks = books }, {t: Throwable? -> t?.printStackTrace()})
allCompositeDisposable.add(books)

}
*/
    override fun saveBook(book: Book) {
        Flowable.fromCallable { booksDao.insertBook(book) }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
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