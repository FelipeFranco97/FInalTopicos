package com.example.sebas.tutolab.Objetos;

/**
 * Created by sebas on 30/05/2018.
 */

public class Tutores {
    String Nombre;
    String Precio;
    String Tienda;

    public Tutores() {
    }

    public Tutores(String Nombre, String Precio, String Tienda) {
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

    public String getMateria() {
        return Precio;
    }

    public void setMateria(String Precio) {
        this.Precio = Precio;
    }

    public String getHorario() {
        return Tienda;
    }

    public void setHorario(String Tienda) {this.Tienda = Tienda;}
}


