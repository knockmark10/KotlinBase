package com.markoid.core.domain.executors

import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JobExecutor @Inject constructor() : ThreadExecutor {

    private val threadPoolExecutor: ThreadPoolExecutor by lazy {
        ThreadPoolExecutor(
            3,
            5,
            15,
            TimeUnit.SECONDS,
            LinkedBlockingQueue<Runnable>(),
            JobThreadFactory()
        )
    }

    override fun execute(command: Runnable?) {
        this.threadPoolExecutor.execute(command)
    }
}