/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Logica.MenuLogica;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Menu extends javax.swing.JFrame {

    ArrayList listamusica = MenuLogica.buscar("Musica");
    ArrayList listapelicula = MenuLogica.buscar("Pelicula");
    String Username;
    
    public Menu() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        spnMin.setVisible(false);
        spnMax.setVisible(false);
        lblA.setVisible(false);
    }

    public void busqueda() {
        if (boxBusqueda.getSelectedItem().equals("Nombre")) {
            txtBuscar.setVisible(true);
            txtBuscar.setText("Nombre del disco");
            spnMin.setVisible(false);
            spnMax.setVisible(false);
            lblA.setVisible(false);

        } else if (boxBusqueda.getSelectedItem().equals("Autor")) {
            txtBuscar.setVisible(true);
            txtBuscar.setText("Nombre del autor");
            spnMin.setVisible(false);
            spnMax.setVisible(false);
            lblA.setVisible(false);
        } else if (boxBusqueda.getSelectedItem().equals("Precio")) {
            txtBuscar.setVisible(false);
            spnMin.setVisible(true);
            spnMax.setVisible(true);
            lblA.setVisible(true);

        }
    }

    public void buscarnombre(String texto, String tipo) {
        ArrayList buscar = MenuLogica.buscar(tipo);
        String[][] matriz = null;
        int k = 0;
        for (int x = 0; x < buscar.size(); x += 6) {
            if (texto.equals((String) buscar.get(x))) {
                matriz = new String[k += 1][3];
            }
        }
        int j = 0;
        for (int i = 0; i < buscar.size(); i += 6) {
            if (texto.equals((String) buscar.get(i))) {
                matriz[j][0] = (String) buscar.get(i);
                matriz[j][1] = (String) buscar.get(i + 1);
                matriz[j][2] = (String) buscar.get(i + 3);
                j += 1;
            }
        }
        añadirmatriz(matriz);
    }

    public void buscarautor(String autor, String tipo) {
        ArrayList buscar = MenuLogica.buscar(tipo);
        String[][] matriz = null;
        int k = 0;
        for (int x = 0; x < buscar.size(); x += 6) {
            if (autor.equals((String) buscar.get(x + 1))) {
                matriz = new String[k += 1][3];
            }
        }
        int j = 0;
        for (int i = 0; i < buscar.size(); i += 6) {
            if (autor.equals((String) buscar.get(i + 1))) {
                matriz[j][0] = (String) buscar.get(i);
                matriz[j][1] = (String) buscar.get(i + 1);
                matriz[j][2] = (String) buscar.get(i + 3);
                j += 1;
            }
        }
        añadirmatriz(matriz);
    }

    public void buscarprecio(int minimo, int maximo, String tipo) {
        ArrayList buscar = MenuLogica.buscar(tipo);
        String[][] matriz = null;
        int k = 0;
        for (int x = 0; x < buscar.size(); x += 6) {
            if ((minimo <= Integer.parseInt((String) buscar.get(x + 3))) & (maximo >= Integer.parseInt((String) buscar.get(x + 3)))) {
                matriz = new String[k += 1][3];
            }
        }
        int j = 0;
        for (int i = 0; i < buscar.size(); i += 6) {
            if ((minimo <= Integer.parseInt((String) buscar.get(i + 3))) & (maximo >= Integer.parseInt((String) buscar.get(i + 3)))) {
                matriz[j][0] = (String) buscar.get(i);
                matriz[j][1] = (String) buscar.get(i + 1);
                matriz[j][2] = (String) buscar.get(i + 3);
                j += 1;
            }
        }
        añadirmatriz(matriz);
    }
    
    public void buscarprecio2(int minimo, int maximo, String tipo) {
        ArrayList buscar = MenuLogica.buscar(tipo);
        String[][] matriz = null;
        int k = 0;
        for (int x = 0; x < buscar.size(); x += 5) {
            if ((minimo <= Integer.parseInt((String) buscar.get(x + 3))) & (maximo >= Integer.parseInt((String) buscar.get(x + 3)))) {
                matriz = new String[k += 1][3];
            }
        }
        int j = 0;
        for (int i = 0; i < buscar.size(); i += 5) {
            if ((minimo <= Integer.parseInt((String) buscar.get(i + 3))) & (maximo >= Integer.parseInt((String) buscar.get(i + 3)))) {
                matriz[j][0] = (String) buscar.get(i);
                matriz[j][1] = (String) buscar.get(i + 1);
                matriz[j][2] = (String) buscar.get(i + 3);
                j += 1;
            }
        }
        añadirmatriz(matriz);
    }

    public void añadirmatriz(String[][] matriz) {
        tblBusqueda.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String[]{
                    "Nombre", "Autor", "Precio"
                }
        ));
        txtBuscar.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        boxTipo = new javax.swing.JComboBox<>();
        boxBusqueda = new javax.swing.JComboBox<>();
        txtBuscar = new javax.swing.JTextField();
        spnMin = new javax.swing.JSpinner();
        lblA = new javax.swing.JLabel();
        spnMax = new javax.swing.JSpinner();
        btnBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBusqueda = new javax.swing.JTable();
        btnBuy = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Buscador:");

        boxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Musica", "Pelicula" }));

        boxBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Autor", "Precio" }));
        boxBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boxBusquedaMouseClicked(evt);
            }
        });
        boxBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxBusquedaActionPerformed(evt);
            }
        });

        txtBuscar.setText("Nombre del disco");
        txtBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscarMouseClicked(evt);
            }
        });

        spnMin.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99999, 1));

        lblA.setText("a");

        spnMax.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99999, 1));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblBusqueda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Autor", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblBusqueda);
        if (tblBusqueda.getColumnModel().getColumnCount() > 0) {
            tblBusqueda.getColumnModel().getColumn(0).setResizable(false);
            tblBusqueda.getColumnModel().getColumn(1).setResizable(false);
            tblBusqueda.getColumnModel().getColumn(2).setResizable(false);
        }

        btnBuy.setText("Comprar");
        btnBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyActionPerformed(evt);
            }
        });

        btnShow.setText("Ver");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        jButton1.setText("Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(boxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(boxBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(spnMin, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblA)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spnMax, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(btnBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(boxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblA)
                    .addComponent(spnMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuy, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if(("Musica".equals(boxTipo.getSelectedItem())) &&((txtBuscar.getText().equals("Nombre del disco")) || (txtBuscar.getText().equals("Nombre del autor")) || (txtBuscar.getText().equals("")))){
            buscarprecio(0, 99999, (String) boxTipo.getSelectedItem());
        }
        else if(("Pelicula".equals(boxTipo.getSelectedItem()))&&((txtBuscar.getText().equals("Nombre del disco")) || (txtBuscar.getText().equals("Nombre del autor")) || (txtBuscar.getText().equals("")))){
            buscarprecio2(0, 99999, (String) boxTipo.getSelectedItem());
        }
        else if ("Musica".equals(boxTipo.getSelectedItem())) {
            if ("Nombre".equals(boxBusqueda.getSelectedItem())) {
                buscarnombre(txtBuscar.getText(), (String) boxTipo.getSelectedItem());
            } else if ("Autor".equals(boxBusqueda.getSelectedItem())) {
                buscarautor(txtBuscar.getText(), (String) boxTipo.getSelectedItem());
            } else if ("Precio".equals(boxBusqueda.getSelectedItem())) {
                buscarprecio((int) spnMin.getValue(), (int) spnMax.getValue(), (String) boxTipo.getSelectedItem());
            }
        } else if ("Pelicula".equals(boxTipo.getSelectedItem())) {
            if ("Nombre".equals(boxBusqueda.getSelectedItem())) {
                buscarnombre(txtBuscar.getText(), (String) boxTipo.getSelectedItem());
            } else if ("Autor".equals(boxBusqueda.getSelectedItem())) {
                buscarautor(txtBuscar.getText(), (String) boxTipo.getSelectedItem());
            } else if ("Precio".equals(boxBusqueda.getSelectedItem())) {
                buscarprecio2((int) spnMin.getValue(), (int) spnMax.getValue(), (String) boxTipo.getSelectedItem());
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void boxBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxBusquedaActionPerformed
        busqueda();
    }//GEN-LAST:event_boxBusquedaActionPerformed

    private void boxBusquedaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxBusquedaMouseClicked

    }//GEN-LAST:event_boxBusquedaMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void txtBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarMouseClicked
        txtBuscar.setText("");
    }//GEN-LAST:event_txtBuscarMouseClicked

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyActionPerformed
        String nombre;
        int precio, cantidad;
        int fila = tblBusqueda.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(null, "Seleccione un disco para comprar","Mensaje",JOptionPane.WARNING_MESSAGE);
        }else{
            nombre = tblBusqueda.getValueAt(fila, 0).toString();
            precio = Integer.parseInt(tblBusqueda.getValueAt(fila, 2).toString());
            cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad de discos a comprar:"));
            ArrayList user = MenuLogica.Infouser(Username);
            MenuLogica.compras(boxTipo.getSelectedItem().toString(), nombre, precio, cantidad,listamusica,listapelicula,user);
        }

    }//GEN-LAST:event_btnBuyActionPerformed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        int fila = tblBusqueda.getSelectedRow();
        if(fila==-1){
            JOptionPane.showMessageDialog(null, "Seleccione un disco para ver el Preview","Mensaje",JOptionPane.WARNING_MESSAGE);
        }else{
            Ver ven = new Ver();
            ven.config(boxTipo.getSelectedItem().toString(), tblBusqueda.getValueAt(fila, 0).toString());
            ven.setVisible(true);
        }
    }//GEN-LAST:event_btnShowActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        Login ven = new Login();
        ven.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Menu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxBusqueda;
    private javax.swing.JComboBox<String> boxTipo;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuy;
    private javax.swing.JButton btnShow;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblA;
    private javax.swing.JSpinner spnMax;
    private javax.swing.JSpinner spnMin;
    private javax.swing.JTable tblBusqueda;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
