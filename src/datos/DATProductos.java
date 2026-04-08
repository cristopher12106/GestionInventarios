/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import entidades.Alimento;
import entidades.Electronico;
import entidades.Producto;

import java.sql.*;

/**
 *
 * @author yordi
 */
public class DATProductos {
    
    
    public static void registrarProductoAlimento(Alimento p) throws SQLException{
        String sql = "INSERT INTO Producto (Nombre, Unidad_Medida, Precio, Stock) VALUES (?,?,?,?)";
        String alim = "INSERT INTO Alimentos (ID_Producto, Fecha_Caducidad) VALUES (?, ?)";
        
        Connection con = ConexionBD.getConexion();
        
        try {
            con.setAutoCommit(false);
            
            
            PreparedStatement pstmt = con.prepareStatement(sql);
                    
            pstmt.setString(1, p.getNombre());
            pstmt.setString(2, p.getUnidadMedida());
            pstmt.setFloat(3, p.getPrecio());
            pstmt.setInt(4, p.getStock());
            
            pstmt.executeUpdate();
            
            
            ResultSet rs = pstmt.getGeneratedKeys();
            
            int idGenerado = 0;
            
            if(rs.next()){
                idGenerado = rs.getInt(1);
            }
            
            PreparedStatement psAlim = con.prepareStatement(alim);
            
            psAlim.setInt(1, idGenerado);
            psAlim.setDate(2, (Date) p.getFechaCaducidad());
            
            psAlim.executeUpdate();
            
            con.commit();
            
            
            System.out.println("Producto guardado y conexión cerrada automáticamente.");
            
        } catch (SQLException e){
            con.rollback();
            throw e;
            
        }
    }
    
    public static void registrarProductoElectronico(Electronico p) throws SQLException {
        // Definición de las consultas
        String sqlProd = "INSERT INTO Producto (Nombre, Unidad_Medida, Precio, Stock) VALUES (?,?,?,?)";
        String sqlElec = "INSERT INTO Electronicos (ID_Producto, Garantia_Meses, Fabricante) VALUES (?, ?, ?)";

        Connection con = ConexionBD.getConexion();

        try {
            // 1. Iniciamos la transacción (Atomicidad)
            con.setAutoCommit(false);

            // 2. PREPARAR EL PADRE: Es vital pasar el segundo parámetro para recuperar el ID
            PreparedStatement pstmt = con.prepareStatement(sqlProd, java.sql.Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, p.getNombre());
            pstmt.setString(2, p.getUnidadMedida());
            pstmt.setDouble(3, p.getPrecio()); // Cambiado a Double por consistencia
            pstmt.setInt(4, p.getStock());

            // Ejecutamos la inserción en Producto
            pstmt.executeUpdate();

            // 3. RECUPERAR EL ID: Ahora sí funcionará sin el error "The statement must be executed..."
            ResultSet rs = pstmt.getGeneratedKeys();
            int idGenerado = 0;

            if (rs.next()) {
                idGenerado = rs.getInt(1);
            } else {
                throw new SQLException("Error: No se pudo obtener el ID autogenerado del Producto.");
            }

            // 4. PREPARAR LA HIJA (Electrónicos)
            PreparedStatement psElec = con.prepareStatement(sqlElec);
            psElec.setInt(1, idGenerado); // Usamos el ID recuperado
            psElec.setInt(2, p.getGarantia_Meses());
            psElec.setString(3, p.getFabricante());

            psElec.executeUpdate();

            // 5. SI TODO SALIÓ BIEN, HACEMOS EL COMMIT
            con.commit();

            System.out.println("Electrónico guardado exitosamente con ID: " + idGenerado);

        } catch (SQLException e) {
            // SI ALGO FALLA, DESHACEMOS LOS CAMBIOS
            if (con != null) {
                con.rollback();
            }
            // Re-lanzamos la excepción para que la interfaz gráfica (JOptionpane) la muestre
            throw e;
        }
    }
}
