package com.clakestudio.pc.readingassistant.util

class DisposableManager {





        companion object {

        private var INSTANCE: DisposableManager? = null

        @JvmStatic fun getInstance() =
                INSTANCE ?: synchronized(DisposableManager::class.java) {
                    INSTANCE ?: DisposableManager()
                            .also { INSTANCE = it }
                }


    }

}