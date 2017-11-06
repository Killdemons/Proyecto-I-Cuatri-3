package Logica;

import Archivos.MusicaArchivo;
import Archivos.PeliculaArchivo;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MenuLogica {

    public static void compras(String tipo, String nombre, int precio, int cantidad, ArrayList musica, ArrayList pelicula) {
        if(tipo.equals("Musica")){
            int cont = JOptionPane.showConfirmDialog(null, "Costo total: "+precio*cantidad,"Desea continuar",JOptionPane.YES_NO_OPTION);
            if(cont==0){
                for (int i = 0; i < musica.size(); i+=6) {
                    if((cantidad<Integer.parseInt(musica.get(i+5).toString())) && (nombre.equals(musica.get(i).toString()))){
                        musica.set(i+5, Integer.parseInt(musica.get(i+5).toString())-cantidad);
                        JOptionPane.showMessageDialog(null, "Compra completada, verificar su correo", "Completado",JOptionPane.INFORMATION_MESSAGE);
                        MusicaArchivo.regmod(musica);
                        break;
                    }
                    else if(((cantidad<Integer.parseInt(musica.get(i+5).toString()))==false) && (nombre.equals(musica.get(i).toString()))){
                        int precom = JOptionPane.showConfirmDialog(null, "Desea precomprar","Precompra",JOptionPane.YES_NO_OPTION);
                        if(precom==0){
                            //funcion de precomprar(falta de crear)
                        }
                    }
                }
            }
        }
        else if(tipo.equals("Pelicula")){
            int cont = JOptionPane.showConfirmDialog(null, "Costo total: "+precio*cantidad,"Desea continuar",JOptionPane.YES_NO_OPTION);
            if(cont==0){
                for (int i = 0; i < pelicula.size(); i+=5) {
                    if((cantidad<Integer.parseInt(pelicula.get(i+4).toString())) && (nombre.equals(musica.get(i).toString()))){
                        pelicula.set(i+4, Integer.parseInt(pelicula.get(i+4).toString())-cantidad);
                        JOptionPane.showMessageDialog(null, "Compra completada, verificar su correo", "Completado",JOptionPane.INFORMATION_MESSAGE);
                        PeliculaArchivo.regmod(pelicula);
                        break;
                    }
                }
            }
        }
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
