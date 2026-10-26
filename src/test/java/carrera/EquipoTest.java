package carrera;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class EquipoTest {

    private Equipo equipo;
    private Velocista velocista;
    private Escalador escalador;

    @BeforeEach
    void preparar() {
        equipo = new Equipo("Team Colombia", "Colombia");
        velocista = new Velocista(1, "Fernando", 1100, 68.5);
        escalador = new Escalador(2, "Nairo", 1.8f, 12.5f);
        velocista.setTiempoAcumulado(100);
        escalador.setTiempoAcumulado(150);
        equipo.anadirCiclista(velocista);
        equipo.anadirCiclista(escalador);
    }

    @Test
    void calcularTiempoTotalSumaLosTiemposDeLosCiclistas() {
        assertEquals(250, equipo.calcularTiempoTotal());
        assertEquals(250, equipo.getTiempoTotalEquipo());
    }

    @Test
    void tiempoAcumuladoInicialEsCero() {
        Contrarrelojista c = new Contrarrelojista(3, "Egan", 55);
        assertEquals(0, c.getTiempoAcumulado());
    }

    @Test
    void imprimirTipoDevuelveLaClaseCorrecta() {
        assertEquals("Es un Velocista", velocista.imprimirTipo());
        assertEquals("Es un Escalador", escalador.imprimirTipo());
        assertEquals("Es un Contrarrelojista", new Contrarrelojista(3, "Egan", 55).imprimirTipo());
    }

    @Test
    void buscarIdInexistenteMuestraMensaje() {
        PrintStream original = System.out;
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        System.setOut(new PrintStream(salida));
        try {
            equipo.imprimirDatosCiclistaPorId(99);
        } finally {
            System.setOut(original);
        }
        assertTrue(salida.toString().contains("No existe"));
    }
}
