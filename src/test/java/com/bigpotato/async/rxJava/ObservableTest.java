package com.bigpotato.async.rxJava;

import org.junit.Test;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func2;

/**
 * Created by hjy on 16/9/22.
 */
public class ObservableTest {
    @Test
    public void testObservable() {

        System.out.println("Thread ID: " + Thread.currentThread().getId() + "main");
        Observable<String> o1 = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread ID: " + Thread.currentThread().getId() + "o1");
                subscriber.onNext("hello");
                subscriber.onCompleted();
            }
        });


        Observable<String> o2 = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread ID: " + Thread.currentThread().getId() + "o2");
                subscriber.onNext("world");
                subscriber.onCompleted();
            }
        });
        System.out.println("Thread ID: " + Thread.currentThread().getId() + "main。。。。。。。。。。。。。");

        Observable.zip(o1, o2, new Func2<String, String, String>() {
            @Override
            public String call(String s1, String s2) {
                return s1 + s2;
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("Thread ID: " + Thread.currentThread().getId() + "zip");
                System.out.println(s);
            }
        });

        System.out.println("Thread ID: " + Thread.currentThread().getId() + "main");
    }
}
