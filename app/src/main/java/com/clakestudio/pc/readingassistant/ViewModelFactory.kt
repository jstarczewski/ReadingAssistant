package com.clakestudio.pc.readingassistant

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.clakestudio.pc.readingassistant.books.BooksViewModel
import com.clakestudio.pc.readingassistant.data.source.BooksRepository
import com.clakestudio.pc.readingassistant.util.Injection

class ViewModelFactory private constructor(
        private val application: Application,
        private val booksRepository: BooksRepository
) : ViewModelProvider.NewInstanceFactory() {


    override fun <T : ViewModel> create(modelClass: Class<T>) =
            with(modelClass) {
                when {
                  isAssignableFrom(BooksViewModel::class.java) ->
                        BooksViewModel(application, booksRepository)
                    else ->
                        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
                }
            } as T

    companion object {

        @SuppressLint("StaticFieldLeak")
        @Volatile private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application) =
                INSTANCE ?: synchronized(ViewModelFactory::class.java) {
                    INSTANCE ?: ViewModelFactory(application, Injection.provideTasksRepository(application.applicationContext))
                            .also { INSTANCE = it }
                }


    }
}