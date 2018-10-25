package com.clakestudio.pc.readingassistant.data.source.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.clakestudio.pc.readingassistant.data.Book
import io.reactivex.Flowable

@Dao interface BooksDao {


    @Query("SELECT * FROM Books")
    fun getBooks() : Flowable<Book>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBook(book: Book)

    /**
     * More methods gonna be implemented when needed
     * */



}