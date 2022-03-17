/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates.
 * and open the template in the editor.
 */
package clases;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ingeniero Alexander Gonzalez
 */
public class GeneradorPdf {
    
    public void generaClientes(){
        //Se crea objeto de la clase Document
        Document documento = new Document();
       //Try y Catch para exepcion de errores es necesario
        try {
            //Variable ruta, que nos da  la ruta de la carpeta de acceso donde vamos a guardar el documento
            String ruta = System.getProperty("user.home");
            //Indica al programa en donde va a guardar el documento se indica la ruta y la carpeta en este cado Desktop y se da el nombre del documento
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Reporte_Clientes.pdf"));
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
            parrafo.add("Clientes Registrados \n\n");
            //se Abre el objeto documento creado
            documento.open();
            //Agrega la Imagen y los parrafos que acabamos de crear
            documento.add(header);
            documento.add(parrafo);
            //vamos a crear tabla para el documento y se le indica cantidad de columnas en este caso 6
            PdfPTable tabla = new PdfPTable(6);
            //Se asignan titulos a cada columna
            tabla.addCell("Id Cliente");
            tabla.addCell("Nombre");
            tabla.addCell("Mail");
            tabla.addCell("Teléfono");
            tabla.addCell("Direccion");
            tabla.addCell("Actualizo");
            
            
            
            // conexion a BD
            try {
                //Se llama a la clase conexiones
                Conexion conex = new Conexion();
                //se invoca el metodo conexionbd() que hace la conexion
                conex.conexionBd();
                //se hace la consulta sql que se requiere 
                PreparedStatement pst = conex.conexionBd().prepareStatement("select * from clientes");
                ResultSet rs = pst.executeQuery();
                
                if(rs.next()){
                    do {          
                        //Se crea la tabla segun los datos de la BD
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        
                                               
                    } while (rs.next());
                    //Se adiciona la tabla al objeto Docuemnto
                    documento.add(tabla);
                }
                conex.conexionBd().close();
                rs.close();
                pst.getConnection().close();
            } catch (DocumentException | SQLException e) {
                System.out.println("Error en la conexion a la BD" +e);
            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Reporte creado.");
        } catch (DocumentException | HeadlessException | FileNotFoundException e) {
            System.out.println("Error en PDF" + e);
        } catch(IOException e){
            System.out.println("Error en la Imagen" + e);
        }
    }                      
    }
    

