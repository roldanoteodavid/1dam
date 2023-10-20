package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class Operations2Test {
    private static int number;
    private final Operations2 op = new Operations2(); // O lo inicializamos aquí o en el método con anotación BeforeEach
    @BeforeAll
    static void inicio(){
        //aquí pondríamos por ejemplo si ponemos atributos (ojo estáticos, por lo que con cuidado), crear las instancias para luego utilizarlas, conexión a bbdd
        System.out.println("Bienvenido a mis Pruebas Unitarias");
    }
    @AfterAll
    static void despues(){
        //aquí pondríamos por ejemplo si ponemos atributos, crear las instancias para luego utilizarlas, conexión a bbdd
        System.out.println("Finalización de Pruebas Unitarias");
    }
    @BeforeEach
    void inicioCadaTest(){
        /*Cada test (método con anotación @Test) crea una instancia nueva de la clase en la que se encuentra, y antes de ejecutar
        el test ejecutará este método. EL inicializar aquí la instancia evita tener que declarar el atributo estático
        o inicializarla arriba*/
        // op = new Operations2();
        //OJO entre métodos de Test no se guarda el estado, de ahí que el number deba ser estático para hacer su cometido
        System.out.println("Prueba"+ (++number));
    }
    @AfterEach
    public void despuesCadaTest(){
        System.out.println("Prueba "+ number+ " terminada");
    }

    @Test
    @DisplayName("sonPares")
    void sonPares() {
        assertTrue(op.sonPares(4, 6, 7, 7));
        assertFalse( op.sonPares(5, 6, 3));
        assertTrue(op.sonPares(3, 3, 3, 3));
    }

    @Test
    @DisplayName("add numbers")
    void addNumbers() {
        double actualNumber = op.addNumbers(2, 2);
        double expectedNumber = 4;
        assertEquals(expectedNumber, actualNumber);
    }

    @Test
    @DisplayName("multiply numbers")
    void multiplyNumbers() {
        assertAll(() -> assertEquals(4, op.multiplyNumbers(2, 2)),
                () -> assertEquals(32, op.multiplyNumbers(2, 2, 2, 2, 2)),
                () -> assertEquals(-6, op.multiplyNumbers(2, -3)));
    }

    @Test
    @DisplayName("media Array")
    void averageArray() {
        int[] testArray = {4, 6, 4, 6};
        //List<Integer> testArray = List.of(4,6,4,6);
        assertEquals(5, op.averageArray(testArray));
    }

    @Test
    void sortArray() {
        int[] actualArray = {4, 6, 4, 6};
        op.sortArray(actualArray, true);
        int[] expectedArray = {4, 4, 6, 6};
        assertArrayEquals(expectedArray, actualArray);
    }


}