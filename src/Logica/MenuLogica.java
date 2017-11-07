package Logica;

import Archivos.LoginArchivo;
import Archivos.MusicaArchivo;
import Archivos.PeliculaArchivo;
import Archivos.MenuArchivo;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MenuLogica {

    public static void compras(String tipo, String nombre, int precio, int cantidad, ArrayList musica, ArrayList pelicula, ArrayList user) {
        if (tipo.equals("Musica")) {
            int cont = JOptionPane.showConfirmDialog(null, "Costo total: " + precio * cantidad, "Desea continuar", JOptionPane.YES_NO_OPTION);
            if (cont == 0) {
                for (int i = 0; i < musica.size(); i += 6) {
                    if ((cantidad < Integer.parseInt(musica.get(i + 5).toString())) && (nombre.equals(musica.get(i).toString()))) {
                        musica.set(i + 5, Integer.parseInt(musica.get(i + 5).toString()) - cantidad);
                        MusicaArchivo.regmod(musica);
                        MenuArchivo.compras(user.get(0).toString(), user.get(2).toString(), user.get(3).toString(), nombre, cantidad, tipo);
                        correo(user.get(0).toString(), nombre, user.get(3).toString());
                        break;
                    } else if (((cantidad < Integer.parseInt(musica.get(i + 5).toString())) == false) && (nombre.equals(musica.get(i).toString()))) {
                        int precom = JOptionPane.showConfirmDialog(null, "Desea pre-ordenar", "Pre Orden", JOptionPane.YES_NO_OPTION);
                        if (precom == 0) {
                            MusicaArchivo.regmod(musica);
                            MenuArchivo.preorden(user.get(0).toString(), user.get(3).toString(), nombre, tipo, cantidad, precio * cantidad);
                            JOptionPane.showMessageDialog(null, "Pre orden completada", "Completado", JOptionPane.INFORMATION_MESSAGE);
                            break;
                            //funcion de precomprar(falta los correos)
                        }
                    }
                }
            }
        } else if (tipo.equals("Pelicula")) {
            int cont = JOptionPane.showConfirmDialog(null, "Costo total: " + precio * cantidad, "Desea continuar", JOptionPane.YES_NO_OPTION);
            if (cont == 0) {
                for (int i = 0; i < pelicula.size(); i += 5) {
                    if ((cantidad < Integer.parseInt(pelicula.get(i + 4).toString())) && (nombre.equals(pelicula.get(i).toString()))) {
                        pelicula.set(i + 4, Integer.parseInt(pelicula.get(i + 4).toString()) - cantidad);
                        PeliculaArchivo.regmod(pelicula);
                        MenuArchivo.compras(user.get(0).toString(), user.get(2).toString(), user.get(3).toString(), nombre, cantidad, tipo);
                        correo(user.get(0).toString(), nombre, user.get(3).toString());
                        break;
                    } else if (((cantidad < Integer.parseInt(pelicula.get(i + 4).toString())) == false) && (nombre.equals(pelicula.get(i).toString()))) {
                        int precom = JOptionPane.showConfirmDialog(null, "Desea pre-ordenar", "Pre Orden", JOptionPane.YES_NO_OPTION);
                        if (precom == 0) {
                            PeliculaArchivo.regmod(pelicula);
                            MenuArchivo.preorden(user.get(0).toString(), user.get(3).toString(), nombre, tipo, cantidad, precio * cantidad);
                            JOptionPane.showMessageDialog(null, "Pre orden completada", "Completado", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
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
        } else if (tipo.equals("Pelicula")) {
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

    public static ArrayList Infouser(String Username) {
        ArrayList user = new ArrayList();
        LoginArchivo archivo = new LoginArchivo();
        String arch = archivo.readarchivo();
        String[] info = arch.split(",");
        for (int i = 0; i < info.length; i += 4) {
            if (Username.equals(info[i])) {
                user.add(info[i]);
                user.add(info[i + 1]);
                user.add(info[i + 2]);
                user.add(info[i + 3]);
                return user;
            } else if (info.length == i + 4) {
                System.out.println("Datos ingresados erroneos");
                return null;
            }
        }
        return null;
    }

    public static void correo(String username, String namedisc, String correo) {
        Email send = new Email();
        send.username = username;
        send.namedisc = namedisc;
        send.correo = correo;
        send.msj  = "Estimado Usuario "+username+":\nLa comprar del disco " + namedisc +" fue realizada correctamente";
        boolean validar = send.sendMail();
        if(validar==true){
            JOptionPane.showMessageDialog(null, "Compra completada, verificar su correo", "Completado", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "No se puedo enviar el correo", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
    }
}
