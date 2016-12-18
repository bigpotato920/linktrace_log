package com.bigpotato.async.hystrix;

import org.junit.Test;
import rx.Observable;
import rx.Observer;
import rx.functions.Func2;


/**
 * Created by hjy on 16/9/20.
 */
public class TestHystrixObservable {
    @Test
    public void testObservable() {
        Observable<String> helloObservable = new HelloCommand("1").observe();
        Observable<String> worldObservable = new WorldCommand("2").observe();

        Observable.zip(helloObservable, worldObservable, new Func2<String, String, String>() {
            @Override
            public String call(String s1, String s2) {
                System.out.println("Thread ID: " + Thread.currentThread().getId() + "zip");

                return s1 + s2;
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("complete...");
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("Thread ID: " + Thread.currentThread().getId() + "zipcallback");
                System.out.printf(s);
            }
        });

        try {
            System.out.println("Thread ID: " + Thread.currentThread().getId() + "main");

            Thread.sleep(1000);
            System.out.println("Thread ID: " + Thread.currentThread().getId() + "main");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
