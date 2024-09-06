package com.electrishop.direccioncliente.domain.entity;

public class Direccion {
     // creamos las variables que vamos a utilizar segun la base de datos
    private int id_direccion;
    private String direccion;

    // creamos el constructor de las variables que vamos a utilizar
    public Direccion(String direccion) {
        this.direccion = direccion;
    }

    // implementamos los metodos getter y setter
    public int getId_direccion() {
        return id_direccion;
    }
    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
}
