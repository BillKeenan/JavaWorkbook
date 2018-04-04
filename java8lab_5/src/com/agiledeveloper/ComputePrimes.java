package com.agiledeveloper;

import static java.lang.Thread.sleep;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ComputePrimes {

  static AtomicLong countOfPrime = new AtomicLong();

  static final int max = 500000;


  public static boolean isPrime(long number) {
    boolean divisible = false;

    for (long i = 2; i < number; i++) {
      if (number % i == 0) {
        divisible = true;
        break;
      }
    }

    return number > 1 && !divisible;
  }

  public static long computeNumberOfPrimesBetween(long from, long to) {
    long count = 0;

    for (long i = from; i <= to; i++) {
      if (isPrime(i)) {
        count++;
      }
    }

    return count;
  }





  public static void single(String[] args) throws InterruptedException {

    System.out.println("running single");

    long startTime = System.nanoTime();


    long count = ComputePrimes.computeNumberOfPrimesBetween(0, max);

    long finished = System.nanoTime();

    System.out.println("RESULT:"+count +" found in " + max + " in " + TimeUnit.SECONDS.convert((finished - startTime), TimeUnit.NANOSECONDS));

  }


  public static void main(String[] args) throws InterruptedException {
        ComputePrimes.lab2();
  }

    public static CompletableFuture<Long> createTask(int input) {
        return CompletableFuture.supplyAsync(() -> {
            return ComputePrimes.computeNumberOfPrimesBetween(1, input);
        });
    }

    public static void lab2() throws InterruptedException {
      int[] numbers = new int[]{10000,800,100, 200, 500};
        //int[] numbers = new int[]{100, 200};

        for (int n : numbers){
          createTask(n)
            .thenApply(data -> n+":"+data)
            .thenAccept(System.out::println)
            ;
      }

      sleep(10000);
  }

  public static void concurrent(String[] args) throws InterruptedException {

    System.out.println("running threaded");

    long startTime = System.nanoTime();

    int countOfCores = Runtime.getRuntime().availableProcessors();

    ExecutorService executorService = Executors.newFixedThreadPool(countOfCores);

    List<Future<Integer>> results = new ArrayList<>();


    int numForEach = ComputePrimes.max / countOfCores;

    System.out.print("Count of cores:"+countOfCores +" with each:"+numForEach);

    for (int i = 0; i < countOfCores; i++) {
      int start = numForEach * i +1;
      int end = numForEach * i + numForEach -1;
      executorService.submit(
              new Runnable() {
                @Override
                public void run() {
                  System.out.println("new thread:"+start+":"+ (start +end));
                  countOfPrime.addAndGet(ComputePrimes.computeNumberOfPrimesBetween(start, end));
                }
              }
      );
    }



    System.out.println("called the tasks to run...." + Thread.currentThread());

    executorService.shutdown();

    executorService.awaitTermination(10000, TimeUnit.SECONDS);

    long finished = System.nanoTime();
    System.out.println("RESULT:"+countOfPrime +" found in " + max + " in " + TimeUnit.SECONDS.convert((finished - startTime), TimeUnit.NANOSECONDS));

    ComputePrimes.single(args);
  }
}