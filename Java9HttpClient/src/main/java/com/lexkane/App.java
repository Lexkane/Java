package com.lexkane;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class App {
    public static void main( String[] args ) throws URISyntaxException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();
        //String url= "https://www.reddit.com";
        List<String> urlList = List.of("https://www.reddit.com", "https://github.com/", "https://medium.com/");
        //ExecutorService executor = Executors.newWorkStealingPool();

//        List<Callable<String>> callables = Arrays.asList(
//                () -> "task1",
//                () -> "task2",
//                () -> "task3");
        //Future<String> future = executorService.submit(urlList::get());
        // String result = future.get();
        //urlList.forEach(e-> executorService.submit(e));

        List<Callable<String>> urlLists = Arrays.asList(
                () -> "https://www.reddit.com",
                () -> "https://github.com/",
                () -> "https://medium.com/");

        ExecutorService executorService = Executors.newFixedThreadPool(3);


        List<Caller> futureList = new ArrayList<Caller>();
        for (String url : urlList) {
            Caller caller = new Caller(url);
            futureList.add(caller);
        }


        try {
            List<Future<Object>> futures = executorService.invokeAll(futureList);

            for (Future<Object> future : futures) {

                try {
                    Thread.sleep(1000);
                    System.out.println("____________________________________");
                    System.out.println("future.isDone = " + future.isDone());
                    System.out.println("future: call =" + future.get());
                  //  List<String> result = (List<String>) future.get();
                  //  for (String item : result) {
                    //    System.out.println(item);
                    //}
                    System.out.println("____________________________________");


                } catch (CancellationException | ExecutionException ce) {
                    ce.printStackTrace();
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                }
            }

        } catch (Exception err) {
            err.printStackTrace();
        }
        System.out.println("Completed");
        executorService.shutdown();

    
    }


 }

