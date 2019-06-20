static CompletableFuture<Integer> AccessTheWebAsyncNio(){
    final AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
    final CompletableFuture<Integer> promise = new CompletableFuture<>();
    asyncHttpClient
        .prepareGet("https://msdn.microsoft.com")
        .execute(new AsyncCompletionHandler<Response>(){
            @Override
            public Response onCompleted(Response resp) throws Exception {
                promise.complete(resp.getResponseBody().length());
                return resp;
            }
        });
    return promise;
}