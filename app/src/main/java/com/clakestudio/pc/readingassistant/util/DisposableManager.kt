package com.clakestudio.pc.readingassistant.util

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class DisposableManager {

    /**
     * Could not find any idea how to keep track of disposables, and easily clear them
     * so I created simple DisposableManager to easily clear them all when needed
     * --------------------------------------------------------------------------------
     *
     * I do not know whether it is a good approach to a problem, needs some more research
     *
     * */

    private var allDisposables: CompositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        allDisposables.add(disposable)
    }

    fun clearDisposables() {
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