package com.gonzik28.react;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import static com.gonzik28.react.Main.MAX_SIZE_LIMIT;

public class ReactSubscriber<T extends String> implements Subscriber<T> {

    private Subscription subscription;
    int onNextAmount;

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(MAX_SIZE_LIMIT);
    }

    @Override
    public void onNext(String item) {
        onNextAmount++;
        if (onNextAmount % MAX_SIZE_LIMIT == 0) {
            subscription.request(MAX_SIZE_LIMIT);
        }
        System.out.println(item);

    }

    @Override
    public void onError(Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }
}
