package com.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Francisco Portillo (francisco.portillo@gmail.com)
 */
public class CompletableFutureExamplesTest {

    private CompletableFutureExamples examples;
    private final Long testThreadId;

    public CompletableFutureExamplesTest() {
        testThreadId = Thread.currentThread().getId();
    }

    @Before
    public void setup() {
        examples = new CompletableFutureExamples();
    }

    @Test
    public void supplyAsync() throws Exception {
        System.out.println(String.format("[%s] supplyAsync: ", testThreadId));
        examples.supplyAsync();
    }

    @After
    public void waitOnTearDown() throws InterruptedException {
        Thread.sleep(2000L);
    }

}