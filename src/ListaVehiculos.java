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
    public void leeDeFichero(File fichero) throws ClassNotFoundException, IOException {
        try {
            List<String> listaLeida = Files.readAllLines(fichero.toPath());
            lista = (List<Vehiculo>) listaLeida.stream().map(Objects::toString);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void guardaEnFichero(File fichero) {
        try (PrintWriter out = new PrintWriter(fichero)) {
            out.print(lista.stream().map(Objects::toString).collect(Collectors.joining("\n")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void pideYAnyade() {
        /*lista.add(JOptionPane.showInputDialog(null,"Añada vehiculo nuevo: ",));*/

    }
}
