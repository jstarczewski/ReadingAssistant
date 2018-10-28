package com.clakestudio.pc.readingassistant.util

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class DisposableManager {


    private var allDisposables: CompositeDisposable = CompositeDisposable()

    public fun addDisposable(disposable: Disposable) {
        allDisposables.add(disposable)
    }

    public fun clearDisposables() {
        allDisposables.clear()
    }

    companion object {

        private var INSTANCE: DisposableManager? = null

        @JvmStatic
        fun getInstance() =
                INSTANCE ?: synchronized(DisposableManager::class.java) {
                    INSTANCE ?: DisposableManager()
                            .also { INSTANCE = it }
                }


    }

}