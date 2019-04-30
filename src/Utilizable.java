import java.io.File;
import java.io.IOException;

public interface Utilizable {
    public String muestraTodos();

    public void leeDeFichero(File fichero) throws ClassNotFoundException, IOException;
    public void guardaEnFichero(File fichero);
    public void pideYAnyade();
}
