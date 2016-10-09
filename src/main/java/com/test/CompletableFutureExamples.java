package com.test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

/**
 * @author Francisco Portillo (francisco.portillo@gmail.com)
 */
public class CompletableFutureExamples {

    private final Long threadId;

    public CompletableFutureExamples() {
        threadId = Thread.currentThread().getId();
    }

    public void supplyAsync() throws ExecutionException, InterruptedException {
        CompletableFuture
            .supplyAsync(this::sendRequest)
            .thenApply(this::processResponse)
            .thenAccept((response) -> log("Accept callback received " + response));
    }

    private String processResponse(String response) {
        try {
            log("Processing response...");
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response.toUpperCase();
    }

    private String sendRequest() {
        log("About to process a message...");
        try {
            Thread.sleep(500L);
            return "Message processed!";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Should have processed a message");
    }

    private void log(String message) {
        System.out.println(String.format("[%d] %s", threadId, message));
    }
}
