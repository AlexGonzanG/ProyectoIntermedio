/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Ingeniero Alexander Gonzalez.
 */
public class RegistrarUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarUsuarios
     */
    int contador = 0;

    public RegistrarUsuarios() {
       
        initComponents();
        this.setTitle("Registrar nuevo usuario - Sesion de " + Login.username);
        this.setIconImage(new ImageIcon(getClass().getResource("/img/Admin.jpg")).getImage());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public void validarCampos() {

        if (jTextField1_nombre.getText().equals("") || jTextField1_email.getText().equals("")
                || jTextField1_telefono.getText().equals("") || jTextField1_usuario.getText().equals("")
                || contrasena.getText().equals("")) {

            if (jTextField1_nombre.getText().equals("")) {
                jTextField1_nombre.setBackground(Color.red);
                contador++;
            } else {
                jTextField1_nombre.setBackground(Color.green);
            }
            if (jTextField1_email.getText().equals("")) {
                jTextField1_email.setBackground(Color.red);
                contador++;
            } else {
                jTextField1_email.setBackground(Color.green);
            }
            if (jTextField1_telefono.getText().equals("")) {
                jTextField1_telefono.setBackground(Color.red);
                contador++;
            } else {
                jTextField1_telefono.setBackground(Color.green);
            }
            if (jTextField1_usuario.getText().equals("")) {
                jTextField1_usuario.setBackground(Color.red);
                contador++;
            } else {
                jTextField1_usuario.setBackground(Color.green);
            }
            if (contrasena.getText().equals("")) {
                contrasena.setBackground(Color.red);
                contador++;
            } else {
                contrasena.setBackground(Color.green);
            }
            JOptionPane.showMessageDialog(null, "Debe Diligenciar todos los campos");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1_usuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1_email = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField1_telefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        contrasena = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField1_nombre = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Registro de Usuarios");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Username: ");

        jLabel4.setText("email: ");

        jLabel5.setText("Password: ");

        jTextField1_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1_emailActionPerformed(evt);
            }
        });

        jLabel6.setText("Telefono: ");

        jTextField1_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1_telefonoKeyTyped(evt);
            }
        });

        jLabel7.setText("Permiso de: ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Capturista", "Tecnico", " " }));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/AgregarUs.jpg"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel8.setText("Creado por Ing Alexander Gonzalez G.");

        jTextField1_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1_nombreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1_telefono, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addComponent(jTextField1_email)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField1_nombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(jTextField1_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addComponent(contrasena))
                    .addComponent(jButton1))
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel8)))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jLabel8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        contador = 0;
        validarCampos();
        if (contador == 0) {
            try {
                Conexion conex = new Conexion();
                conex.conexionBd();
                //PreparedStatement pst = conex.conexionBd().prepareStatement("insert into usuarios id_usuario = ? nombre_usuario = ? email = ? telefono = ? username = ? password = ? tipo_nivel = ? status = ? registrado_por = ? ");
                PreparedStatement pst = conex.conexionBd().prepareStatement("insert into usuarios (id_usuario, nombre_usuario, email, telefono, username, password, tipo_nivel, status, registrado_por) values(?,?,?,?,?,?,?,?,?)");

                pst.setString(1, "0");
                pst.setString(2, jTextField1_nombre.getText().trim());
                pst.setString(3, jTextField1_email.getText().trim());
                pst.setString(4, jTextField1_telefono.getText().trim());
                pst.setString(5, jTextField1_usuario.getText().trim());
                pst.setString(6, String.valueOf(contrasena.getPassword()));
                pst.setString(7, jComboBox1.getSelectedItem().toString());
                pst.setString(8, Login.status);
                pst.setString(9, Login.nombre);

                pst.execute();

                jTextField1_nombre.setText("");
                jTextField1_nombre.setBackground(Color.green);
                jTextField1_email.setText("");
                jTextField1_email.setBackground(Color.green);
                jTextField1_telefono.setText("");
                jTextField1_telefono.setBackground(Color.green);
                jTextField1_usuario.setText("");
                jTextField1_usuario.setBackground(Color.green);
                contrasena.setText("");
                contrasena.setBackground(Color.green);
                JOptionPane.showMessageDialog(null, "Registro Exitoso");
                conex.conexionBd().close();
                pst.getConnection().close();
                this.setVisible(false);

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR en la conexion a la BD" + e);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1_telefonoKeyTyped
        //valida que solo se ingresen numeros  
        char c = evt.getKeyChar();
        if (c < '0' || c > '9') {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField1_telefonoKeyTyped

    private void jTextField1_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_emailActionPerformed

    private void jTextField1_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1_nombreActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField contrasena;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1_email;
    private javax.swing.JTextField jTextField1_nombre;
    private javax.swing.JTextField jTextField1_telefono;
    private javax.swing.JTextField jTextField1_usuario;
    // End of variables declaration//GEN-END:variables
}
