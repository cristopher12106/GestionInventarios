/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Date;

/**
 *
 * @author yordi
 */
public class Alimento extends Producto {
    private Date fechaCaducidad;

    public Alimento(Date fechaCaducidad, String idProducto, String nombre, String unidadMedida, float precio, int stock) {
        super(idProducto, nombre, unidadMedida, precio, stock);
        this.fechaCaducidad = fechaCaducidad;
    }
    
    public Alimento(Date fechaCaducidad, String nombre, String unidadMedida, float precio, int stock) {
        super(null, nombre, unidadMedida, precio, stock);
        this.fechaCaducidad = fechaCaducidad;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    
    
}
