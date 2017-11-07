package Archivos;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LoginArchivo {
    
    public String readarchivo(){
        String inString = "";
        try {
            File archivo = new File("Login.txt");
            FileReader leer = new FileReader(archivo);
            BufferedReader inStream = new BufferedReader(leer);
            inString = inStream.readLine();
            inStream.close();
        } catch (IOException e) {
            System.out.println("no se ha podido leer el archivo" + e);
        }
        return inString;
    }
    public static void registro(String username, String password, String cedula, String correo) {
        try {
            ArrayList signup = new ArrayList();
            signup.add(username);
            signup.add(password);
            signup.add(cedula);
            signup.add(correo);
            File archivo = new File("Login.txt");
            FileWriter escribir = new FileWriter(archivo, true);
            BufferedWriter outStream = new BufferedWriter(escribir);
            for (int k = 0; k < signup.size(); k++) {
                outStream.write(signup.get(k).toString() + ",");
            }
            outStream.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se ha podido registrar el archivo" + e);
        }
    }
}
