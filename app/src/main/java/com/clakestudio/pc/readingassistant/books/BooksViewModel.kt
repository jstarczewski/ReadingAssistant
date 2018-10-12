package com.clakestudio.pc.readingassistant.books

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.content.Context

class BooksViewModel(
        context: Application
) : AndroidViewModel(context) {

    private val context: Context = context.applicationContext //Application Context to avoid leaks.


}