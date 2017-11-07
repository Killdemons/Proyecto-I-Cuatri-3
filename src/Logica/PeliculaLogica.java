package Logica;
import Archivos.PeliculaArchivo;
import java.util.ArrayList;

public class PeliculaLogica {
    public static void registro (String nombredisco, String autor, String categoria, String precio, int cantidad) {
        PeliculaArchivo.registro(nombredisco, autor, categoria, precio, cantidad);
    }
    public static ArrayList search(String nombre){
        ArrayList busqueda = new ArrayList();
        ArrayList pelis = new ArrayList();
        PeliculaArchivo archivo = new PeliculaArchivo();
        String peli = archivo.search();
        String[] pelislist = peli.split("-");
        for(int i=0;i<pelislist.length;i+=5){
            if (nombre.equals(pelislist[i])){
                busqueda.add(pelislist[i]);
                busqueda.add(pelislist[i+1]);
                busqueda.add(pelislist[i+2]);
                busqueda.add(pelislist[i+3]);
                busqueda.add(pelislist[i+4]);
            }
            else if((nombre.equals(pelislist[i]))==false){
                pelis.add(pelislist[i]);
                pelis.add(pelislist[i+1]);
                pelis.add(pelislist[i+2]);
                pelis.add(pelislist[i+3]);
                pelis.add(pelislist[i+4]);
            }
        }
        PeliculaArchivo.regmod(pelis);
        return busqueda;
    }
}