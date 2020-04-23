package com.example.interfazusuario;

public class Articulos {
    String CodigoArticulos, descripcion;

    public Articulos(String codigoArticulos, String descripcion) {
        this.CodigoArticulos = codigoArticulos;
        this.descripcion = descripcion;
    }

    public String getCodigoArticulos() {
        return CodigoArticulos;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
