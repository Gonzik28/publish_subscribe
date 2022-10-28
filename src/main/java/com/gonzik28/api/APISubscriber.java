package com.gonzik28.api;

import com.gonzik28.dto.NumberDto;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class APISubscriber<T extends NumberDto> implements Subscriber<T> {

    private Subscription subscription;
    private int counter = 0;

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(NumberDto item) {
        String text = "Example: " + item.getOne() + " * " + item.getTwo();
        System.out.println(text);
        subscription.request(1);
        counter++;
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {
        System.out.println("Done");
    }

    public int getCounter() {
        return counter;
    }
}
