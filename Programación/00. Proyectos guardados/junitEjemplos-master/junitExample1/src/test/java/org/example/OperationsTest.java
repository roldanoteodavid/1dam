package org.example;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OperationsTest {
    private static int number;

    @BeforeAll
    static void inicio(){
        //aquí pondríamos por ejemplo si ponemos atributos, crear las instancias para luego utilizarlas, conexión a bbdd
        System.out.println("Bienvenido a mis Pruebas Unitarias");

    }
    @AfterAll
    static void despues(){
        //aquí pondríamos por ejemplo si ponemos atributos, crear las instancias para luego utilizarlas, conexión a bbdd
        System.out.println("Finalización de Pruebas Unitarias");
    }
    @BeforeEach
    void inicioCadaTest(){
        System.out.println("Prueba"+ (++number));
    }
    @AfterEach
    public void despuesCadaTest(){
        System.out.println("Prueba "+ number+ " terminada");
    }
    @Test
    @DisplayName("sonPares")
    void sonPares() {
        assertTrue(Operations.sonPares(4, 6, 7, 7));
        assertFalse(Operations.sonPares(5, 6, 3));
        assertTrue(Operations.sonPares(3, 3, 3, 3));
    }

    @Test
    @DisplayName("add numbers")
    void addNumbers() {
        double actualNumber = Operations.addNumbers(2, 2);
        double expectedNumber = 4;
        assertEquals(expectedNumber, actualNumber);
    }

    @Test
    @DisplayName("multiply numbers")
    void multiplyNumbers() {
        assertAll(() -> assertEquals(4, Operations.multiplyNumbers(2, 2)),
                () -> assertEquals(32, Operations.multiplyNumbers(2, 2, 2, 2, 2)),
                () -> assertEquals(-6, Operations.multiplyNumbers(2, -3)));
    }

    @Test
    @DisplayName("media Array")
    void averageArray() {
        int[] testArray = {4, 6, 4, 6};
        //List<Integer> testArray = List.of(4,6,4,6);
        assertEquals(5, Operations.averageArray(testArray));
    }

    @Test
    void sortArray() {
        int[] actualArray = {4, 6, 4, 6};
        Operations.sortArray(actualArray, true);
        int[] expectedArray = {4, 4, 6, 6};
        assertArrayEquals(expectedArray, actualArray);
    }


}