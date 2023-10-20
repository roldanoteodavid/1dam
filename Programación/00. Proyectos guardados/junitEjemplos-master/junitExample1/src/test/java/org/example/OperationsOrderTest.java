package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

//@TestMethodOrder(MethodOrderer.MethodName.class)
//@TestMethodOrder(MethodOrderer.Random.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class OperationsOrderTest {
    @Order (5)
    @Test
    @DisplayName("sonPares")
    void sonPares() {
        assertTrue(Operations.sonPares(4, 6, 7, 7));
        assertFalse(Operations.sonPares(5, 6, 3));
        assertTrue(Operations.sonPares(3, 3, 3, 3));
    }
    @Order (3)
    @Test
    @DisplayName("add numbers")
    void addNumbers() {
        double actualNumber = Operations.addNumbers(2, 2);
        double expectedNumber = 4;
        assertEquals(expectedNumber, actualNumber);
    }
    @Order (4)
    @Test
    @DisplayName("multiply numbers")
    void multiplyNumbers() {
        assertAll(() -> assertEquals(4, Operations.multiplyNumbers(2, 2)),
                () -> assertEquals(32, Operations.multiplyNumbers(2, 2, 2, 2, 2)),
                () -> assertEquals(-6, Operations.multiplyNumbers(2, -3)));
    }

    @Order (2)
    @Test
    @DisplayName("media Array")
    void averageArray() {
        int[] testArray = {4, 6, 4, 6};
        //List<Integer> testArray = List.of(4,6,4,6);
        assertEquals(5, Operations.averageArray(testArray));
    }

    @Test
    @Order (1)
    @DisplayName("sortArrays")
    void sortArray() {
        int[] actualArray = {4, 6, 4, 6};
        Operations.sortArray(actualArray, true);
        int[] expectedArray = {4, 4, 6, 6};
        assertArrayEquals(expectedArray, actualArray);
    }

}