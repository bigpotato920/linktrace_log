package com.bigpotato.async.rxJava;

import org.junit.Test;
import rx.Observable;
import rx.Scheduler;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by hjy on 16/9/22.
 */
public class SchedulerTest {
    @Test
    public void testScheduler() {
//        String[] str = {"A", "B", "C"};
//        Observable.from(str)
//                .map(new Func1<String, String>() {
//                    @Override
//                    public String call(String s) {
//                        System.out.println(Thread.currentThread().getName() + "  map : " + s);
//                        return s + " Hi";
//                    }
//                })
//                .subscribeOn(Schedulers)
//                .observeOn(Schedulers.io())
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        System.out.println(Thread.currentThread().getName() + "  call : " + s);
//                    }
//                });
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}
