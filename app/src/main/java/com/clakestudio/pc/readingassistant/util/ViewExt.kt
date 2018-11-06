package com.clakestudio.pc.readingassistant.util

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.support.design.widget.Snackbar
import android.view.View
import com.clakestudio.pc.readingassistant.SingleLiveEvent

fun View.showSnackbar(message: String, length: Int) { Snackbar.make(this, message, length).show() }

fun View.setUpSnackbar(lifecycleOwner: LifecycleOwner, snackbarMessageLiveEvent: SingleLiveEvent<String>, length: Int) {
    snackbarMessageLiveEvent.observe(lifecycleOwner, Observer {
        it?.let { showSnackbar(it, length) }
    })
}