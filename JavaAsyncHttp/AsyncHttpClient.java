CompletableFuture<Integer> AccessTheWebAsync()
{
    AsyncHttpClient asyncHttpClient = new DefaultAsyncHttpClient();
    return asyncHttpClient
       .prepareGet("http://msdn.microsoft.com")
       .execute()
       .toCompletableFuture()
       .thenApply(Response::getResponseBody)
       .thenApply(String::length);
}