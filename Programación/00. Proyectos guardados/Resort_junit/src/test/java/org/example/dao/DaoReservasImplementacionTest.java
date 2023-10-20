package org.example.dao;

import org.example.common.AlFrancesException;
import org.example.common.LugarException;
import org.example.common.TipoException;
import org.example.domain.*;
import org.example.service.GestionHotel;
import org.example.service.GestionReservas;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

@ExtendWith(MockitoExtension.class)
class DaoReservasImplementacionTest {
    @InjectMocks
    DaoReservasImplementacion daoReservas;

    @Mock
    Hotel hotel;


    @Nested
    class anyadirCliente {
        @Order (4)
        @Test
        void anyadirClienteVacio() {
            //given
            Cliente cliente = null;
            try {
                cliente = new Cliente("06008392A", "Juan", LocalDate.of(1984, 12, 25), "+34 695498108", "España", "1234");
            } catch (AlFrancesException e) {
                throw new RuntimeException(e);
            }
            //when
            when(hotel.getClientes()).thenReturn(new ArrayList<>());
            boolean respuesta = daoReservas.anyadirCliente(cliente);
            //then
            assertThat(respuesta).isTrue();
        }
        @Order (5)
        @Test
        void anyadirClienteNoVacio() {
            //given

            Cliente cliente = null;
            ArrayList<Cliente> clientes = new ArrayList<>();
            try {
                cliente = new Cliente("06008392A", "Juan", LocalDate.of(1984, 12, 25), "+34 695498108", "España", "1234");
                clientes.add(cliente);
            } catch (AlFrancesException e) {
                throw new RuntimeException(e);
            }
            //when
            when(hotel.getClientes()).thenReturn(clientes);
            boolean respuesta = daoReservas.anyadirCliente(cliente);
            //then
            assertThat(respuesta).isTrue();
        }

    }
    @Order (1)
    @Test
    void iniciarSesion() {
        //given
        List<Cliente> clientes = new ArrayList<>();
        try {
            clientes.add(new Cliente("06008392A", "Juan", LocalDate.of(1984, 12, 25), "+34 695498108", "España", "1234"));
            clientes.add(new Cliente("16008692B", "Ramiro", LocalDate.of(1973, 4, 1), "+52 695498108", "México", "1234"));
        } catch (AlFrancesException e) {
            throw new RuntimeException(e);
        }
        //when
        when(hotel.getClientes()).thenReturn(clientes);
        boolean respuesta = daoReservas.iniciarSesion("06008392A", "1234");

        //then
        assertThat(respuesta).isEqualTo(true);
    }
    @Order (2)
    @Test
    void iniciarSesionErronea() {
        //given
        List<Cliente> clientes = new ArrayList<>();
        try {
            clientes.add(new Cliente("06008392A", "Juan", LocalDate.of(1984, 12, 25), "+34 695498108", "España", "1234"));
            clientes.add(new Cliente("16008692B", "Ramiro", LocalDate.of(1973, 4, 1), "+52 695498108", "México", "1234"));
        } catch (AlFrancesException e) {
            throw new RuntimeException(e);
        }
        //when
        when(hotel.getClientes()).thenReturn(clientes);
        boolean respuesta = daoReservas.iniciarSesion("06008392A", "12345");

        //then
        assertThat(respuesta).isEqualTo(false);
    }
    @Order (3)
    @Test
    void addReserva() {
        //given
        Hotel hotel = new Hotel();
        Cliente cliente = null;
        Reserva reserva = new Reserva(2, LocalDate.of(2001, 12, 31), LocalDate.of(2002, 1, 7), "06008392A", 5000, 3, new ArrayList<>());
        try {
            cliente = new Cliente("06008392A", "Juan", LocalDate.of(1984, 12, 25), "+34 695498108", "España", "1234");
        } catch (AlFrancesException e) {
            throw new RuntimeException(e);
        }
        cliente.anyadirreserva(reserva);
        //when
        when(hotel.getClientes()).thenReturn(new ArrayList<>());
        hotel.getClientes().add(cliente);
        boolean respuesta = daoReservas.addReserva(cliente, reserva);
        //then
        assertThat(respuesta).isTrue();
    }

    @Test
    void modificarContrasenya() {
        //given
        Cliente cliente = null;
        try {
            cliente = new Cliente("06008392A", "Juan", LocalDate.of(1984, 12, 25), "+34 695498108", "España", "1234");
        } catch (AlFrancesException e) {
            throw new RuntimeException(e);
        }
        String contrasenya = "12345";

        //when
        when(hotel.getClientes()).thenReturn(new ArrayList<>());
        hotel.getClientes().add(cliente);
        boolean result = daoReservas.modificarContrasenya(cliente.getDni(), contrasenya);

        //then
        assertTrue(result);
    }

    @Test
    void modificarContrasenyaErronea() {
        //given
        Cliente cliente = null;
        try {
            cliente = new Cliente("06008392A", "Juan", LocalDate.of(1984, 12, 25), "+34 695498108", "España", "1234");
        } catch (AlFrancesException e) {
            throw new RuntimeException(e);
        }
        String contrasenya = "12345";

        //when
        when(hotel.getClientes()).thenReturn(new ArrayList<>());
        hotel.getClientes().add(cliente);
        boolean result = daoReservas.modificarContrasenya("06000732B", contrasenya);

        //then
        assertFalse(result);
    }


    @Test
    void verMisActividades() {
        //given
        Cliente cliente = null;
        Actividad actividad = null;
        List<Cliente> clientes = new ArrayList<>();
        List<Actividad> actividades = new ArrayList<>();
        try {
            actividad = new Actividad(2, "SnowWaffles", "piscina", 812.27);
        } catch (LugarException e) {
            throw new RuntimeException(e);
        }
        try {
            cliente = new Cliente("06008392A", "Juan", LocalDate.of(1984, 12, 25), "+34 695498108", "España", "1234");
            cliente.getActividades().add(actividad);
            clientes.add(cliente);
        } catch (AlFrancesException e) {
            throw new RuntimeException(e);

        }
        actividades.add(actividad);
        //when
        List<Actividad> respuesta = daoReservas.verMisActividades(cliente, true);

        //then
        assertThat(cliente.getActividades()).isEqualTo(respuesta);
    }

    @ParameterizedTest
    @CsvSource({"0, true", "1, false", "2, false"})
    void cancelarReserva(int reservaIndex, boolean expectedResult) {
        //given
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente = null;
        try {
            cliente = new Cliente("06008392A", "Juan", LocalDate.of(1984, 12, 25), "+34 695498108", "España", "1234");
            clientes.add(cliente);
        } catch (AlFrancesException e) {
            throw new RuntimeException(e);
        }
        Habitacion habitacion = null;
        try {
            habitacion = new Habitacion(2, 3, "King");
        } catch (TipoException e) {
            throw new RuntimeException(e);
        }
        List<Integer> listahab = new ArrayList<>();
        listahab.add(habitacion.getNumero());
        Reserva reserva = new Reserva(0, LocalDate.of(2010, 12, 31), LocalDate.of(2011, 12, 31), "06008392A", 20, 10, listahab);
        cliente.getReservas().add(reserva);

        //when
        when(hotel.getClientes()).thenReturn(clientes);
        boolean result = daoReservas.cancelarReserva(reservaIndex);

        //then
        assertEquals(expectedResult, result);
    }


    @Test
    void cancelarReservaErroneo() {
        //david
        //given
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente = null;
        try {
            cliente = new Cliente("06008392A", "Juan", LocalDate.of(1984, 12, 25), "+34 695498108", "España", "1234");
            clientes.add(cliente);
        } catch (AlFrancesException e) {
            throw new RuntimeException(e);
        }
        Habitacion habitacion = null;
        try {
            habitacion = new Habitacion(2, 3, "King");
        } catch (TipoException e) {
            throw new RuntimeException(e);
        }
        List<Integer> listahab = new ArrayList<>();
        listahab.add(habitacion.getNumero());
        Reserva reserva = new Reserva(10, LocalDate.of(2010, 12, 31), LocalDate.of(2011, 12, 31), "06008392A", 20, 10, listahab);
        cliente.getReservas().add(reserva);

        //when
        when(hotel.getClientes()).thenReturn(clientes);
        boolean result = daoReservas.cancelarReserva(27);

        //then
        assertFalse(result);

    }

    @Test
    void obtenerHabitacionesComprobacion() {
        //victor
        //given
        List<Habitacion> habitaciones = new ArrayList<>();
        Habitacion habitacion1 = null;
        Habitacion habitacion2 = null;
        try {
            habitacion1 = new Habitacion(2, 6, "king");
            habitacion2 = new Habitacion(4, 4, "quad");
        } catch (TipoException e) {
            System.out.println(e.getMessage());
        }
        List<LocalDate> fechasOcupadas = new ArrayList<>();
        fechasOcupadas.add(LocalDate.of(2022, 7, 6));
        habitacion1.setFechasocupadas(fechasOcupadas);
        habitaciones.add(habitacion1);

        //when
        when(hotel.getHabitaciones()).thenReturn(habitaciones);
        List<Habitacion> respuesta = daoReservas.obtenerHabitaciones(LocalDate.of(2022, 6, 1), LocalDate.of(2022, 6, 5));

        //then
        assertThat(respuesta).doesNotContain(habitacion2);
        assertThat(respuesta).contains(habitacion1);
    }

    @Test
    void reservarActividad() {
        //david
        //given
        List<Cliente> clientes = new ArrayList<>();
        List<Actividad> actividades = new ArrayList<>();
        Cliente cliente = null;
        try {
            cliente = new Cliente("06008392A", "Juan", LocalDate.of(1984, 12, 25), "+34 695498108", "España", "1234");
            clientes.add(cliente);
        } catch (AlFrancesException e) {
            throw new RuntimeException(e);
        }
        Actividad actividad = null;
        try {
            actividad = new Actividad(2, "Zumba", "piscina", 812.27);
            actividades.add(actividad);
        } catch (LugarException e) {
            throw new RuntimeException(e);
        }

        //when
        when(hotel.getActividades()).thenReturn(actividades);
        boolean result = daoReservas.reservarActividad(2, cliente);

        //then
        assertTrue(result);

    }

    @Test
    void reservarActividadErronea() {
        //david
        //given
        List<Cliente> clientes = new ArrayList<>();
        List<Actividad> actividades = new ArrayList<>();
        Cliente cliente = null;
        try {
            cliente = new Cliente("06008392A", "Juan", LocalDate.of(1984, 12, 25), "+34 695498108", "España", "1234");
            clientes.add(cliente);
        } catch (AlFrancesException e) {
            throw new RuntimeException(e);
        }
        Actividad actividad = null;
        try {
            actividad = new Actividad(2, "Zumba", "piscina", 812.27);
            actividades.add(actividad);
        } catch (LugarException e) {
            throw new RuntimeException(e);
        }

        //when
        when(hotel.getActividades()).thenReturn(actividades);
        boolean result = daoReservas.reservarActividad(23, cliente);

        //then
        assertFalse(result);
    }


    @Test
    void cancelarActividad() {
        //david
        //given
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente = null;
        try {
            cliente = new Cliente("06008392A", "Juan", LocalDate.of(1984, 12, 25), "+34 695498108", "España", "1234");
        } catch (AlFrancesException e) {
            throw new RuntimeException(e);
        }
        Actividad actividad = null;
        try {
            actividad = new Actividad(2, "Zumba", "piscina", 812.27);
        } catch (LugarException e) {
            throw new RuntimeException(e);
        }
        cliente.getActividades().add(actividad);
        clientes.add(cliente);

        //when
        boolean result = daoReservas.cancelarActividad(2, cliente);

        //then
        assertTrue(result);

    }

    @Test
    void cancelarActividadErronea() {
        //david
        //given
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente = null;
        try {
            cliente = new Cliente("06008392A", "Juan", LocalDate.of(1984, 12, 25), "+34 695498108", "España", "1234");
        } catch (AlFrancesException e) {
            throw new RuntimeException(e);
        }
        Actividad actividad = null;
        try {
            actividad = new Actividad(2, "Zumba", "piscina", 812.27);
        } catch (LugarException e) {
            throw new RuntimeException(e);
        }
        cliente.getActividades().add(actividad);
        clientes.add(cliente);

        //when
        boolean result = daoReservas.cancelarActividad(1, cliente);

        //then
        assertFalse(result);

    }

    @Test
    void verReservas() {
        //given
        Cliente cliente = null;
        Reserva reserva = null;
        List<Cliente> clientes = new ArrayList<>();
        List<Reserva> reservas = new ArrayList<>();

        reserva = new Reserva(2, LocalDate.of(2001, 12, 31), LocalDate.of(2002, 1, 7), "06008392A", 800, 4, new ArrayList<>());


        try {
            cliente = new Cliente("06008392A", "Juan", LocalDate.of(1984, 12, 25), "+34 695498108", "España", "1234");
            cliente.getReservas().add(reserva);
            clientes.add(cliente);
        } catch (AlFrancesException e) {
            throw new RuntimeException(e);
        }
        //when
        List<Reserva> respuesta = daoReservas.verReservas(true, cliente);

        //then
        assertThat(cliente.getReservas()).isEqualTo(respuesta);


    }

    @ParameterizedTest
    @CsvSource({"06008392A, true", "12345678B, false", "87654321C, false"})
    void clientePorDni(String dni, boolean expectedResult) {
        //given
        Cliente cliente = null;
        try {
            cliente = new Cliente("06008392A", "Juan", LocalDate.of(1984, 12, 25), "+34 695498108", "España", "1234");
        } catch (AlFrancesException e) {
            throw new RuntimeException(e);
        }
        String contrasenya = "12345";

        //when
        when(hotel.getClientes()).thenReturn(new ArrayList<>());
        hotel.getClientes().add(cliente);
        Cliente cliente1 = daoReservas.clientePorDni(dni);

        //then
        if(expectedResult){
            assertThat(cliente).isEqualTo(cliente1);
        } else{
            assertThat(cliente).isNotEqualTo(cliente1);
        }
    }


    @Test
    void modificarReservaFecha() {
        //victor
        //given
        List<Cliente> clientes = new ArrayList<>();
        try {
            clientes.add(new Cliente("92893780J", "Julio", LocalDate.of(2010, 12, 31), "967728900", "España", "1234"));
        } catch (AlFrancesException e) {
            System.out.println(e.getMessage());
        }
        List<Reserva> reservas = new ArrayList<>();
        List<Integer> habitaciones = new ArrayList<>();
        habitaciones.add(9);
        reservas.add(new Reserva(12, LocalDate.of(2022, 12, 30), LocalDate.of(2023, 1, 7), "92893780J", 6, habitaciones));
        clientes.get(0).setReservas(reservas);
        LocalDate entrada = LocalDate.of(2022, 12, 20);
        LocalDate salida = LocalDate.of(2022, 12, 30);

        //when
        when(hotel.getClientes()).thenReturn(clientes);
        boolean respuesta = daoReservas.modificarReservaFecha(12, entrada, salida);

        //then
        assertThat(respuesta).isEqualTo(true);
    }

    @Test
    void obtenerHabitaciones() {
        //victor
        //given
        List<Habitacion> habitaciones = new ArrayList<>();
        Habitacion habitacion = null;
        try {
            habitacion = new Habitacion(2, 6, "king");
        } catch (TipoException e) {
            System.out.println(e.getMessage());
        }
        List<LocalDate> fechasOcupadas = new ArrayList<>();
        fechasOcupadas.add(LocalDate.of(2022, 7, 6));
        habitacion.setFechasocupadas(fechasOcupadas);
        habitaciones.add(habitacion);

        //when
        when(hotel.getHabitaciones()).thenReturn(habitaciones);
        List<Habitacion> respuesta = daoReservas.obtenerHabitaciones(LocalDate.of(2022, 6, 1), LocalDate.of(2022, 6, 5));

        //then
        assertThat(respuesta).isEqualTo(habitaciones);
    }

    @Test
    void obtenerCosto() {
        //victor
        //given
        List<Habitacion> habitaciones = new ArrayList<>();
        Habitacion habitacion = null;
        Cliente cliente = null;
        Reserva reserva = null;
        List<Integer> numHabitaciones = new ArrayList<>();
        numHabitaciones.add(6);
        try {
            habitacion = new Habitacion(6, 4, "quad");
        } catch (TipoException e) {
            throw new RuntimeException(e);
        }
        reserva = new Reserva(4, LocalDate.of(2020, 7, 1), LocalDate.of(2020, 7, 15), "83746502L", 4, numHabitaciones);
        habitaciones.add(habitacion);

        //when
        when(hotel.getHabitaciones()).thenReturn(habitaciones);
        int respuesta = daoReservas.obtenerCosto(reserva);

        //then //modificar
        assertThat(respuesta).isEqualTo(1960);
    }
}