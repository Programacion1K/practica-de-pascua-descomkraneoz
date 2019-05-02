import java.io.Serializable;
import java.util.Objects;

public class Vehiculo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private double contaminacion; // en g/km unidades del S.I.

    public Vehiculo(String nombre, double contaminacion) {
        this.nombre = nombre;
        this.contaminacion = contaminacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContaminacion(double contaminacion) {
        this.contaminacion = contaminacion;
    }

    public double getContaminacion() {
        return contaminacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return nombre.equals(vehiculo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Vehículo: " + nombre.toUpperCase() + " contaminación emitida = " + contaminacion + " g/km.";
    }
}
