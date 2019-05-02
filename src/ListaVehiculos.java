import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class ListaVehiculos implements Utilizable {
    List<Vehiculo> lista = new ArrayList<>();
    public static final char DELIMITADOR = ';';


    @Override
    public String muestraTodos() {
        String salida = "";
        for (Vehiculo v : lista
        ) {
            salida += v.toString() + "\n";
        }
        return salida;
    }

    @Override
    public void leeDeFichero(File fichero) {

        String nombreVehiculo;
        double contaminacionVehiculo;
        int posicionDelimitador;
        try {
            List<String> lineasFichero = Files.readAllLines(fichero.toPath());
            for (int i = 0; i < lineasFichero.size(); i++) {
                posicionDelimitador = lineasFichero.get(i).indexOf(DELIMITADOR);
                nombreVehiculo = lineasFichero.get(i).substring(0, posicionDelimitador);
                contaminacionVehiculo = Double.parseDouble(lineasFichero.get(i).substring(posicionDelimitador + 1));
                lista.add(new Vehiculo(nombreVehiculo, contaminacionVehiculo));
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Introduzca un número correcto (0.0)");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (StringIndexOutOfBoundsException siobe) {
            JOptionPane.showMessageDialog(null, "Error en la lectura del fichero, puede que el delimitador no sea el correcto (;)");
        }
    }

    @Override
    public void guardaEnFichero(File fichero) {
        try (PrintWriter salida = new PrintWriter(fichero)) {
            for (Vehiculo v : lista
            ) {
                salida.print(v.getNombre() + DELIMITADOR + v.getContaminacion() + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void pideYAnyade() {
        Vehiculo vehiculo = new Vehiculo("prueba", 0.0);
        String nombre = "";
        double contaminacion = 0;
        vehiculo.setNombre(JOptionPane.showInputDialog("Introduce nombre del vehiculo: ", nombre.toUpperCase()));
        vehiculo.setContaminacion(Double.parseDouble(JOptionPane.showInputDialog("Nivel de contaminación del vehiculo en g/km: ", contaminacion)));
        lista.add(vehiculo);

    }
}
