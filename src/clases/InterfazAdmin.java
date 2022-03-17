/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import javax.swing.ImageIcon;

/**
  * @author Ingeniero Alexander Gonzalez.
 */
public class InterfazAdmin extends javax.swing.JFrame {
    //Crea un objeto de la clase Validaciones que valida el inicio de sesion
    
    String nombreUsuario;
    
   
    public InterfazAdmin() {
                //e obtiene el nombre del usuario que ingreso
        nombreUsuario = Login.nombre;
        //Se inician los componentes del formulario
        initComponents();
        //Se asigna titulo con las variables se indica el tipo de usuario y el nombre 
        this.setTitle("Sesion de" + Login.tipoUser + " " + Login.username);
        //Se agrega una imagen para el icono del formulario
        this.setIconImage(new ImageIcon(getClass().getResource("/img/Admin.jpg")).getImage());
        //Para que el formulario inicie en el centro de la pantalla
        this.setLocationRelativeTo(null);
        //Impide que se cambie el tamaño del formulario
        this.setResizable(false);
        
    }

/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     **/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boton_RegUsuarios = new javax.swing.JButton();
        boton_perfilCapturista = new javax.swing.JButton();
        boton_Gestionar = new javax.swing.JButton();
        boton_perfilTecnico = new javax.swing.JButton();
        boton_creatividad = new javax.swing.JButton();
        boton_acercaDe = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        boton_RegUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/AgregarUs.jpg"))); // NOI18N
        boton_RegUsuarios.setMaximumSize(new java.awt.Dimension(257, 257));
        boton_RegUsuarios.setMinimumSize(new java.awt.Dimension(257, 257));
        boton_RegUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_RegUsuariosActionPerformed(evt);
            }
        });

        boton_perfilCapturista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Capturista.jpg"))); // NOI18N
        boton_perfilCapturista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_perfilCapturistaActionPerformed(evt);
            }
        });

        boton_Gestionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/GestionUsl.jpg"))); // NOI18N
        boton_Gestionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_GestionarActionPerformed(evt);
            }
        });

        boton_perfilTecnico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Tecnicol.jpg"))); // NOI18N
        boton_perfilTecnico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_perfilTecnicoActionPerformed(evt);
            }
        });

        boton_creatividad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Creatividad.jpg"))); // NOI18N

        boton_acercaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/AcercaDe.jpg"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Registo Usuarios");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Gestionar Usuarios");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Creatividad");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Perfil Capturista");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Perfil Tecnico");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Acerca de");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel8.setText("Creado por Ing Alexander Gonzalez G.");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Bienvenid@ " +nombreUsuario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(153, 153, 153))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton_perfilCapturista, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton_RegUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(boton_perfilTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boton_Gestionar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton_acercaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boton_creatividad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(boton_creatividad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(boton_Gestionar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boton_RegUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel1)))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boton_perfilCapturista, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_perfilTecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_acercaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jLabel8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_RegUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_RegUsuariosActionPerformed
        //Direcciona a la clase creando un objeto de ella se hace el llamado
        RegistrarUsuarios registrar = new RegistrarUsuarios();
        registrar.setVisible(true);
    }//GEN-LAST:event_boton_RegUsuariosActionPerformed

    private void boton_GestionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_GestionarActionPerformed
        //Direcciona a la clase creando un objeto de ella se hace el llamado
        GestionarUsuarios gestionar = new GestionarUsuarios();
        gestionar.setVisible(true);
    }//GEN-LAST:event_boton_GestionarActionPerformed

    private void boton_perfilCapturistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_perfilCapturistaActionPerformed
        //Direcciona a la clase creando un objeto de ella se hace el llamado
        InterfazCapturador capturador = new InterfazCapturador();
        capturador.setVisible(true);
    }//GEN-LAST:event_boton_perfilCapturistaActionPerformed

    private void boton_perfilTecnicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_perfilTecnicoActionPerformed
        //Direcciona a la clase creando un objeto de ella se hace el llamado
        InterfazTecnico tecnico = new InterfazTecnico();
        tecnico.setVisible(true);
    }//GEN-LAST:event_boton_perfilTecnicoActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazAdmin().setVisible(true);
            }
        });
    }
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_Gestionar;
    private javax.swing.JButton boton_RegUsuarios;
    private javax.swing.JButton boton_acercaDe;
    private javax.swing.JButton boton_creatividad;
    private javax.swing.JButton boton_perfilCapturista;
    private javax.swing.JButton boton_perfilTecnico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
