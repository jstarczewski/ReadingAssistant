package com.clakestudio.pc.readingassistant.data.source.local

import com.clakestudio.pc.readingassistant.data.Book
import com.clakestudio.pc.readingassistant.data.source.BooksDataSource
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class BooksLocalDataSource(val booksDao: BooksDao) : BooksDataSource {


    val allCompositeDisposable: MutableList<Disposable> = arrayListOf()


    override fun getBooks(): List<Book> {
        var books: MutableList<Book> = ArrayList<Book>()
        val disposable = booksDao.getBooks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    booksList -> books = transform(booksList)
                }, {t: Throwable? -> t?.printStackTrace() })
        allCompositeDisposable.add(disposable)
        return books

    }

    private fun transform(books : List<Book>) : ArrayList<Book> {
        val booksList: ArrayList<Book> = ArrayList<Book>()
        books.forEach {
            booksList.add(Book(it.title, it.author, it.note, it.id))
        }
        return booksList
    }

    override fun saveBook(book: Book) {

        Flowable.fromCallable{ booksDao.insertBook(book)}
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe()
    }


}