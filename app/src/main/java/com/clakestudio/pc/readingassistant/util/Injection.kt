package com.clakestudio.pc.readingassistant.util

import android.content.Context
import com.clakestudio.pc.readingassistant.data.source.BooksRepository
import com.clakestudio.pc.readingassistant.data.source.local.BooksLocalDataSource
import com.clakestudio.pc.readingassistant.data.source.local.LibraryDatabase

object Injection {

    fun provideTasksRepository(context: Context): BooksRepository {
        val database = LibraryDatabase.getInstance(context)
        return BooksRepository.getInstance(BooksLocalDataSource.getInstance(database.booksDao()))
    }
}