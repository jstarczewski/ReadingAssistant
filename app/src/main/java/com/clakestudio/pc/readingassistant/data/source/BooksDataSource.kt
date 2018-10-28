package com.clakestudio.pc.readingassistant.data.source

import com.clakestudio.pc.readingassistant.data.Book
import io.reactivex.Flowable

interface BooksDataSource {


    fun getBooks() : Flowable<List<Book>>

    fun saveBook(book: Book)


}