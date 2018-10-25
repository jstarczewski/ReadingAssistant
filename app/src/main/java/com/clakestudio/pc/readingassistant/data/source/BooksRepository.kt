package com.clakestudio.pc.readingassistant.data.source

import com.clakestudio.pc.readingassistant.data.Book

class BooksRepository(val booksLocalDataSource: BooksDataSource) : BooksDataSource {


    override fun getBooks(): List<Book> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveBook(book: Book) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}