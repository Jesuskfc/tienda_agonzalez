package Productos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jesuskfc
 */
public class CantidadProducto {
    public int idProducto;
    public int cantidad;
    public float precio;

    public CantidadProducto(int idProducto, int cantidad,float precio) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public CantidadProducto() {
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
