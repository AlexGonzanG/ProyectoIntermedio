package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexiones {
    
   
    public  Connection conexionBd(){

        try {
            //Se declaran variables para hacer la conexion a la Base de datos
            //url tiene conexion la url de servidor:el puerto del servidor que se verifica por phpmyadmin y el nombre de la BD
            String url = "jdbc:mysql://localhost:3306/bd_gestionman";
            //esta variable con el nombre del usuario del servidor o tambien usuario de la BD si tiene
            String usuario = "root";
            //Esta es la contraseña del servidor o del usuario de la BD si tiene
            String pasword = "";
            //Se realiza la conexion a la base de datos remota con los datos declarados
            Connection cn = DriverManager.getConnection(url, usuario, pasword);
    
            return cn;
        } catch (SQLException e) {
            System.out.println("ERROR: " + e);
        }
        return null;
    }
    
}
