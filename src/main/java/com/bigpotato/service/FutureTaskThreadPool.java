package com.bigpotato.service;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

/**
 * API异步任务调度线程池
 * Created by hjy on 16/7/12.
 */
@Service
public class FutureTaskThreadPool {
    private static final Logger logger = LoggerFactory.getLogger(FutureTaskThreadPool.class);

    private static ThreadPoolExecutor executorPool;
    static{
        executorPool = new ThreadPoolExecutor(40, 60, 10, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(100),
                new ThreadFactoryBuilder().setNameFormat("FutureTaskThreadPool").build());
    }

    public <T> Future<T> submitTask(Callable<T> callable) {
        Future<T> future = null;
        try {
            future = executorPool.submit(callable);
        } catch (Exception e) {
            logger.warn("#FutureTaskThreadPool submitTask#", e);
        }

        return future;
    }

    @Scheduled(fixedRate = 5 * 60 * 1000)
    public void printThreadPoolStatus() {

        int activeCount = executorPool.getActiveCount();
        long taskCount = executorPool.getTaskCount();
        int queueSize = executorPool.getQueue().size();
        long completedTaskCount = executorPool.getCompletedTaskCount();

        int queueThresholdSize = 50;
        String msg = "队列大小:%s, 加入到线程池的任务数:%s, 正在执行任务数:%s, 执行完的任务数: %s";
        if (queueSize >= queueThresholdSize) {
            logger.error("#FutureTaskThreadPool printThreadPoolStatus#{}",
                    String.format(msg, queueSize, taskCount, activeCount, completedTaskCount));
        } else {
            logger.warn("#FutureTaskThreadPool printThreadPoolStatus#{}",
                    String.format(msg, queueSize, taskCount, activeCount, completedTaskCount));
        }
    }
}
