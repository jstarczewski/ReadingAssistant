package com.clakestudio.pc.readingassistant.util

import io.reactivex.disposables.Disposable

interface Dispose {

    fun addDisposable(disposable: Disposable)

    fun clearDisposable()
}