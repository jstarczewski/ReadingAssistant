package com.clakestudio.pc.readingassistant.util

import io.reactivex.Scheduler

interface SchedulerProvider {

    fun uiScheduler() : Scheduler
    fun ioScheduler() : Scheduler

}