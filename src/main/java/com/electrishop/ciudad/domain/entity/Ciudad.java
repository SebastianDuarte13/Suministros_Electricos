package com.electrishop.ciudad.domain.entity;

public class Ciudad {
    // agragamos las variables queexisten en la base de datos
    private int id_ciudad;
    private String nombre;
    private int id_pais;

    //agregamos un constructor
    public Ciudad(int id_ciudad, String nombre, int id_pais) {
        this.id_ciudad = id_ciudad;
        this.nombre = nombre;
        this.id_pais = id_pais;
    }
    // hacemos los metodos getter y setter
    public int getId_ciudad() {
        return id_ciudad;
    }
    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getId_pais() {
        return id_pais;
    }
    public void setId_pais(int id_pais) {
        this.id_pais = id_pais;
    }

    
}
