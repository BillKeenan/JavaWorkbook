package com.agiledeveloper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Incrementor {
  public static int increment(int number) throws InterruptedException {

    AtomicInteger counter = new AtomicInteger();
    
    ExecutorService executorService = Executors.newFixedThreadPool(10);

    IntStream.rangeClosed(0,number).forEach(i -> executorService.submit(()-> counter.addAndGet(i)));
                               
    executorService.shutdown();
    executorService.awaitTermination(1000, TimeUnit.SECONDS);

    return counter.get();

  }
}