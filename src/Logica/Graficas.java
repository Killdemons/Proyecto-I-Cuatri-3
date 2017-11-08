package Logica;

import Archivos.MenuArchivo;
import java.util.ArrayList;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.data.category.*;
import org.jfree.chart.plot.*;

public class Graficas {
    
    public static String name1, name2, comp1, comp2, title;
    public static int valor1, valor2;
    
    public Graficas(){
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        data.addValue(valor1, name1, comp1);
        data.addValue(valor2, name2, comp1);
        JFreeChart grafica = ChartFactory.createBarChart3D(title, comp1, comp2, data, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel contenedor = new ChartPanel(grafica);
        JFrame ventana = new JFrame("Reportes");
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventana.add(contenedor);
        ventana.setSize(400, 200);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana.setVisible(true);
    }
    
    public static ArrayList Compras() {
        ArrayList compras = new ArrayList();
        String buys = MenuArchivo.Compras();
        String[] compra = buys.split("-");
        for (int i = 0; i < compra.length; i += 7) {
            compras.add(compra[i]);
            compras.add(compra[i + 1]);
            compras.add(compra[i + 2]);
            compras.add(compra[i + 3]);
            compras.add(compra[i + 4]);
            compras.add(compra[i + 5]);
            compras.add(compra[i + 6]);
        }
        return compras;
    }
    
    public static ArrayList ventacategoria(String boxTipo, String boxReport){
        ArrayList compras = Compras();
        ArrayList musica = MenuLogica.buscar("Musica");
        ArrayList pelicula = MenuLogica.buscar("Pelicula");
        ArrayList ventas = new ArrayList();
        if((boxTipo.equals("Musica")) && boxReport.equals("Venta por categoria")){
            for (int i = 0; i < compras.size(); i+=7) {
                for (int j = 0; j < musica.size(); j+=6) {
                    if(compras.get(i+4).toString().equals(musica.get(i).toString())){
                        String categoria = musica.get(i+3).toString();
                        for (int k = 0; k < ventas.size(); k+=3) {
                            if(ventas.get(i).toString().equals(compras.get(i+4).toString())){
                                int cantidad = Integer.parseInt(compras.get(i+5).toString())+Integer.parseInt(ventas.get(i+2).toString());
                                ventas.set(i+2, cantidad);
                            }
                            else{
                                ventas.add(compras.get(i+4).toString());
                                ventas.add(compras.get(i+5).toString());
                                ventas.add(categoria);
                            }
                        }
                    }
                }
            }
        }
        else if((boxTipo.equals("Pelicula")) && boxReport.equals("Venta por categoria")){
            for (int i = 0; i < compras.size(); i+=7) {
                for (int j = 0; j < pelicula.size(); j+=6) {
                    if(compras.get(i+4).toString().equals(pelicula.get(i).toString())){
                        String categoria = pelicula.get(i+3).toString();
                        for (int k = 0; k < ventas.size(); k+=3) {
                            if(ventas.get(i).toString().equals(compras.get(i+4).toString())){
                                int cantidad = Integer.parseInt(compras.get(i+5).toString())+Integer.parseInt(ventas.get(i+2).toString());
                                ventas.set(i+2, cantidad);
                            }
                            else{
                                ventas.add(compras.get(i+4).toString());
                                ventas.add(compras.get(i+5).toString());
                                ventas.add(categoria);
                            }
                        }
                    }
                }
            }
        }
        return ventas;
    }
    
    public static void main() {
        new Graficas();
    }
}
