package com.clakestudio.pc.readingassistant.data.source.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.clakestudio.pc.readingassistant.data.Book

@Database(entities = arrayOf(Book::class), version = 1)
abstract class LibraryDatabase: RoomDatabase() {

    abstract fun booksDao(): BooksDao

    companion object {

    }

}