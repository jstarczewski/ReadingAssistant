package com.clakestudio.pc.readingassistant.data.source

import com.clakestudio.pc.readingassistant.data.Book
import io.reactivex.Flowable

class BooksRepository(private val booksLocalDataSource: BooksDataSource) : BooksDataSource {

    var cachedBooks: ArrayList<Book> = arrayListOf()
    var cacheIsDirty = false

    /**
     * 1. If cachedBooks are not empty && are not dirty we just return them
     * 2. If cache is dirty because of operations that were performed and we can not skip the process of getting
     * the data from database we load data from local database (because right now there is no remote database)
     * and return cachedBooks
     * 3. if cachedBooks are empty we just load them from database
     * */


    // TODO("check whether it is better for loadBooks to return value or not")

    override fun getBooks(): Flowable<List<Book>> {
        return booksLocalDataSource.getBooks()
    }


    override fun saveBook(book: Book) {
        booksLocalDataSource.saveBook(book)
    }

    private fun loadBooks() {
        cacheIsDirty = false
        cachedBooks = booksLocalDataSource.getBooks() as ArrayList<Book>
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