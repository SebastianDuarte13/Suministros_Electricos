package com.electrishop.sucursal.domain.entity;

public class Sucursal {
    private int id_sucursal;
    private String nombre;
    private String direccion;
    private String telefono;
    private int id_ciudad;
    private int id_producto;

    // Constructor
    public Sucursal(String nombre, String direccion, String telefono, int id_ciudad, int id_producto) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.id_ciudad = id_ciudad;
        this.id_producto = id_producto;
    }

    // Getters y setters
    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }
}
