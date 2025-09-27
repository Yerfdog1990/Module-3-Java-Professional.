package com.codegym.games.racer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FinishLineTest {

    @Test
    void show() {
        FinishLine finishLine = new FinishLine();
        finishLine.show();
        assertTrue(finishLine.isVisible);
    }
}