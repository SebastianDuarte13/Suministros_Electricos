package com.electrishop.detallescompra.domain.entity;

public class DetallesCompra {
    private int id_detalles_compra;
    private int id_compra;
    private int id_producto;
    private String nombre_compra;
    private String detalles;
    private int cantidad;
    private int precio_unidad;

    // Constructor
    public DetallesCompra(int id_compra, int id_producto, String nombre_compra, String detalles, int cantidad, int precio_unidad) {
        this.id_compra = id_compra;
        this.id_producto = id_producto;
        this.nombre_compra = nombre_compra;
        this.detalles = detalles;
        this.cantidad = cantidad;
        this.precio_unidad = precio_unidad;
    }

    // Getters y setters
    public int getId_detalles_compra() {
        return id_detalles_compra;
    }

    public void setId_detalles_compra(int id_detalles_compra) {
        this.id_detalles_compra = id_detalles_compra;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_compra() {
        return nombre_compra;
    }

    public void setNombre_compra(String nombre_compra) {
        this.nombre_compra = nombre_compra;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio_unidad() {
        return precio_unidad;
    }

    public void setPrecio_unidad(int precio_unidad) {
        this.precio_unidad = precio_unidad;
    }
}
