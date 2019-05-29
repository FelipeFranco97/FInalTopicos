package com.example.sebas.tutolab.Objetos;

/**
 * Created by sebas on 5/06/2018.
 */

public class Productos {
    String Nombre;
    String Precio;
    String Tienda;

    public Productos() {
    }

    public Productos(String Nombre, String Precio, String Tienda) {
        this.Nombre = Nombre;
        this.Precio = Precio;
        this.Tienda = Tienda;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    public String getTienda() {
        return Tienda;
    }

    public void setTienda(String Tienda) {this.Tienda = Tienda;}
}
