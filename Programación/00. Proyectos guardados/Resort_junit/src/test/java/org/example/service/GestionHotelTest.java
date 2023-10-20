package org.example.service;

import org.example.common.AlFrancesException;
import org.example.common.LugarException;
import org.example.common.TipoException;
import org.example.dao.DaoHotel;
import org.example.domain.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GestionHotelTest {
    @InjectMocks
    GestionHotel serviciosHotel;

    @Mock
    DaoHotel daoHotel;

    @BeforeAll
    static void inicio() {
        System.out.println("Pruebas unitarias");

    }

    @AfterAll
    static void despues() {
        System.out.println("Pruebas finalizadas");
    }

    @BeforeEach
    void inicioCadaTest() {
        System.out.println("Inicio Test");
    }

    @AfterEach
    public void despuesCadaTest() {
        System.out.println("Fin Test");
    }

    @Test
    void getHotel() {
        //given
        Hotel hotel = new Hotel();
        try {
            hotel.getActividades().add(new Actividad(1, "escalada", "rocodromo", 15));
            hotel.getActividades().add(new Actividad(2, "natación", "piscina", 10));
            hotel.getActividades().add(new Actividad(3, "badminton", "playa", 12));
            hotel.getActividades().add(new Actividad(4, "yoga", "gimnasio", 10));
        } catch (LugarException e) {
            throw new RuntimeException(e);
        }

        //when
        when(daoHotel.getHotel()).thenReturn(hotel);
        Hotel respuesta = serviciosHotel.getHotel();

        //then
        assertThat(respuesta).isEqualTo(hotel);
    }

    @Test
    void anyadirFechaActividad() {
        //given
        Actividad actividad;
        LocalDate fecha = LocalDate.of(2020, 7, 20);
        try {
            actividad = new Actividad(3, "badminton", "playa", 12);
        } catch (LugarException e) {
            throw new RuntimeException(e);
        }
        //when
        when(daoHotel.anyadirFechaActividad(fecha, actividad.getId())).thenReturn(true);
        boolean respuesta = serviciosHotel.anyadirFechaActividad(fecha, actividad.getId());
        assertThat(respuesta).isTrue();
    }

    @Test
    void clientesporPaisTest() {
        // Given
        Cliente cliente1 = null;
        Cliente cliente2 = null;
        Cliente cliente3 = null;
        try {
            cliente1 = new Cliente("Jose", "España");
            cliente2 = new Cliente("kimmich", "Alemania");
            cliente3 = new Cliente("Pepe", "España");
        } catch (AlFrancesException e) {
            throw new RuntimeException(e);
        }
        Map<String, List<Cliente>> esperado = new HashMap<>();
        esperado.put("España", Arrays.asList(cliente1, cliente3));
        esperado.put("Alemania", Arrays.asList(cliente2));

        // When
        when(daoHotel.clientesporPais()).thenReturn(esperado);
        Map<String, List<Cliente>> resultado = serviciosHotel.clientesporPais();

        // Then

        assertEquals(esperado, resultado);
    }


    @Test
    void numeroClientesPais() {
        // Given
        Cliente cliente1 = null;
        Cliente cliente2 = null;
        Cliente cliente3 = null;
        try {
            cliente1 = new Cliente("Jose", "España");
            cliente2 = new Cliente("kimmich", "Alemania");
            cliente3 = new Cliente("Pepe", "España");
        } catch (AlFrancesException e) {
            throw new RuntimeException(e);
        }
        Map<String, Long> esperado = new HashMap<>();
        esperado.put("España", 2L);
        esperado.put("Alemania", 1L);

        //when
        when(daoHotel.numeroClientesPais()).thenReturn(esperado);
        Map<String, Long> resultado = serviciosHotel.numeroClientesPais();

        //then
        assertEquals(esperado, resultado);
    }
    @Test
    void anyadirHabitacion() {
        // given
        Hotel hotel = new Hotel();
        Habitacion habitacion = null;
        try {
            habitacion = new Habitacion(2, 3, "King");
            hotel.getHabitaciones().add(habitacion);
        } catch (TipoException e) {
            throw new RuntimeException(e);
        }
        // when
        when(daoHotel.anyadirHabitacion(habitacion)).thenReturn(true);
        boolean respuesta = serviciosHotel.anyadirHabitacion(habitacion);
        //then
        assertThat(respuesta).isTrue();

    }

    @Test
    void borrarHabitacion() {
        // given
        Hotel hotel = new Hotel();
        Habitacion habitacion = null;
        try {
            habitacion = new Habitacion(2, 3, "King");
        } catch (TipoException e) {
            throw new RuntimeException(e);
        }
        // when
        when(daoHotel.borrarHabitacion(2)).thenReturn(true);
        boolean respuesta = serviciosHotel.borrarHabitacion(2);
        //then
        assertThat(respuesta).isTrue();

    }

    @Test
    void borrarHabitacionErronea() {
        // given
        Hotel hotel = new Hotel();
        Habitacion habitacion = null;
        try {
            habitacion = new Habitacion(2, 3, "King");
        } catch (TipoException e) {
            throw new RuntimeException(e);
        }
        hotel.getHabitaciones().add(habitacion);
        // when
        when(daoHotel.borrarHabitacion(2)).thenReturn(false);
        boolean respuesta = serviciosHotel.borrarHabitacion(2);
        //then
        assertThat(respuesta).isFalse();

    }

    @Test
    void listarHabitaciones() {
        //given
        Hotel hotel = new Hotel();
        try {
            hotel.getHabitaciones().add(new Habitacion(1, 4, "quad"));
            hotel.getHabitaciones().add(new Habitacion(2, 2, "doble"));
            hotel.getHabitaciones().add(new Habitacion(3, 2, "doble"));
        } catch (TipoException e) {
            throw new RuntimeException(e);
        }
        List<Habitacion> habitaciones = hotel.getHabitaciones();
        Collections.sort(habitaciones);
        hotel.setHabitaciones(habitaciones);

        //when
        when(daoHotel.listarHabitaciones(true)).thenReturn(hotel.getHabitaciones());
        List<Habitacion> respuesta = serviciosHotel.listarHabitaciones(true);

        //then
        assertThat(respuesta).isEqualTo(hotel.getHabitaciones());
    }

    @Test
    void addHabitacion() {
        // given
        Habitacion habitacion = null;
        try {
            habitacion = new Habitacion(1, 4, "quad");
        } catch (TipoException e) {
            throw new RuntimeException(e);
        }
        // when
        daoHotel.anyadirHabitacion(habitacion);

        //then
        verify(daoHotel, times(1)).anyadirHabitacion(habitacion);

    }

    @Test
    void addReserva() {
        // given
        Hotel hotel = new Hotel();
        Reserva reserva = null;
        Habitacion habitacion = null;
        try {
            habitacion = new Habitacion(2, 3, "King");
        } catch (TipoException e) {
            throw new RuntimeException(e);
        }
        List<Integer> listahab = new ArrayList<>();
        listahab.add(habitacion.getNumero());
        reserva = new Reserva(2, LocalDate.of(2010, 12, 31), LocalDate.of(2011, 12, 31), "06204591a", 20, 10, listahab);
        // when
        when(daoHotel.addReserva(reserva, "06204591a")).thenReturn(true);
        boolean respuesta = serviciosHotel.addReserva(reserva, "06204591a");
        //then
        assertThat(respuesta).isTrue();
    }

    @Test
    void addReservaErronea() {
        // given
        Hotel hotel = new Hotel();
        Reserva reserva = null;
        Habitacion habitacion = null;
        try {
            habitacion = new Habitacion(2, 3, "King");
        } catch (TipoException e) {
            throw new RuntimeException(e);
        }
        List<Integer> listahab = new ArrayList<>();
        listahab.add(habitacion.getNumero());
        reserva = new Reserva(2, LocalDate.of(2010, 12, 31), LocalDate.of(2011, 12, 31), "06204591a", 20, 10, listahab);
        // when
        when(daoHotel.addReserva(reserva, "06204591b")).thenReturn(false);
        boolean respuesta = serviciosHotel.addReserva(reserva, "06204591b");
        //then
        assertThat(respuesta).isFalse();
    }

    @Test
    void verClientes() {
        //given
        Hotel hotel = new Hotel();
        try {
            hotel.getClientes().add(new Cliente("92893780J", "Julio", LocalDate.of(2010, 12, 31), "967728900", "España", "1234"));
            hotel.getClientes().add(new Cliente("92897680J", "Jose", LocalDate.of(2000, 2, 16), "960289300", "España", "1924"));
        } catch (AlFrancesException e) {
            System.out.println(e.getMessage());
        }
        List<Cliente> clientes = hotel.getClientes();
        Collections.sort(clientes);
        hotel.setClientes(clientes);

        // when
        when(daoHotel.verClientes(true)).thenReturn(hotel.getClientes());
        List<Cliente> respuesta = serviciosHotel.verClientes(true);

        //then
        assertThat(respuesta).isEqualTo(hotel.getClientes());

    }

    @Test
    void borrarCliente() {
        //given
        Hotel hotel = new Hotel();
        try {
            hotel.getClientes().add(new Cliente("92893780J", "Julio", LocalDate.of(2010, 12, 31), "967728900", "España", "1234"));
            hotel.getClientes().add(new Cliente("92897680J", "Jose", LocalDate.of(2000, 2, 16), "960289300", "España", "1924"));
        } catch (AlFrancesException e) {
            System.out.println(e.getMessage());
        }
        //when
        when(daoHotel.borrarCliente("92893780J")).thenReturn(true);
        boolean respuesta = serviciosHotel.borrarCliente("92893780J");

        //then
        assertThat(respuesta).isEqualTo(true);
    }

    @Test
    void anyadirCliente() {
        //given
        Cliente cliente;
        try {
            cliente = new Cliente("92893780J", "Julio", LocalDate.of(2010, 12, 31), "967728900", "España", "1234");
        } catch (AlFrancesException e) {
            throw new RuntimeException(e);
        }
        //when
        when(daoHotel.anyadirCliente(cliente)).thenReturn(true);
        boolean respuesta = serviciosHotel.anyadirCliente(cliente);

        //then
        assertThat(respuesta).isEqualTo(true);
    }

    @Test
    void modificarNombreCliente() {
        //given
        Cliente cliente = null;
        try {
            cliente = new Cliente("08993452A", "Juan", LocalDate.of(2001, 12, 31), "91874838", "Italia", "219");
        } catch (AlFrancesException e) {
            throw new RuntimeException(e);
        }
        //when
        when(daoHotel.modificarNombreCliente("08993452A", "Antonio")).thenReturn(true);
        boolean respuesta = serviciosHotel.modificarNombreCliente("08993452A", "Antonio");
        //then
        assertThat(respuesta).isTrue();
    }

    @Test
    void borrarClienteDniErroneo() {
        //given
        Hotel hotel = new Hotel();
        try {
            hotel.getClientes().add(new Cliente("92893780J", "Julio", LocalDate.of(2010, 12, 31), "967728900", "España", "1234"));
            hotel.getClientes().add(new Cliente("92897680J", "Jose", LocalDate.of(2000, 2, 16), "960289300", "España", "1924"));
        } catch (AlFrancesException e) {
            System.out.println(e.getMessage());
        }

        //when
        when(daoHotel.borrarCliente("92893789J")).thenReturn(false);
        boolean respuesta = serviciosHotel.borrarCliente("92893789J");

        //then
        assertFalse(respuesta);
    }

    @Test
    void modificarNombreClienteErroneo() {
        //given
        Cliente cliente = null;
        try {
            cliente = new Cliente("08993452A", "Juan", LocalDate.of(2001, 12, 31), "91874838", "Italia", "219");
        } catch (AlFrancesException e) {
            throw new RuntimeException(e);
        }
        //when
        when(daoHotel.modificarNombreCliente("08993459A", "Antonio")).thenReturn(false);
        boolean respuesta = serviciosHotel.modificarNombreCliente("08993459A", "Antonio");
        //then
        assertThat(respuesta).isFalse();
    }

    @Test
    void listarReservasFecha() {//Victor
        //given
        Hotel hotel = new Hotel();
        try {
            hotel.getClientes().add(new Cliente("92893780J", "Julio", LocalDate.of(2010, 12, 31), "967728900", "España", "1234"));
        } catch (AlFrancesException e) {
            System.out.println(e.getMessage());
        }
        List<Reserva> reservas = new ArrayList<>();
        List<Integer> habitaciones = new ArrayList<>();
        habitaciones.add(9);
        // reservas.add(new Reserva(LocalDate.of(2022,12,30),LocalDate.of(2023,1,7),"92893780J",6,habitaciones));
       /* Reserva reserva = new Reserva(LocalDate.of(2022,12,30),LocalDate.of(2023,1,7),"92893780J",6,habitaciones);
        Reserva reserva1 = new Reserva(LocalDate.of(2021,2,3),LocalDate.of(2022,1,9),"92893780J",6,habitaciones);
        hotel.getClientes().get(0).setReservas();
       // hotel.getClientes().get(0).setReservas();
        Collections.sort(clientes);
        hotel.setClientes(clientes);*/

        // when
        when(daoHotel.verClientes(true)).thenReturn(hotel.getClientes());
        List<Cliente> respuesta = serviciosHotel.verClientes(true);

        //then
        assertThat(respuesta).isEqualTo(hotel.getClientes());
    }

    @Test
    void anyadirActividad() {

        //given
        Actividad actividad;

        try {
            actividad = new Actividad(1, "escalada", "piscina", 15);
        } catch (LugarException e) {
            throw new RuntimeException(e);
        }

        //when
        when(daoHotel.anyadirActividad(actividad)).thenReturn(true);
        boolean respuesta = serviciosHotel.anyadirActividad(actividad);

        //then
        assertThat(respuesta).isEqualTo(true);
    }


    @Test
    void borrarActividad() {
        //given
        Actividad actividad;
        Hotel hotel = new Hotel();

        try {
            actividad = new Actividad(1, "escalada", "piscina", 15);
        } catch (LugarException e) {
            throw new RuntimeException(e);
        }
        hotel.getActividades().add(actividad);
        //when
        when(daoHotel.borrarActividad(1)).thenReturn(true);
        boolean respuesta = serviciosHotel.borrarActividad(1);

        //then
        assertThat(respuesta).isEqualTo(true);
    }


    @DisplayName("Probando excepciones")
    @Nested
    public class Excepciones {
        @Test
        void anyadirActividadLugarErroneo() {
            //given
            Hotel hotel = new Hotel();
            Actividad actividad = null;

            //when
            boolean respuesta = false;
            try {
                actividad = new Actividad(1, "escalada", "lugarfalso", 15);
                respuesta = serviciosHotel.anyadirActividad(actividad);
            } catch (LugarException e) {
                assertThat(e.getMessage()).isEqualTo("El lugar lugarfalso no está permitido. Sólo son válidos:[gimnasio, piscina, rocodromo, playa]");
                assertThat(respuesta).isFalse();
            }

            //then
            verify(daoHotel, times(0)).anyadirActividad(actividad);
        }

        @Test
        void anyadirHabitacionTipoErroneo() {
            //given
            Hotel hotel = new Hotel();
            Habitacion habitacion = null;

            //when
            boolean respuesta = false;
            try {
                habitacion = new Habitacion(2, 3, "erroneo");
                respuesta = serviciosHotel.anyadirHabitacion(habitacion);
            } catch (TipoException e) {
                assertThat(e.getMessage()).isEqualToIgnoringCase("El tipo erroneo no está permitido. Sólo son válidos:[quad, doble, king]");
                assertThat(respuesta).isFalse();
            }

            //then
            verify(daoHotel, times(0)).anyadirHabitacion(habitacion);
        }

        @Test
        void anyadirActividadValido() {
            //given
            Hotel hotel = new Hotel();
            Actividad actividad = null;

            //when
            boolean respuesta = false;
            try {
                actividad = new Actividad(2, "natación", "piscina", 10);
                respuesta = true;
                serviciosHotel.anyadirActividad(actividad);
            } catch (LugarException e) {
                assertThat(respuesta).isFalse();
            }

            //then
            assertTrue(respuesta);
            verify(daoHotel, times(1)).anyadirActividad(actividad);
        }
    }
}