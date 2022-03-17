/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;


import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Ingeniero Alexander Gonzalez.
 */
public class InformacionEquipos extends javax.swing.JFrame {

    int idEquipo;
    int contador;
    String nombreCliente;
    String revisionTecnica;
   

    public InformacionEquipos() {
        
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/img/Capturista.jpg")).getImage());
        this.setTitle("Informacion Equipos - Sesion de " + Login.username);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        if ("Capturista".equals(Login.tipoUser)) {
            txt_comentariosTecnico.setEditable(false);
            txt_comentariosTecnico.setBackground(Color.GRAY);
            
        } else if("Tecnico".equals(Login.tipoUser)){
            txt_observaciones.setEditable(false);
            txt_observaciones.setBackground(Color.GRAY);
            String revisionTecnica;
           
        }else{
            txt_comentariosTecnico.setEditable(true);
            txt_observaciones.setEditable(true);
            
        }

    }

    public void validarCampos() {

        if (txt_modelo.getText().equals("") || txt_numeroSerie.getText().equals("")) {

            if (txt_modelo.getText().equals("")) {
                txt_modelo.setBackground(Color.red);
                contador++;
            } else {
                txt_modelo.setBackground(Color.green);
            }
            if (txt_numeroSerie.getText().equals("")) {
                txt_numeroSerie.setBackground(Color.red);
                contador++;
            } else {
                txt_numeroSerie.setBackground(Color.green);
            }

            JOptionPane.showMessageDialog(null, "Debe Diligenciar todos los campos");
        }
    }

    public void datosConsultados(String idEquipo, String nombreCliente) {
        this.idEquipo = Integer.parseInt(idEquipo);
        this.nombreCliente = nombreCliente;

        try {
            Conexion conex = new Conexion();
            conex.conexionBd();
            PreparedStatement pst = conex.conexionBd().prepareStatement("select * from equipos where id_equipo = ?");
            pst.setInt(1, this.idEquipo);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                txt_nombreCliente.setText(this.nombreCliente);
                comboTipoEquipo.setSelectedItem(rs.getString("tipo_equipo"));
                comboMarca.setSelectedItem(rs.getString("marca"));
                txt_modelo.setText(rs.getString("modelo"));
                txt_numeroSerie.setText(rs.getString("num_serie"));
                txt_fechaIngreso.setText(rs.getString("fecha_ingreso"));
                txt_observaciones.setText(rs.getString("observaciones"));
                comboStatus.setSelectedItem(rs.getString("status"));
                txt_ultimaModificacionPor.setText(rs.getString("ultima_modificacion"));
                txt_comentariosTecnico.setText(rs.getString("comentarios_tecnicos"));
                revisionTecnica = rs.getString("revision_tecnica");
                this.setTitle("Equipo del cliente " + this.nombreCliente + " Sesion de " + Login.tipoUser + " " + Login.username);

                conex.conexionBd().close();
                rs.close();
                pst.getConnection().close();
            }

        } catch (SQLException e) {
            System.out.println("ERROR en la conexion a la BD" + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_modelo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_numeroSerie = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_nombreCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboMarca = new javax.swing.JComboBox<>();
        comboTipoEquipo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_ultimaModificacionPor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboStatus = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_observaciones = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_comentariosTecnico = new javax.swing.JTextArea();
        botonActualizarEquipo = new javax.swing.JButton();
        txt_fechaIngreso = new javax.swing.JTextField();

        jLabel6.setText("Nùmero de serie:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel7.setText("Creado por Ing. Alexander Gonzalez G.");

        jLabel2.setText("Nombre del Cliente:");

        txt_nombreCliente.setEditable(false);
        txt_nombreCliente.setBackground(new java.awt.Color(230, 230, 230));

        jLabel3.setText("Tipo de equipo:");

        comboMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acer", "Alienware", "Apple", "Asus", "Brother", "Dell", "HP", "Janus", "Lenovo", "Samsung", "Toshiba", "Xerox", "Otra" }));

        comboTipoEquipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laptop", "Desktop", "Impresora", "Multifuncional", " " }));

        jLabel8.setText("Marca:");

        jLabel5.setText("Modelo:");

        jLabel1.setText("Ultima modificaciòn por:");

        txt_ultimaModificacionPor.setEditable(false);
        txt_ultimaModificacionPor.setBackground(new java.awt.Color(230, 230, 230));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Información de Equipo");

        jLabel9.setText("Fecha de Ingreso:");

        jLabel10.setText("Estatus:");

        comboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo ingreso", "No reparado", "En revision", "Reparado", "Entregado" }));
        comboStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboStatusActionPerformed(evt);
            }
        });

        jLabel11.setText("Daño reportado y Observaciones:");

        txt_observaciones.setColumns(20);
        txt_observaciones.setRows(5);
        jScrollPane1.setViewportView(txt_observaciones);

        jLabel12.setText("Comentarios y actualización del Técnico:");

        txt_comentariosTecnico.setColumns(20);
        txt_comentariosTecnico.setRows(5);
        jScrollPane2.setViewportView(txt_comentariosTecnico);

        botonActualizarEquipo.setText("Actualizar Equipo");
        botonActualizarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarEquipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonActualizarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(txt_numeroSerie, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(jLabel6)
                            .addComponent(txt_modelo, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(comboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(comboTipoEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txt_nombreCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(txt_ultimaModificacionPor))
                        .addGap(128, 128, 128)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(txt_fechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(154, 154, 154))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel11)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_fechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboTipoEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_numeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_ultimaModificacionPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonActualizarEquipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboStatusActionPerformed

    private void botonActualizarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarEquipoActionPerformed
        contador = 0;
        validarCampos();
        if (contador == 0) {
            try {
                Conexion conex = new Conexion();
                conex.conexionBd();
                
                /**
                 "update equipos SET tipo_equipo=?,"
                        + " marca=?, modelo=?, num_serie=?, fecha_ingreso=?, observaciones=?, status=?, "
                        + "ultima_modificacion=?, comentarios_tecnicos=?, revision_tecnica=? where id_equipo = ? 
                
                * */
                PreparedStatement pst = conex.conexionBd().prepareStatement("UPDATE equipos SET tipo_equipo=?,"
                        + "marca=?,modelo=?,num_serie=?,fecha_ingreso=?,observaciones=?,status=?,"
                        + "ultima_modificacion=?,comentarios_tecnicos=?,revision_tecnica=? "
                        + "WHERE id_equipo = ?");
                
                pst.setString(1, comboTipoEquipo.getSelectedItem().toString());
                pst.setString(2, comboMarca.getSelectedItem().toString());
                pst.setString(3, txt_modelo.getText().trim());
                pst.setString(4, txt_numeroSerie.getText().trim());
                pst.setString(5, txt_fechaIngreso.getText().trim());
                pst.setString(6, txt_observaciones.getText().trim());
                pst.setString(7, comboStatus.getSelectedItem().toString());
                pst.setString(8, Login.nombre);
                pst.setString(9, txt_comentariosTecnico.getText().trim());
                pst.setString(10, Login.nombre);
                pst.setInt(11, this.idEquipo);

                pst.execute();
                                                            
                txt_nombreCliente.setText("");
                txt_nombreCliente.setBackground(Color.green);
                comboTipoEquipo.setBackground(Color.green);
                comboMarca.setBackground(Color.green);
                txt_modelo.setBackground(Color.green);
                txt_modelo.setText("");
                txt_numeroSerie.setBackground(Color.green);
                txt_numeroSerie.setText("");
                comboStatus.setBackground(Color.green);
                txt_numeroSerie.setText("");
                txt_observaciones.setText("");
                txt_observaciones.setBackground(Color.green);
                txt_fechaIngreso.setText("");
                txt_fechaIngreso.setBackground(Color.green);
                txt_ultimaModificacionPor.setText("");
                txt_ultimaModificacionPor.setBackground(Color.green);

                JOptionPane.showMessageDialog(null, "Actualización exitosa");
                conex.conexionBd().close();
                pst.getConnection().close();
                
                this.setVisible(false);

            } catch (SQLException e) {
                System.out.println("ERROR en la conexion a la BD" + e);
            }

        }
    }//GEN-LAST:event_botonActualizarEquipoActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionEquipos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizarEquipo;
    private javax.swing.JComboBox<String> comboMarca;
    private javax.swing.JComboBox<String> comboStatus;
    private javax.swing.JComboBox<String> comboTipoEquipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txt_comentariosTecnico;
    private javax.swing.JTextField txt_fechaIngreso;
    private javax.swing.JTextField txt_modelo;
    private javax.swing.JTextField txt_nombreCliente;
    private javax.swing.JTextField txt_numeroSerie;
    private javax.swing.JTextArea txt_observaciones;
    private javax.swing.JTextField txt_ultimaModificacionPor;
    // End of variables declaration//GEN-END:variables
}
