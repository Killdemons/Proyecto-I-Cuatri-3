package Logica;

import Archivos.MusicaArchivo;
import java.util.ArrayList;

public class MusicaLogica {
    public static void registro (String nombredisco, String autor, String categoria, String precio, ArrayList canciones, int cantidad) {
        MusicaArchivo.registro(nombredisco, autor, categoria, precio, canciones, cantidad);
    }
}
