package Logica;

import Archivos.MusicaArchivo;
import java.util.ArrayList;

public class MusicaLogica {
    public static void registro (String nombredisco, String autor, String categoria, String precio, ArrayList canciones, int cantidad) {
        MusicaArchivo.registro(nombredisco, autor, categoria, precio, canciones, cantidad);
    }
    public static ArrayList search(String namedisc){
        ArrayList busqueda = new ArrayList();
        ArrayList music = new ArrayList();
        MusicaArchivo archivo = new MusicaArchivo();
        String musica = archivo.search();
        String[] musicalist = musica.split("-");
        for(int i=0;i<musicalist.length;i+=6){
            if (namedisc.equals(musicalist[i])){
                busqueda.add(musicalist[i]);
                busqueda.add(musicalist[i+1]);
                busqueda.add(musicalist[i+2]);
                busqueda.add(musicalist[i+3]);
                busqueda.add(musicalist[i+4]);
                busqueda.add(musicalist[i+5]);
            }
            else if((namedisc.equals(musicalist[i]))==false){
                music.add(musicalist[i]);
                music.add(musicalist[i+1]);
                music.add(musicalist[i+2]);
                music.add(musicalist[i+3]);
                music.add(musicalist[i+4]);
                music.add(musicalist[i+5]);
            }
        }
        MusicaArchivo.regmod(music);
        return busqueda;
    }
    public static ArrayList canciones(String namedisc){
        ArrayList busqueda = new ArrayList();
        ArrayList music = new ArrayList();
        MusicaArchivo archivo = new MusicaArchivo();
        String musica = archivo.search();
        String[] musicalist = musica.split("-");
        for(int i=0;i<musicalist.length;i+=6){
            if (namedisc.equals(musicalist[i])){
                busqueda.add(musicalist[i]);
                busqueda.add(musicalist[i+1]);
                busqueda.add(musicalist[i+2]);
                busqueda.add(musicalist[i+3]);
                busqueda.add(musicalist[i+4]);
                busqueda.add(musicalist[i+5]);
                music.add(musicalist[i]);
                music.add(musicalist[i+1]);
                music.add(musicalist[i+2]);
                music.add(musicalist[i+3]);
                music.add(musicalist[i+4]);
                music.add(musicalist[i+5]);
            }
            else if((namedisc.equals(musicalist[i]))==false){
                music.add(musicalist[i]);
                music.add(musicalist[i+1]);
                music.add(musicalist[i+2]);
                music.add(musicalist[i+3]);
                music.add(musicalist[i+4]);
                music.add(musicalist[i+5]);
            }
        }
        MusicaArchivo.regmod(music);
        return busqueda;
    }
}
