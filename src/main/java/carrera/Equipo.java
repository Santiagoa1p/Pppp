package carrera;

import java.util.ArrayList;
import java.util.List;

public class Equipo {

    private String nombreEquipo;
    private String pais;
    private static int tiempoTotalEquipo; // en minutos (atributo estático)
    private List<Ciclista> ciclistas;

    public Equipo(String nombreEquipo, String pais) {
        this.nombreEquipo = nombreEquipo;
        this.pais = pais;
        this.ciclistas = new ArrayList<>();
    }

    // Métodos get y set protegidos (según el enunciado)
    protected String getNombreEquipo() {
        return nombreEquipo;
    }

    protected void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    protected String getPais() {
        return pais;
    }

    protected void setPais(String pais) {
        this.pais = pais;
    }

    protected int getTiempoTotalEquipo() {
        return tiempoTotalEquipo;
    }

    protected void setTiempoTotalEquipo(int tiempoTotal) {
        tiempoTotalEquipo = tiempoTotal;
    }

    protected List<Ciclista> getCiclistas() {
        return ciclistas;
    }

    protected void setCiclistas(List<Ciclista> ciclistas) {
        this.ciclistas = ciclistas;
    }

    public void anadirCiclista(Ciclista ciclista) {
        ciclistas.add(ciclista);
    }

    /** Suma los tiempos de los ciclistas, lo guarda en el atributo estático y lo devuelve. */
    public int calcularTiempoTotal() {
        int total = 0;
        for (Ciclista c : ciclistas) {
            total += c.getTiempoAcumulado();
        }
        tiempoTotalEquipo = total;
        return total;
    }

    public void imprimirDatosEquipo() {
        System.out.println("Equipo: " + nombreEquipo);
        System.out.println("País: " + pais);
        System.out.println("Tiempo total del equipo: " + calcularTiempoTotal() + " min");
        System.out.println("Cantidad de ciclistas: " + ciclistas.size());
    }

    public void listarNombresCiclistas() {
        System.out.println("Ciclistas del equipo " + nombreEquipo + ":");
        for (Ciclista c : ciclistas) {
            System.out.println("- " + c.getNombre());
        }
    }

    public void imprimirDatosCiclistaPorId(int id) {
        for (Ciclista c : ciclistas) {
            if (c.getIdentificador() == id) {
                System.out.println(c.imprimirTipo());
                c.imprimirDatos();
                return;
            }
        }
        System.out.println("No existe un ciclista con el identificador " + id);
    }
}
