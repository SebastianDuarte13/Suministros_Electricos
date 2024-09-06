package com.electrishop.pais.domain.entity;

public class Pais {
     // creamos las variables que vamos a utilizar segun la base de datos
    private int id_pais;
    private String nombre;
    
    // creamos el constructor de las variables que vamos a utilizar
    public Pais(String nombre) {
        this.nombre = nombre;
    }

    // implementamos los metodos getter y setter
    public int getId_pais() {
        return id_pais;
    }

    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
