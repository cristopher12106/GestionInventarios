/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import datos.DATProductos;
import entidades.Alimento;
import entidades.Electronico;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author yordi
 */
public class LOGProductos {
    
    public static boolean registrarAlimento(Date fechaCaducidad, String nombre, String unidadMedida, float precio, int stock) throws SQLException{
        if(nombre.length() < 2){
            JOptionPane.showMessageDialog(null, "Nombre no valido", "Error de validacion", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(precio < 0){
            JOptionPane.showMessageDialog(null, "Precio no valido", "Error de validacion", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(stock < 0){
            JOptionPane.showMessageDialog(null, "Stock no valido", "Error de validacion", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        DATProductos.registrarProductoAlimento(new Alimento(fechaCaducidad, nombre, unidadMedida, precio, stock));
        JOptionPane.showMessageDialog(null, "Registro exitoso", "Confirmacion de operacion", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
    
    public static boolean registrarElectronico(int garantia_Meses, String Fabricante, String nombre, String unidadMedida, float precio, int stock) throws SQLException{
        if(nombre.length() < 2){
            JOptionPane.showMessageDialog(null, "Nombre no valido", "Error de validacion", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(precio < 0){
            JOptionPane.showMessageDialog(null, "Precio no valido", "Error de validacion", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(stock < 0){
            JOptionPane.showMessageDialog(null, "Stock no valido", "Error de validacion", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(garantia_Meses < 0){
            JOptionPane.showMessageDialog(null, "Garantia no valido", "Error de validacion", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(Fabricante.length() < 2){
            JOptionPane.showMessageDialog(null, "Fabricante no valido", "Error de validacion", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        DATProductos.registrarProductoElectronico(new Electronico(garantia_Meses, Fabricante, nombre,unidadMedida,precio, stock));
        JOptionPane.showMessageDialog(null, "Registro exitoso", "Confirmacion de operacion", JOptionPane.INFORMATION_MESSAGE);
        return true;
    }
}
