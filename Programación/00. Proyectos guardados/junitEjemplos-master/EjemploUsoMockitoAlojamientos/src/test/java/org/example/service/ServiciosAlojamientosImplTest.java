package org.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.assertj.core.api.AbstractBooleanAssert;
import org.assertj.core.api.Assertions;
import org.example.common.CategoriaException;
import org.example.dao.DaoAlojamientos;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ServiciosAlojamientosImplTest {

    @InjectMocks
    ServiciosAlojamientosImpl serviciosAlojamientosImpl;

    @Mock
    DaoAlojamientos daoAlojamientos;


    @Test
    void getListaAlojamientos() {
        //Given GWT ó AAA Arrange Act Assert
        List<Alojamiento> alojamientos = new ArrayList<>();
        alojamientos.add(new Hotel("Melia Valencia", "Valencia", 45, new ArrayList<>(), 5));
        alojamientos.add(new Hotel("Parador de Vielha", "Lleida", 30, new ArrayList<>(), 3));
        alojamientos.add(new Hotel("Hotel Jardín Tropical", "Tenerife", 63, new ArrayList<>(), 4));
        alojamientos.add(new CasaRural("Casa Edelweiss", "Huesca", 20, new ArrayList<>(), true));
        alojamientos.add(new CasaRural("Intercontinental House", "Barcelona", 25, new ArrayList<>(), false));
        alojamientos.add(new CasaRural("Casa Lis", "Santiago", 12, new ArrayList<>(), true));
        Random r = new Random();
        for (Alojamiento alojamiento : alojamientos) {
            alojamiento.getValoraciones().add(r.nextInt(1, 6));
            alojamiento.getValoraciones().add(r.nextInt(1, 6));
            alojamiento.getValoraciones().add(r.nextInt(1, 6));
            alojamiento.getValoraciones().add(r.nextInt(1, 6));
        }
        //alojamientos.stream().forEach(System.out::println);

        //When
        when(daoAlojamientos.getListaAlojamientos()).thenReturn(alojamientos);
        List<Alojamiento> respuesta = serviciosAlojamientosImpl.getListaAlojamientos();

        //Then
        assertThat(respuesta).isEqualTo(alojamientos);
    }

    @Test
    void isEmptyAlojamientosList() {
        //given
        when(daoAlojamientos.isEmptyAlojamientosList()).thenReturn(true);
        //when
        boolean respuesta = serviciosAlojamientosImpl.isEmptyAlojamientosList();
        //then
        assertThat(respuesta).isTrue();
        //assertTrue(respuesta);
    }

    @DisplayName("Probando excepciones")
    @Nested
    public class Excepciones {
        @Test
        void addAlojamientoValido() {
            //given
            List<Integer> valoraciones = List.of((int) (Math.random() * 5 + 1), (int) (Math.random() * 5 + 1), (int) (Math.random() * 5 + 1), (int) (Math.random() * 5 + 1), (int) (Math.random() * 5 + 1));
            /*for (int i = 0; i < 5; i++) {
                valoraciones.add((int)(Math.random()*5+1));
            }*/
            Hotel h = new Hotel("Gema's Hotel", "Ibiza", 200, valoraciones, 5);

            //when
            when(daoAlojamientos.addAlojamiento(h)).thenReturn(true);
            boolean respuesta;
            try {
                respuesta = serviciosAlojamientosImpl.addAlojamiento(h);
            } catch (CategoriaException e) {
                throw new RuntimeException(e);
            }

            //then
            assertThat(respuesta).isTrue();
        }

        @Test
        void addAlojamientoCategoriaErronea() {
            //given
            ArrayList<Integer> valoraciones = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                valoraciones.add((int) (Math.random() * 5 + 1));
            }
            Hotel h = new Hotel("Gema", "Mallorca", 250, valoraciones, 8);

            //when
            //when(daoAlojamientos.addAlojamiento(h)).thenReturn(false); //da error porque ni siquiera se llama al dao, el servicio lo para antes
            boolean respuesta = false;
            try {
                respuesta = serviciosAlojamientosImpl.addAlojamiento(h);
            } catch (CategoriaException e) {
                assertThat(e.getMessage()).isEqualToIgnoringCase("La categoria debe estar entre 1 y 5");
                assertThat(respuesta).isFalse();
            }

            //then
            verify(daoAlojamientos,times(0)).addAlojamiento(h);
        }
    }

    @Test
    void consultaProvinciaRangoPrecios() {
        //Given
        List<Alojamiento> alojamientos = new ArrayList<>();
        alojamientos.add(new Hotel("Mario", "Murcia", 45, new ArrayList<>(), 5));
        alojamientos.add(new Hotel("David", "Murcia", 30, new ArrayList<>(), 3));
        alojamientos.add(new Hotel("Carlota", "Murcia", 63, new ArrayList<>(), 4));
        alojamientos.add(new CasaRural("Miguel", "Murcia", 20, new ArrayList<>(), true));
        alojamientos.add(new CasaRural("Jorge", "Murcia", 25, new ArrayList<>(), false));
        alojamientos.add(new CasaRural("Ahmed", "Murcia", 24, new ArrayList<>(List.of(3, 5, 4)), true));
        Random r = new Random();
        for (Alojamiento alojamiento : alojamientos) {
            alojamiento.getValoraciones().add(r.nextInt(1, 6));
            alojamiento.getValoraciones().add(r.nextInt(1, 6));
            alojamiento.getValoraciones().add(r.nextInt(1, 6));
            alojamiento.getValoraciones().add(r.nextInt(1, 6));
        }

        //When
        when(daoAlojamientos.consulta("Murcia", 20, 70)).thenReturn(alojamientos);
        List<Alojamiento> respuesta = serviciosAlojamientosImpl.consulta("Murcia", 20, 70);

        //Then
        assertThat(respuesta.size()).isEqualTo(6);
        assertThat(respuesta).isEqualTo(alojamientos);
    }

    @Test
    void consultaHoteles() {
        //given
        Hotel hotel1 = new Hotel("Mario", "Madrid", 45, new ArrayList<>(List.of(1, 1, 1)), 5);
        Hotel hotel2 = new Hotel("David", "Murcia", 30, new ArrayList<>(List.of(2, 2, 2)), 3);
        Hotel hotel3 = new Hotel("Carlota", "Madrid", 63, new ArrayList<>(List.of(4, 4, 4)), 4);

        //When
        when(daoAlojamientos.consultaHoteles(true)).thenReturn(new ArrayList<>(List.of(hotel1, hotel2, hotel3)));
        List<Hotel> respuesta = serviciosAlojamientosImpl.consultaHoteles(true);

        //Then
        assertThat(respuesta).containsExactly(hotel1, hotel2, hotel3);
    }

    @DisplayName("Actualizando categorías")
    @Nested
    public class ActualizarCategoria {
        @Test
        void actualizarCategoriaValida() {
            //given
            Hotel hotel = new Hotel("Carlota", "Madrid", 63, new ArrayList<>(List.of(4, 4, 4)), 4);
            //When
            when(daoAlojamientos.actualizarCategoria(hotel.getNombre(), 5)).thenReturn(true);
            boolean respuesta;
            try {
                respuesta = serviciosAlojamientosImpl.actualizarCategoria(hotel.getNombre(), 5);
            } catch (CategoriaException e) {
                throw new RuntimeException(e);
            }
            //Then
            assertThat(respuesta).isEqualTo(true);
            verify(daoAlojamientos, times(1)).actualizarCategoria(hotel.getNombre(), 5);
        }

        @Test
        void actualizarCategoriaNoValida() {
            //given
            Hotel hotel = new Hotel("Carlota", "Madrid", 63, new ArrayList<>(List.of(4, 4, 4)), 4);

            //When
            try {
                serviciosAlojamientosImpl.actualizarCategoria(hotel.getNombre(), 10);
            } catch (CategoriaException e) {
                assertThat(e.getMessage().equalsIgnoreCase("La categoria debe estar entre 1 y 5")).isTrue();
            }
            //Then
            verify(daoAlojamientos, times(0)).actualizarCategoria("Carlota", 10);
        }

    }

    @Test
    void getListaAlojamientosProvincia() {
        //Given
        List<Alojamiento> alojamientos = new ArrayList<>();
        alojamientos.add(new Hotel("Mario", "Madrid", 45, new ArrayList<>(List.of(4, 4, 4)), 5));
        alojamientos.add(new Hotel("Carlota", "Madrid", 63, new ArrayList<>(List.of(5, 5, 5)), 4));
        alojamientos.add(new CasaRural("Jorge", "Madrid", 25, new ArrayList<>(List.of(3, 3, 3)), false));

        //When
        when(daoAlojamientos.getListaAlojamientosProvincia("Madrid")).thenReturn(alojamientos);
        List<Alojamiento> respuesta = serviciosAlojamientosImpl.getListaAlojamientosProvincia("Madrid");

        //Then
        //assertThat(respuesta).isEqualTo(alojamientos);
        assertAll(
                () -> Assertions.assertThat(respuesta).isNotEmpty(),
                () -> Assertions.assertThat(respuesta).isEqualTo(alojamientos)
        );

    }


    @Test
    void removeAlojamiento() {
        //given
        Hotel hotel = new Hotel("Carlota", "Madrid", 63, new ArrayList<>(List.of(4, 4, 4)), 4);
        //When
        serviciosAlojamientosImpl.removeAlojamiento(hotel);
        //Then
        verify(daoAlojamientos, times(1)).removeAlojamiento(hotel);
    }


}