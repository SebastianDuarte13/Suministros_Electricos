package com.electrishop.productos.domain.entity;

import java.math.BigDecimal;

public class Productos {
    // agragamos las variables queexisten en la base de datos
    private int id_producto;
    private String nombre_producto;
    private String descripcion_producto;
    private BigDecimal precio_producto;
    private int id_categoria;

    // agregamos un constructor
    public Productos(String nombre_producto, String descripcion_producto, BigDecimal precio_producto,
            int id_categoria) {
        this.nombre_producto = nombre_producto;
        this.descripcion_producto = descripcion_producto;
        this.precio_producto = precio_producto;
        this.id_categoria = id_categoria;
    }

    // hacemos los metodos getter y setter
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public BigDecimal getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(BigDecimal precio_producto) {
        this.precio_producto = precio_producto;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

}
