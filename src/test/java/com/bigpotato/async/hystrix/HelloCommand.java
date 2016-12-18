package com.bigpotato.async.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Created by hjy on 16/9/20.
 */
public class HelloCommand extends HystrixCommand<String> {
    private final String name;

    public HelloCommand(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }
    @Override
    protected String run() throws Exception {
        Thread.sleep(1000);
        System.out.println("Thread ID: " + Thread.currentThread().getId() + "HelloCommand");
        return "hello " + name;
    }
}
