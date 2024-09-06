package com.electrishop.categorias.domain.entity;

public class Categoria {
    // creamos las variables que vamos a utilizar segun la base de datos
    private int id_categoria;
    private String nombre_categoria;

    // creamos el constructor de las variables que vamos a utilizar
    public Categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    // implementamos los metodos getter y setter
    public int getId_categoria() {
        return id_categoria;
    }
    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    public String getNombre_categoria() {
        return nombre_categoria;
    }
    public void setNombre_categoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }

    
}
