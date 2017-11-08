package Logica;

import Archivos.MenuArchivo;
import java.util.ArrayList;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.data.category.*;
import org.jfree.chart.plot.*;

public class Graficas {
    
    // Videoguia para grafico: https://www.youtube.com/watch?v=Veto2BUKZ3I
    
    public static String name1, name2, comp1, comp2, title;
    public static int valor1, valor2;
    
    public Graficas(){
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        data.addValue(valor1, name1, comp1);
        data.addValue(valor2, name2, comp1);
        JFreeChart grafica = ChartFactory.createBarChart3D(title, comp1, comp2, data, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel contenedor = new ChartPanel(grafica);
        JFrame ventana = new JFrame("Reportes");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    
    public static void main() {
        new Graficas();
    }
}
