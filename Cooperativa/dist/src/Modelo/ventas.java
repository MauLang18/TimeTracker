/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author maula
 */
public class ventas {
    private int ID;
    private int ID_BA;
    private int ID_LI;
    private String producto;
    private String grado;
    private int precio;
    private int cantidad;
    private String fecha;

    public int getID() {
        return ID;
    }

    public void setId(int ID) {
        this.ID = ID;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getID_BA() {
        return ID_BA;
    }

    public void setID_BA(int ID_BA) {
        this.ID_BA = ID_BA;
    }

    public int getID_LI() {
        return ID_LI;
    }

    public void setID_LI(int ID_LI) {
        this.ID_LI = ID_LI;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}
