package org.cs3380project.application.backend;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class BackendExampleTest {
    @DisplayName("Add operation test")
    @RepeatedTest(5)
    public void addNumber(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println("Running test -> " + repetitionInfo.getCurrentRepetition());
        Assertions.assertEquals(2, BackendExample.add(1, 1), "1 + 1 should equal 2");
    }

    @BeforeAll
    public static void init(){
        System.out.println("BeforeAll init() method called");
    }

    @BeforeEach
    public void initEach(){
        System.out.println("BeforeEach initEach() method called");
    }
}