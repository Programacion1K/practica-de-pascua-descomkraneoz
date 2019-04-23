import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class ListaVehiculos implements Utilizable {
    Set<Vehiculo> lista = new HashSet<>();

    @Override
    public String muestraTodos() {
        return lista.stream().map(Objects::toString).collect(Collectors.joining("\n"));
    }

    @Override
    public void leeDeFichero(File nombreFichero) {
        /*try {
            lista= Files.readAllLines(nombreFichero.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }*/


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
        //lista.add(JOptionPane.showInputDialog(null,"¿Vehículo a añadir?"));


    }

}
