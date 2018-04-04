package com.agiledeveloper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {


        double result = Files.lines(Paths.get("./docs/numbers.txt"))
                .mapToDouble(Double::parseDouble)
                .map(x -> x*2)
                .sum();


        System.out.println(result);


    }
}
