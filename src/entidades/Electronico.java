/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author yordi
 */
public class Electronico extends Producto {
    private int garantia_Meses;
    private String Fabricante;

    public Electronico(int garantia_Meses, String Fabricante, String idProducto, String nombre, String unidadMedida, float precio, int stock) {
        super(idProducto, nombre, unidadMedida, precio, stock);
        this.garantia_Meses = garantia_Meses;
        this.Fabricante = Fabricante;
    }
    
    public Electronico(int garantia_Meses, String Fabricante, String nombre, String unidadMedida, float precio, int stock) {
        super(null, nombre, unidadMedida, precio, stock);
        this.garantia_Meses = garantia_Meses;
        this.Fabricante = Fabricante;
    }

    public int getGarantia_Meses() {
        return garantia_Meses;
    }

    public void setGarantia_Meses(int garantia_Meses) {
        this.garantia_Meses = garantia_Meses;
    }

    public String getFabricante() {
        return Fabricante;
    }

    public void setFabricante(String Fabricante) {
        this.Fabricante = Fabricante;
    }
    
    
    
    
}
