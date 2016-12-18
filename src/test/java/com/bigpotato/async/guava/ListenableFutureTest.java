package com.bigpotato.async.guava;

import com.google.common.collect.Lists;
import com.google.common.collect.ObjectArrays;
import com.google.common.util.concurrent.*;
import org.junit.Test;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

/**
 * Created by hjy on 16/9/22.
 */
public class ListenableFutureTest {
    @Test
    public void testListenableFuture() {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        ListenableFuture<String> explosion1 = service.submit(new Callable<String>() {
            public String call() {
                try {
                    Thread.sleep(1000);
                    System.out.println("Thread ID: " + Thread.currentThread().getId() + "explosion1 call");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "hello";
            }
        });

        Futures.addCallback(explosion1, new FutureCallback<String>() {
            public void onSuccess(String explosion) {
                System.out.println("Thread ID: " + Thread.currentThread().getId() + "explosion1 callback");
                System.out.println("explosion = " + explosion);
            }
            public void onFailure(Throwable thrown) {
            }
        });

        ListenableFuture<Integer> explosion2 = service.submit(new Callable<Integer>() {
            public Integer call() {
                try {
                    Thread.sleep(2000);
                    System.out.println("Thread ID: " + Thread.currentThread().getId() + "explosion2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return 101;
            }
        });

        Futures.addCallback(explosion2, new FutureCallback<Integer>() {
            public void onSuccess(Integer explosion) {
                System.out.println("Thread ID: " + Thread.currentThread().getId() + "explosion2 callback");
                System.out.println("explosion = " + explosion);
            }
            public void onFailure(Throwable thrown) {
            }
        });
        ListenableFuture successFuture = Futures.allAsList(explosion1, explosion2);

        Futures.addCallback(successFuture, new FutureCallback<List<Object>>(){

            @Override
            public void onSuccess(@Nullable List<Object> strings) {
                System.out.println("Thread ID: " + Thread.currentThread().getId() + "success callback");

                System.out.println(strings);
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
        try {
            System.out.println("Thread ID: " + Thread.currentThread().getId() + "main");
            Thread.sleep(5000);
            System.out.println("Thread ID: " + Thread.currentThread().getId() + "main");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
