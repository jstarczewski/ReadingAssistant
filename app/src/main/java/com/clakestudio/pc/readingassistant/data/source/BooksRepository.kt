package com.clakestudio.pc.readingassistant.data.source

import com.clakestudio.pc.readingassistant.data.Book
import io.reactivex.Flowable

class BooksRepository(val booksLocalDataSource: BooksDataSource) : BooksDataSource {


    override fun getBooks(): Flowable<List<Book>> {
        return booksLocalDataSource.getBooks()
    }

    override fun saveBook(book: Book) {
        booksLocalDataSource.saveBook(book)
    }

        companion object {

        private var INSTANCE: BooksRepository? = null

        /**
         * Returns the single instance of this class, creating it if necessary.

         * @param tasksRemoteDataSource the backend data source
         * *
         * @param tasksLocalDataSource  the device storage data source
         * *
         * @return the [BooksRepository] instance
         */
        @JvmStatic fun getInstance(booksLocalDataSource: BooksDataSource) =
                INSTANCE ?: synchronized(BooksRepository::class.java) {
                    INSTANCE ?: BooksRepository(booksLocalDataSource)
                            .also { INSTANCE = it }
                }


        /**
         * Used to force [getInstance] to create a new instance
         * next time it's called.
         */
        @JvmStatic fun destroyInstance() {
            INSTANCE = null
        }
    }

}