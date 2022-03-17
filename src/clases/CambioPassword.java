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
 * @author Ingeniero Alexander Gonzalez
 */
public class CambioPassword extends javax.swing.JFrame {
//Declaracion de variables
    private String password;
    private String confPassword;
    String nombreUsuario;
    private int idAactualizarPassword;
   
    
    public CambioPassword() {
        //Se inician los componentes del form
        initComponents();
        //se agrega imagen para el icono del form
        this.setIconImage(new ImageIcon(getClass().getResource("/img/Capturista.jpg")).getImage());
        //Se ubica el formulario en el centro de la pantalla
        this.setLocationRelativeTo(null);
        ////para que no se modifique el tamaño del formulario
        this.setResizable(false);
    }
    
    public void datoActualizar(int id, String usernameUsuario){
       //Se recuperan los datos de id y usuario que se requiere modificar
       idAactualizarPassword = id;
       nombreUsuario = usernameUsuario;
       this.setTitle("Password para " +nombreUsuario);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txt_password = new javax.swing.JPasswordField();
        txt_confPassword = new javax.swing.JPasswordField();

        jLabel1.setText("CAMBIO DE PASSWORD");

        jLabel2.setText("Nuevo Password");

        jLabel3.setText("Confirmar Password");

        jButton1.setText("Restaurar Password");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_password)
                            .addComponent(txt_confPassword)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(0, 40, Short.MAX_VALUE)))))
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_confPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Se recuperan los datos ingresados en los campos
        password = String.valueOf(txt_password.getPassword());
        confPassword = String.valueOf(txt_confPassword.getPassword());
        //Se verifica que los campos no esten vacios
        if(password.equals("") || confPassword.equals("")){
            
            JOptionPane.showMessageDialog(null, "No puedes dejar campos en blanco");
            //Se le asigna un color al campo si hay datos verde o si esta en blanco rojo 
            if(password.equals("")){
                txt_password.setBackground(Color.red);
            }else
                txt_password.setBackground(Color.green);
            if(confPassword.equals("")){
               txt_confPassword.setBackground(Color.red);
            }else{
                txt_confPassword.setBackground(Color.green);
            }
            
            
        //Valida que el password y su confirmacion sean identicos    
        }else if(!password.equals(confPassword)){
            JOptionPane.showMessageDialog(null, "El Password y Confirmacion son Diferentes Intente nuevamente");
                        
        }else{
            //Try catch necesarios para las exepciones de conexion a la BD
            try {
                //Llama la clase que tiene la conexion a la BD
                Conexion conex = new Conexion();
                conex.conexionBd();
                //Realiza la consulta sql para actualizar el passwors del usuario segun su id
                PreparedStatement pst = conex.conexionBd().prepareStatement("update usuarios SET password=? where id_usuario =?");
                 //Se toma el valor que ingreso el usuario en el texfield y se le asigna 1 que es el primer ? igual 2 para el segundo ? que valida la consulta 
                pst.setString(1, password);
                pst.setInt(2, idAactualizarPassword);
                //Ejecuta la consulta
                pst.execute();
                //Se limpia el campo
                txt_password.setText("");
                //Se le da color verde
                txt_password.setBackground(Color.green);
                //Se limpia el campo
                txt_confPassword.setText("");
                //Se le da color verde
                txt_confPassword.setBackground(Color.green);
                
                JOptionPane.showMessageDialog(null, "El Password se actualizo correctamente");
                
                //Cierra el form
                this.setVisible(false);
                // crea un objeto de la clase y redirecciona 
                InformacionUsuarios infousuarios = new InformacionUsuarios();
                infousuarios.setVisible(true);
                //Envia a la informacion de los usuarios el id y nombre de usuario
                infousuarios.datosConsultados(String.valueOf(idAactualizarPassword), nombreUsuario);
                //Cierra la conexion a la BD
                conex.conexionBd().close();
                pst.getConnection().close();
                
            } catch (SQLException e) {
                System.out.println("ERROR Conexion a la Base de Datos" + e);
            }
        }
            
        
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
            java.util.logging.Logger.getLogger(CambioPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CambioPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CambioPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CambioPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CambioPassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txt_confPassword;
    private javax.swing.JPasswordField txt_password;
    // End of variables declaration//GEN-END:variables
}
