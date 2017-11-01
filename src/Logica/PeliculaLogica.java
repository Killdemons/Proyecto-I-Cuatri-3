package Logica;
import Archivos.PeliculaArchivo;

public class PeliculaLogica {
    public static void registro (String nombredisco, String autor, String categoria, String precio, int cantidad) {
        PeliculaArchivo.registro(nombredisco, autor, categoria, precio, cantidad);
    }
}