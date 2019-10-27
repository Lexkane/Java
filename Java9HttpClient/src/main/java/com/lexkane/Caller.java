package com.lexkane;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

public class Caller implements Callable<Object> {
    String url;

    public Caller(String url) {
        this.url = url;
    }

    @Override
    public Object call() throws Exception {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();

        //CompletableFuture<Void> httpResponseFuture;
       List<String> responseList = new ArrayList<String>();

        final CompletableFuture<List<String>> objectCompletableFuture = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> {
                    // List<String> links = new Page(r.body(), host).links();
                     //List<String> responseList = new ArrayList<String>();
                    responseList.add(String.valueOf(response.statusCode()));
                    responseList.add(response.headers().toString());
                    responseList.add(response.body());
                    return null;
                });


        return responseList;

    }
}
//         httpResponseFuture=httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                .thenAccept(response -> {
//                    System.out.println(("Response status code: " + response.statusCode()));
//                    System.out.println(("Response headers: " + response.headers()));
//                    System.out.println("Response body: " + response.body());
//
//                    responseList.add(String.valueOf( response.statusCode()));
//                    responseList.add(response.headers().toString());
//                    responseList.add(response.body());
//                 }
//                );
//
//        HttpResponse<String> httpResponse= httpClient.send(request,HttpResponse.BodyHandlers.ofString());
//        responseList.add(String.valueOf( httpResponse.statusCode()));
//        responseList.add(httpResponse.headers().toString());
//        responseList.add(httpResponse.body());

//return responseList.toString();
//  }


//}
