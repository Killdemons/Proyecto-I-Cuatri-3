package Logica;

import Interfaz.MenuAdmin;
import Archivos.LoginArchivo;
import javax.swing.JOptionPane;

public class LoginLogica {

    public static boolean verification(String username, String password) {
        LoginArchivo archivo = new LoginArchivo();
        String arch = archivo.readarchivo();
        String[] info = arch.split(",");
        for (int i = 0; i < info.length; i += 4) {
            if (username.equals(info[i]) && password.equals(info[i + 1])) {
                return true;
            }
            else if(info.length==i+4){
                JOptionPane.showMessageDialog(null, "Datos ingresados erroneos");
                return false;
            }
        }
        return false;
    }

    public static void registro(String username, String password, String cedula, String correo) {
        LoginArchivo archivo = new LoginArchivo();
        String arch = archivo.readarchivo();
        String[] info = arch.split(",");
        for (int i = 0; i < info.length; i += 4) {
            if (username.equals(info[i]) && cedula.equals(info[i + 2]) && correo.equals(info[i + 3])) {
                JOptionPane.showMessageDialog(null, "Cuenta existente, verifique la informacion o inicie sesion");
                break;
            }
            else if (correo.equals(info[i + 3])) {
                JOptionPane.showMessageDialog(null, "Correo existente");
                break;
            }
            else if (cedula.equals(info[i + 2])) {
                JOptionPane.showMessageDialog(null, "Cedula existente");
                break;
            }
            else if (username.equals(info[i])) {
                JOptionPane.showMessageDialog(null, "Username existente");
                break;
            }
            else if(info.length==i+4){
                LoginArchivo.registro(username, password, cedula, correo);
                JOptionPane.showMessageDialog(null, "Cuenta creada");
                
            }
        }
    }
}
