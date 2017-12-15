/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.chocolateria.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gustavo Leiva
 */
public class Conexion {
    
    
    private static Connection conexion;
    
    private Conexion(){}
            
    public static Connection obtenerInstancia()
    {
        if(conexion == null){
            String url = "jdbc:oracle:thin:MSP-PM-04-07.aws.smartcloud.cl:1521:xe";
            String user = "usuario07";
            String pass = "usuario07";
            System.out.println("Proceso de Conexión...");
            try {
                conexion = DriverManager.getConnection(url, user, pass);
                System.out.println("Conexión realizada a la base de datos con éxito.");
            }catch(SQLException e) {
                System.out.println("Error!, conexión fallida a la base de datos.");
            }
        }
        return conexion;
    }
}
