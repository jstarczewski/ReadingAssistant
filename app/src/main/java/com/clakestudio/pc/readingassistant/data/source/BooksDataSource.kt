package com.clakestudio.pc.readingassistant.data.source

import com.clakestudio.pc.readingassistant.data.Book

interface BooksDataSource {

    fun getBooks() : List<Book>

    fun saveBook(book: Book)


}