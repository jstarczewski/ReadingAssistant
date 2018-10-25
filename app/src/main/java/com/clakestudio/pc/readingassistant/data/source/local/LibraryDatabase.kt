package com.clakestudio.pc.readingassistant.data.source.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.clakestudio.pc.readingassistant.data.Book

@Database(entities = arrayOf(Book::class), version = 1)
abstract class LibraryDatabase: RoomDatabase() {

    abstract fun booksDao(): BooksDao

    companion object {

        private var INSTANCE : LibraryDatabase? = null

        private val lock = Any()

        fun getInstance(context: Context): LibraryDatabase {

            synchronized(lock) {
                if (INSTANCE == null)
                    INSTANCE = Room.databaseBuilder(context.applicationContext, LibraryDatabase::class.java, "Books.db")
                            .build()
            }

            return INSTANCE!!
        }
    }

}