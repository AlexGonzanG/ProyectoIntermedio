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
import javax.swing.table.DefaultTableModel;
// Librerias para generar PDF
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
// Librerias para agregar imagen y dar formato al documento
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;

import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Ingeniero Alexander Gonzalez.
 */
public class InformacionClientes extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    int idCliente;
    int contador;
    String idEquipo;
    String nombreCliente;
    String agregar[] = new String[4];

    public InformacionClientes() {

        initComponents();
        model.addColumn("ID equipo");
        model.addColumn("Tipo de equipo");
        model.addColumn("Marca");
        model.addColumn("Status");
        this.tablaEquipos.setModel(model);
        this.setTitle("Informacion Clientes - Sesion de " + Login.username);
        this.setIconImage(new ImageIcon(getClass().getResource("/img/Capturista.jpg")).getImage());
        this.setLocationRelativeTo(null);
        this.setResizable(false);

    }

    public void validarCampos() {

        if (txt_nombre.getText().equals("") || txt_email.getText().equals("")
                || txt_telefono.getText().equals("") || txt_direccion.getText().equals("")) {

            if (txt_nombre.getText().equals("")) {
                txt_nombre.setBackground(Color.red);
                contador++;
            } else {
                txt_nombre.setBackground(Color.green);
            }
            if (txt_email.getText().equals("")) {
                txt_email.setBackground(Color.red);
                contador++;
            } else {
                txt_email.setBackground(Color.green);
            }
            if (txt_telefono.getText().equals("")) {
                txt_telefono.setBackground(Color.red);
                contador++;
            } else {
                txt_telefono.setBackground(Color.green);
            }
            if (txt_direccion.getText().equals("")) {
                txt_direccion.setBackground(Color.red);
                contador++;
            } else {
                txt_direccion.setBackground(Color.green);
            }

            JOptionPane.showMessageDialog(null, "Debe Diligenciar todos los campos");
        }
    }

    public void datosConsultados(String idCliente, String nombreCliente) {
        this.idCliente = Integer.parseInt(idCliente);
        this.nombreCliente = nombreCliente;

        try {
            Conexion conex = new Conexion();
            conex.conexionBd();
            PreparedStatement pst = conex.conexionBd().prepareStatement("select * from clientes where id_cliente = ?");
            PreparedStatement pst1 = conex.conexionBd().prepareStatement("select * from equipos where id_cliente = ?");

            pst.setInt(1, this.idCliente);
            pst1.setInt(1, this.idCliente);
            ResultSet rs = pst.executeQuery();
            ResultSet rs1 = pst1.executeQuery();

            if (rs.next()) {

                txt_nombre.setText(rs.getString("nombre_cliente"));
                txt_email.setText(rs.getString("mail_cliente"));
                txt_telefono.setText(rs.getString("tel_cliente"));
                txt_direccion.setText(rs.getString("dir_cliente"));
                txt_ultimaModificacion.setText(rs.getString("ultima_modificacion"));

                this.setTitle("Información Cliente " + this.nombreCliente + " Sesion de " + Login.tipoUser + " " + Login.username);
                jLabel1.setText("Informacion del Cliente " + this.nombreCliente);

            }

            while (rs1.next()) {

                agregar[0] = rs1.getString("id_equipo");
                agregar[1] = rs1.getString("tipo_equipo");
                agregar[2] = rs1.getString("marca");
                agregar[3] = rs1.getString("status");
                model.addRow(agregar);

            }
            conex.conexionBd().close();
            rs.close();
            pst.getConnection().close();
            
        } catch (SQLException e) {
            System.out.println("ERROR en la conexion a la BD" + e);
        }

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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_ultimaModificacion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEquipos = new javax.swing.JTable();
        botonRegistrarEquipo = new javax.swing.JButton();
        botonActualizarCliente = new javax.swing.JButton();
        botonGenerarReporte = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Información del cliente");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Em@il:");

        jLabel4.setText("Télefono:");

        jLabel5.setText("Dirección:");

        jLabel6.setText("Ultima Modificación:");

        txt_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefonoActionPerformed(evt);
            }
        });

        txt_ultimaModificacion.setEditable(false);
        txt_ultimaModificacion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel7.setText("Creado por Ing. Alexander Gonzalez G.");

        tablaEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaEquipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEquiposMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEquipos);

        botonRegistrarEquipo.setText("Registrar Equipo");
        botonRegistrarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarEquipoActionPerformed(evt);
            }
        });

        botonActualizarCliente.setText("Actualizar Cliente");
        botonActualizarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarClienteActionPerformed(evt);
            }
        });

        botonGenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/imprimir.jpg"))); // NOI18N
        botonGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGenerarReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txt_ultimaModificacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                .addComponent(txt_direccion, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_telefono, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_email, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_nombre, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonRegistrarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botonActualizarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)
                                .addComponent(botonGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 41, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(188, 188, 188))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonRegistrarEquipo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(botonActualizarCliente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_ultimaModificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botonGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefonoActionPerformed

    private void botonActualizarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarClienteActionPerformed
        contador = 0;
        validarCampos();
        if (contador == 0) {
            try {

                Conexion conex = new Conexion();
                conex.conexionBd();

                PreparedStatement pst = conex.conexionBd().prepareStatement("update clientes SET id_cliente=?, nombre_cliente=?, mail_cliente=?, tel_cliente=?, dir_cliente=?, ultima_modificacion=? where id_cliente = ? ");

                pst.setInt(1, this.idCliente);
                pst.setString(2, txt_nombre.getText().trim());
                pst.setString(3, txt_email.getText().trim());
                pst.setString(4, txt_telefono.getText().trim());
                pst.setString(5, txt_direccion.getText().trim());
                pst.setString(6, Login.nombre);
                pst.setInt(7, this.idCliente);

                pst.execute();
                txt_nombre.setText("");
                txt_nombre.setBackground(Color.green);
                txt_email.setText("");
                txt_email.setBackground(Color.green);
                txt_telefono.setText("");
                txt_telefono.setBackground(Color.green);
                txt_direccion.setText("");
                txt_direccion.setBackground(Color.green);
                JOptionPane.showMessageDialog(null, "Actualizaciòn Exitosa");
                this.setVisible(false);
                conex.conexionBd().close();
                pst.getConnection().close();
            } catch (SQLException e) {
                System.out.println("ERROR en la conexion a la BD" + e);
            }
        }


    }//GEN-LAST:event_botonActualizarClienteActionPerformed

    private void botonRegistrarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarEquipoActionPerformed
        RegistrarEquipos regEquipos = new RegistrarEquipos();
        regEquipos.setVisible(true);
        regEquipos.datosConsultados(idCliente, nombreCliente);


    }//GEN-LAST:event_botonRegistrarEquipoActionPerformed

    private void tablaEquiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEquiposMouseClicked
        int seleccion = tablaEquipos.rowAtPoint(evt.getPoint());
        idEquipo = String.valueOf(tablaEquipos.getValueAt(seleccion, 0));

        InformacionEquipos infoEquipos = new InformacionEquipos();
        infoEquipos.setVisible(true);
        infoEquipos.datosConsultados(idEquipo, nombreCliente);
    }//GEN-LAST:event_tablaEquiposMouseClicked

    private void botonGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGenerarReporteActionPerformed
        //Se crea objeto de la clase Document
        Document documento = new Document();
        //Try y Catch para exepcion de errores es necesario
        try {
            //Variable ruta, que nos da  la ruta de la carpeta de acceso donde vamos a guardar el documento
            String ruta = System.getProperty("user.home");
            //Indica al programa en donde va a guardar el documento se indica la ruta y la carpeta en este cado Desktop y se da el nombre del documento
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/ReportesCliente.pdf"));
            // codigo que permite insertar imagen en el documento
            Image header = Image.getInstance("src/img/header.png");
            //Le agregamos las dimensiones de nuestra imagen
            header.scaleToFit(650, 1000);
            //Nos permite alinear la imagen se le indica con Chunk
            header.setAlignment(Chunk.ALIGN_CENTER);

            //Damos Formato a la tabla
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Formato creado por Ing. Alexander Gonzalez \n\n");
            //Formato del texto
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            //Lo que va a ser el titulo
            parrafo.add("Información Cliente \n\n");
            //se Abre el objeto documento creado
            documento.open();
            //Agrega la Imagen y los parrafos que acabamos de crear
            documento.add(header);
            documento.add(parrafo);
            //vamos a crear tabla para el documento y se le indica cantidad de columnas en este caso 6
            PdfPTable tablaCliente = new PdfPTable(6);
            //Se asignan titulos a cada columna
            tablaCliente.addCell("Id Cliente");
            tablaCliente.addCell("Nombre");
            tablaCliente.addCell("Mail");
            tablaCliente.addCell("Teléfono");
            tablaCliente.addCell("Direccion");
            tablaCliente.addCell("Actualizo");

            PdfPTable tablaEquipo = new PdfPTable(4);
            tablaCliente.addCell("Id Equipo");
            tablaCliente.addCell("Tipo");
            tablaCliente.addCell("Marca");
            tablaCliente.addCell("Estatus");
            
            try {

                // conexion a BD
                Conexion conex = new Conexion();
                conex.conexionBd();
                PreparedStatement pst = conex.conexionBd().prepareStatement("select * from clientes where id_cliente =?");
                pst.setInt(1, this.idCliente);
                PreparedStatement pst1 = conex.conexionBd().prepareStatement("select id_equipo, tipo_equipo, marca, status from equipos where id_cliente = ?");
                pst1.setInt(1, this.idCliente);

                ResultSet rs = pst.executeQuery();
                ResultSet rs1 = pst1.executeQuery();
                if (rs.next()) {
                    do {
                        //Se crea la tabla segun los datos de la BD
                        tablaCliente.addCell(rs.getString(1));
                        tablaCliente.addCell(rs.getString(2));
                        tablaCliente.addCell(rs.getString(3));
                        tablaCliente.addCell(rs.getString(4));
                        tablaCliente.addCell(rs.getString(5));
                        tablaCliente.addCell(rs.getString(6));
                        System.out.println("\n\n\n");
                    } while (rs.next());
                    //Se adiciona la tabla al objeto Docuemnto
                    documento.add(tablaCliente);
                }
                if (rs1.next()) {
                    do {
                        //Se crea la tabla segun los datos de la BD
                        tablaEquipo.addCell(rs1.getString(1));
                        tablaEquipo.addCell(rs1.getString(2));
                        tablaEquipo.addCell(rs1.getString(3));
                        tablaEquipo.addCell(rs1.getString(4));

                    } while (rs1.next());
                    //Se adiciona la tabla al objeto Docuemnto
                    documento.add(tablaEquipo);
                }

                conex.conexionBd().close();
                rs.close();
                pst.getConnection().close();
            } catch (DocumentException | SQLException e) {
                System.out.println("Error en la conexion a la BD" + e);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado.");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            System.out.println("Error en PDF" + e);
        } catch (IOException e) {
            System.out.println("Error en la Imagen" + e);
        }


    }//GEN-LAST:event_botonGenerarReporteActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizarCliente;
    private javax.swing.JButton botonGenerarReporte;
    private javax.swing.JButton botonRegistrarEquipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEquipos;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_ultimaModificacion;
    // End of variables declaration//GEN-END:variables
}
