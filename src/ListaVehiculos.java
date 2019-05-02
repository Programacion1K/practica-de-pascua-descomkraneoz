import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class ListaVehiculos implements Utilizable {
    List<Vehiculo> lista = new ArrayList<>();


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

        try {

            ObjectInputStream recuperandoFichero = new ObjectInputStream(new FileInputStream(fichero.getPath()));
            Vehiculo[] vehiculoRecuperado = (Vehiculo[]) recuperandoFichero.readObject();

            for (Vehiculo v : vehiculoRecuperado
            ) {
                System.out.println(v.toString());
            }

            recuperandoFichero.close();


        } catch (IOException ioe) {

            JOptionPane.showMessageDialog(null, "No se ha podido leer el fichero correctamente", "Error", JOptionPane.ERROR_MESSAGE);


        } catch (ClassNotFoundException cnfe) {

            JOptionPane.showMessageDialog(null, "Error en la clase", "Error", JOptionPane.ERROR_MESSAGE);


        }


    }

    @Override
    public void guardaEnFichero(File fichero) {
        try (PrintWriter salida = new PrintWriter(fichero)) {
            for (Vehiculo v : lista
            ) {
                salida.print(v.getNombre() + "," + v.getContaminacion() + "\n");
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
