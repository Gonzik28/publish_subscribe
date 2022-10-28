package com.gonzik28.api;

import com.gonzik28.dto.NumberDto;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SubmissionPublisher;

import static com.gonzik28.dto.NumberDto.getNumberDto;

public class ProuderConsumer {
    public static void main(String args[]) {

        final int MAX_SIZE = 5;

        SubmissionPublisher<NumberDto> publisher = new SubmissionPublisher<>();
        APISubscriber subs = new APISubscriber();
        publisher.subscribe(subs); //подписка
        System.out.println("Publishing Items to Subscriber");

        BlockingQueue<NumberDto> queue = new ArrayBlockingQueue<>(MAX_SIZE);

        Runnable producer = () -> {
            while (true) {
                NumberDto job = getNumberDto();
                try {
                    Thread.sleep(10);
                    publisher.submit(job);
                    queue.put(job);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumer = () -> {
            while (true) {
                try {
                    NumberDto jobId = queue.take();
                    System.out.println("Consumer: processing job "
                            + jobId.getOne() + " * " + jobId.getTwo() + " = " + jobId.getOne() * jobId.getTwo());
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();

        new Thread(consumer).start();
        new Thread(consumer).start();
    }

}


