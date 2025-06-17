package ru.job4j.ex;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
    @Test
    void whenCalcNegativeThenException() {
        Factorial factorial = new Factorial();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> factorial.calc(-3)
        );
        assertEquals("Number could not be less than 0", exception.getMessage());
    }

    @Test
    void whenCalc5Then120() { // Измененное название теста
        Factorial factorial = new Factorial();
        int result = factorial.calc(5);
        assertEquals(120, result);
    }
}