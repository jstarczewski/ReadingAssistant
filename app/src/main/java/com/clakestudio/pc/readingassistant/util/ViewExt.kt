package com.clakestudio.pc.readingassistant.util

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.support.design.widget.Snackbar
import android.view.View

fun View.showSnackbar(message: String, length: Int) = Snackbar.make(this, message, length)
fun View.setUpSnackbar(lifecycleOwner : LifecycleOwner, snackbarMessageLiveEvent: SingleLiveEvent<Int>, length: Int) {
    snackbarMessageLiveEvent.observer(lifecycleOwner, Observer {
        it?.let{showSnackbar(context.getString(it), length)}
    })
}