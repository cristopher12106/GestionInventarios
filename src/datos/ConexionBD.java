/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.sql.*;

/**
 *
 * @author yordi
 */
public class ConexionBD {
    private static final String URL = "jdbc:sqlserver://localhost:1433;"
                                        + "databaseName=Inventario;"
                                        + "user=sa;"
                                        + "password=123456;"
                                        + "encrypt=true;"
                                        + "trustServerCertificate=true;";
    
    
    private static Connection conexion = null;
    
    private ConexionBD () {};
    
    public static Connection getConexion(){
        try {
            if(conexion == null || conexion.isClosed()){
                conexion = DriverManager.getConnection(URL);
            }
        } catch (SQLException e){
            System.err.println("Error de conexion");
        }
        
        return conexion;
    }
    
    public static void cerrarConexion() throws SQLException{
        conexion.close();
    }
}
