package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NotaTest {
    @BeforeAll
    static void inicio() {
        //aquí pondríamos por ejemplo si ponemos atributos, crear las instancias para luego utilizarlas, conexión a bbdd
        System.out.println("Bienvenido a mis Pruebas Unitarias");

    }

    @AfterAll
    static void despues() {
        //aquí pondríamos por ejemplo si ponemos atributos, crear las instancias para luego utilizarlas, conexión a bbdd
        System.out.println("Finalización de Pruebas Unitarias");
    }

    @BeforeEach
    void inicioCadaTest() {
        System.out.println("----Comienzo Test");
    }

    @AfterEach
    public void despuesCadaTest() {
        System.out.println("----Termina Test");
    }

    @Test
    void getCalificacion() {
        Nota nota = new Nota("matematicas", 0);
        String calificacion = nota.getCalificacion();
        assertEquals("MuyDeficiente", calificacion);

        Nota nota2 = new Nota("matematicas", 2);
        String calificacion2 = nota2.getCalificacion();
        assertEquals("MuyDeficiente", calificacion2);

        Nota nota3 = new Nota("matematicas", 3);
        String calificacion3 = nota3.getCalificacion();
        assertEquals("MuyDeficiente", calificacion3);
    }

    @Nested
    @DisplayName("Test agrupados en una clase")
    class testParametrized {
        @DisplayName("Nota insuficiente valor:2 standar valor: 0,3 limites nota")
        @ParameterizedTest
        @ValueSource(ints = {2, 0, 3})
        void getCalificacionParametrized(double valorNota) {
            Nota nota2 = new Nota("matematicas", valorNota);
            String calificacion = nota2.getCalificacion();
            assertEquals("MuyDeficiente", calificacion);
        }

        //Importante para cada valor se ejecuta un test, por lo tanto beforeEach y afterEach,
        // se ejecutan 9 test parametrizados y uno normal
        @ParameterizedTest
        @CsvSource({"0,0,0",
                "1,1,2",
                "2,2,4"})
        void suma(int a, int b, int resultado) {
            assertEquals(resultado, Nota.suma(a, b));
        }

        @ParameterizedTest
        @MethodSource("values")
        void getCalificacionParametrizedMethod(double argumento) {
            Nota nota2 = new Nota("matematicas", argumento);
            String calificacion = nota2.getCalificacion();
            assertEquals("MuyDeficiente", calificacion);
        }

        public static Stream<Double> values() {
            return Stream.of(0.0, 2.4, 2.9);
        }
    }

    @DisplayName("Probando excepciones")
    @Nested
    class probandoExcepciones {
        @DisplayName("Verificando que lanza una excepción")
        @Test
        void setValorIncorrecto() {
            Nota nota = new Nota("matematicas", 2);
            Exception e = assertThrows(RuntimeException.class, () -> nota.setValor(-2));
            assertEquals("valor de nota no valido",e.getMessage());
        }
        @DisplayName("Verificando que no lanza una excepción")
        @Test
        void setValorCorrecto() {
            Nota nota = new Nota("matematicas", 2);
            assertDoesNotThrow(() -> {
                nota.setValor(8);
            });
        }
    }
}