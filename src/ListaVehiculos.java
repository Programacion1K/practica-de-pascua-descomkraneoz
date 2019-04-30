import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class ListaVehiculos implements Utilizable {
    List<Vehiculo> lista = new ArrayList<>();

    @Override
    public String muestraTodos() {
        return lista.stream().map(Objects::toString).collect(Collectors.joining("\n"));
    }

    @Override
    public void leeDeFichero(File nombreFichero) throws ClassNotFoundException, IOException {
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(nombreFichero);
            ois = new ObjectInputStream(fis);
            while (true) {
                Vehiculo v = (Vehiculo) ois.readObject();
                System.out.println("Nombre del vehiculo: " + v.getNombre());
                System.out.println("Contaminación emitida: " + v.getContaminacion() + " g/km");
                System.out.println("********************************");
            }
        } catch (IOException io) {

        } finally {
            ois.close();
        }

    }

    @Override
    public void guardaEnFichero(File nombreFichero) {
        try (PrintWriter out = new PrintWriter(nombreFichero)) {
            out.print(lista.stream().map(Objects::toString).collect(Collectors.joining("\n")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void pideYAnyade() {
        /* lista.add(JOptionPane.showInputDialog(null,"¿Vehiculo a añadir?")))*/


    }

}
