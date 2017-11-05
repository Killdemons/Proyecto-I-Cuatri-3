package Logica;

import Archivos.MusicaArchivo;
import Archivos.PeliculaArchivo;
import java.util.ArrayList;

public class MenuLogica {

    public static void main(String[] args) {

    }

    public static ArrayList buscar(String tipo) {
        ArrayList busqueda = new ArrayList();
        if (tipo.equals("Musica")) {
            MusicaArchivo archivo = new MusicaArchivo();
            String musica = archivo.search();
            String[] musicalist = musica.split("-");
            for (int i = 0; i < musicalist.length; i += 6) {
                busqueda.add(musicalist[i]);
                busqueda.add(musicalist[i + 1]);
                busqueda.add(musicalist[i + 2]);
                busqueda.add(musicalist[i + 3]);
                busqueda.add(musicalist[i + 4]);
                busqueda.add(musicalist[i + 5]);
            }
        }
        else if (tipo.equals("Pelicula")) {
            PeliculaArchivo archivo = new PeliculaArchivo();
            String pelis = archivo.search();
            String[] pelilist = pelis.split("-");
            for (int i = 0; i < pelilist.length; i += 6) {
                busqueda.add(pelilist[i]);
                busqueda.add(pelilist[i + 1]);
                busqueda.add(pelilist[i + 2]);
                busqueda.add(pelilist[i + 3]);
                busqueda.add(pelilist[i + 4]);
            }
        }
        return busqueda;
    }
}
