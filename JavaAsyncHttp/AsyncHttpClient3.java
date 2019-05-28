//blocking thread

static CompletableFuture<Integer> AccessTheWebAsync(){
    try(AsyncHttpClient asyncHttpClient = new AsyncHttpClient()){
        Future<Response> f = asyncHttpClient
            .prepareGet("https://msdn.microsoft.com")
            .execute();
        return CompletableFuture.supplyAsync(
            () -> return f.join().getResponseBody().length());
    }
}