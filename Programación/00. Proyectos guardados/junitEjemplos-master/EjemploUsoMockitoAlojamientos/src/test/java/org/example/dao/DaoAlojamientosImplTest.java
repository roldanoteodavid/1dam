package org.example.dao;

import org.assertj.core.api.Assertions;
import org.example.common.ComparacionPorCategoriaNombre;
import org.example.domain.Alojamiento;
import org.example.domain.CasaRural;
import org.example.domain.Hotel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class DaoAlojamientosTest {
    @InjectMocks DaoAlojamientosImpl daoAlojamientos;

    @Mock Database database;

    @Test
    void getListaAlojamientos() {

        //given
        List<Alojamiento> lista = new ArrayList<>();
        lista.add(new Hotel("Mario", "Madrid", 45, new ArrayList<>(), 5));
        lista.add(new Hotel("David", "Murcia", 30, new ArrayList<>(), 3));

        //when
        when(database.getListaAlojamientos()).thenReturn(lista);

        List<Alojamiento> result = daoAlojamientos.getListaAlojamientos();

        //then;
        assertAll(
                () -> assertThat(result).isEqualTo(lista),
                () -> assertThat(result).isNotNull()
        );
    }

    @Nested
    class AddAlojamiento {
        @Test
        void addAlojamientoVacio() {
            //given
            Hotel hotel = new Hotel("hotel1", "Lugo", 100.3, new ArrayList<>(List.of(3, 5, 4)), 5);
            //when
            when(database.getListaAlojamientos()).thenReturn(new ArrayList<>());
            boolean respuesta = daoAlojamientos.addAlojamiento(hotel);

            //then
            assertThat(respuesta).isEqualTo(true);
        }

        @Test
        void addAlojamientoNoVacio() {
            //given
            Hotel hotel = new Hotel("hotel1", "Lugo", 100.3, new ArrayList<>(List.of(3, 5, 4)), 5);
            ArrayList<Alojamiento> alojamientos = new ArrayList<>();
            alojamientos.add(new Hotel("Mario", "Madrid", 45, new ArrayList<>(), 5));
            alojamientos.add(new Hotel("David", "Murcia", 30, new ArrayList<>(), 3));
            alojamientos.add(new Hotel("Carlota", "Madrid", 63, new ArrayList<>(), 4));

            //when
            when(database.getListaAlojamientos()).thenReturn(alojamientos);
            boolean respuesta = daoAlojamientos.addAlojamiento(hotel);
            //then
            assertThat(respuesta).isEqualTo(true);
        }
    }

    @Test
    void consulta() {
        //Given
        List<Alojamiento> alojamientos = new ArrayList<>();
        Alojamiento hotel1 = new Hotel("Carlota", "Valencia", 63, new ArrayList<>(), 4);
        Alojamiento hotel2 = new Hotel("Mario", "Valencia", 45, new ArrayList<>(), 5);
        Alojamiento hotel3 = new Hotel("Mario", "Madrid", 45, new ArrayList<>(), 5);
        Alojamiento cr =new CasaRural("Ahmed", "Valencia", 24, new ArrayList<>(List.of(3, 5, 4)), true);
        alojamientos.add(hotel2);
        alojamientos.add(hotel1);
        alojamientos.add(hotel3);
        alojamientos.add(new CasaRural("Miguel", "Murcia", 20, new ArrayList<>(), true));
        alojamientos.add(new CasaRural("Jorge", "Madrid", 25, new ArrayList<>(), false));
        alojamientos.add(cr);
        Random r = new Random();
        for (Alojamiento alojamiento : alojamientos) {
            alojamiento.getValoraciones().add(r.nextInt(1, 6));
            alojamiento.getValoraciones().add(r.nextInt(1, 6));
            alojamiento.getValoraciones().add(r.nextInt(1, 6));
            alojamiento.getValoraciones().add(r.nextInt(1, 6));
            alojamiento.getValoraciones().add(r.nextInt(1, 6));
            alojamiento.getValoraciones().add(r.nextInt(1, 6));
        }

        //When

        when(database.getListaAlojamientos()).thenReturn(alojamientos);

        List<Alojamiento> respuesta = daoAlojamientos.consulta("Valencia", 20, 70);

        //then
        assertAll(
                () -> Assertions.assertThat(respuesta).contains(hotel1),
                () -> Assertions.assertThat(respuesta).contains(hotel2),
                () -> Assertions.assertThat(respuesta).contains(cr),
                () -> Assertions.assertThat(respuesta).doesNotContain(hotel3),
                () -> Assertions.assertThat(respuesta).size().isEqualTo(3)
        );

    }

    @Test
    void alojamientosPorValoracionMedia() {
        //given
        List<Alojamiento> lista = new ArrayList<>();
        Hotel hotel1 = new Hotel("Intercontinental", "Madrid", 145, new ArrayList<>(List.of(2, 3, 2)), 5);
        Hotel hotel2 = new Hotel("Tryp", "Murcia", 90, new ArrayList<>(List.of(3, 5, 4)), 1);
        Hotel hotel3 = new Hotel("Silken", "Madrid", 100, new ArrayList<>(List.of(4, 5, 4)), 2);
        Hotel hotel4 = new Hotel("Melia", "Murcia", 80, new ArrayList<>(List.of(3, 5, 4)), 4);
        lista.add(hotel1);
        lista.add(hotel2);
        lista.add(hotel3);
        lista.add(hotel4);


        //when
        when(database.getListaAlojamientos()).thenReturn(lista);
        List<Alojamiento> respuesta = daoAlojamientos.alojamientosPorValoracionMedia("Madrid");

        //then
        assertAll(
                () -> assertThat(respuesta).contains(hotel1),
                () -> assertThat(respuesta).contains(hotel3),
                () -> assertThat(respuesta).isNotEqualTo(lista),
                () -> assertThat(respuesta).size().isEqualTo(2),
                () -> assertThat(respuesta).containsExactly(hotel1,hotel3));
    }

    @Nested
    public class Actualizacion {
        @Test
        void actualizarCategoriaExistente() {
            //given
            List<Alojamiento> lista = new ArrayList<>();
            Hotel hotel1 = new Hotel("Mario", "Madrid", 45, new ArrayList<>(), 5);
            lista.add(hotel1);
            String nombre = "Mario";
            int categoriaNueva = 2;
            //when
            when(database.getListaAlojamientos()).thenReturn(lista);
            boolean result = daoAlojamientos.actualizarCategoria(nombre, categoriaNueva);
            //then
            assertTrue(result);
        }
        @Test
        void actualizarCategoriaHotelNoExistente() {
            //given
            List<Alojamiento> lista = new ArrayList<>();
            Hotel hotel1 = new Hotel("Mario", "Madrid", 45, new ArrayList<>(), 5);
            lista.add(hotel1);
            String nombre = "Silken";
            int categoriaNueva = 3;

            //when
            when(database.getListaAlojamientos()).thenReturn(lista);

            boolean result = daoAlojamientos.actualizarCategoria(nombre, categoriaNueva);

            //then
            assertFalse(result);
        }

    }

    @Test
    void consultaHotelesOrdenados() {
        //given
        List<Alojamiento> lista = new ArrayList<>();
        Hotel hotel1 = new Hotel("Mario", "Madrid", 45, new ArrayList<>(), 5);
        Hotel hotel2 = new Hotel("David", "Murcia", 30, new ArrayList<>(), 1);
        Hotel hotel3 = new Hotel("Sanchez", "Murcia", 50, new ArrayList<>(), 2);
        Hotel hotel4 = new Hotel("David", "Mérida", 30, new ArrayList<>(), 2);
        lista.add(hotel1);
        lista.add(hotel2);
        lista.add(hotel3);
        lista.add(hotel4);

        boolean ascendente = true;

        //when
        when(database.getListaAlojamientos()).thenReturn(lista);
        List<Hotel> respuesta = daoAlojamientos.consultaHoteles(ascendente);

        //then
        assertAll(
                () -> assertThat(lista).isNotEqualTo(respuesta),
                () -> assertThat(lista.stream().filter(alojamiento->alojamiento instanceof Hotel)
                        .map(alojamiento->(Hotel)alojamiento)
                        .sorted(new ComparacionPorCategoriaNombre())
                        .collect(Collectors.toList())).isEqualTo(respuesta)
        );
    }
    @Test
    void getListaAlojamientosProvincia() {
        //given
        List<Alojamiento> lista = new ArrayList<>();
        Hotel hotel1 = new Hotel("Mario", "Madrid", 45, new ArrayList<>(), 5);
        Hotel hotel2 = new Hotel("David", "Murcia", 30, new ArrayList<>(), 1);
        Hotel hotel3 = new Hotel("Sanchez", "Madrid", 50, new ArrayList<>(), 2);
        Hotel hotel4 = new Hotel("David", "Murcia", 30, new ArrayList<>(), 4);
        lista.add(hotel1);
        lista.add(hotel2);
        lista.add(hotel3);
        lista.add(hotel4);

        String provincia = "Murcia";
        String wrongProvincia = "Madrid";

        //when
        when(database.getListaAlojamientos()).thenReturn(lista);
        List<Alojamiento> result = daoAlojamientos.getListaAlojamientosProvincia(provincia);

        //then
        assertAll(
                () -> assertThat(lista).isNotEqualTo(result),
                () -> assertThat(result).doesNotContainAnyElementsOf(lista.stream()
                        .filter(alojamiento -> alojamiento.getProvincia().equals(wrongProvincia))
                        .collect(Collectors.toList()))
        );
    }

    @Test
    void removeAlojamiento() {
        //given
        List<Alojamiento> alojamientoLista = new ArrayList<>();
        Hotel hotel1 = new Hotel("Mario", "Madrid", 45, new ArrayList<>(), 5);
        Hotel hotel2 = new Hotel("David", "Murcia", 30, new ArrayList<>(), 1);
        alojamientoLista.add(hotel1);
        alojamientoLista.add(hotel2);

        //when
        when(database.getListaAlojamientos()).thenReturn(alojamientoLista);

        daoAlojamientos.removeAlojamiento(hotel1);

        //then
        assertAll(
                () -> Assertions.assertThat(alojamientoLista).doesNotContain(hotel1),
                () -> Assertions.assertThat(alojamientoLista).contains(hotel2)
        );
        verify(database, times(1)).getListaAlojamientos();
    }
    @Nested
    @DisplayName("isEmpty")
    public class estaVacia {
        @Test
        void isEmptyAlojamientosListVacio() {
            //given
            List<Alojamiento> lista = new ArrayList<>();
            //when
            when(database.getListaAlojamientos()).thenReturn(lista);
            boolean result = daoAlojamientos.isEmptyAlojamientosList();
            //then
            assertTrue(result);
        }

        @Test
        void isEmptyAlojamientosListLleno() {
            //given
            List<Alojamiento> lista = new ArrayList<>();
            lista.add(new Hotel("Mario", "Madrid", 45, new ArrayList<>(), 5));
            //when
            when(database.getListaAlojamientos()).thenReturn(lista);
            boolean result = daoAlojamientos.isEmptyAlojamientosList();
            //then
            assertFalse(result);
        }
    }
    @Test
    void setAlojamientos() {
        //given
        List<Alojamiento> lista = new ArrayList<>();
        lista.add(new Hotel("Mario", "Madrid", 45, new ArrayList<>(), 5));

        //when
        daoAlojamientos.setAlojamientos(lista);

        //then
        verify(database, times(1)).setListaAlojamientos(lista);
    }

}