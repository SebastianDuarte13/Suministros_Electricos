package com.electrishop.factura.domain.entity;

import java.sql.Date;

public class Factura {
    private int id_detalle_venta;
    private Date fecha_venta;
    private String nombre_cliente;
    private String apellido_cliente;
    private String nombre_producto;
    private String descripcion_producto;
    private int cantidad_productos;
    private double subprecio;
    private int descuento;
    private double total;
    public Factura(int id_detalle_venta, Date fecha_venta, String nombre_cliente, String apellido_cliente,
            String nombre_producto, String descripcion_producto, int cantidad_productos, double subprecio,
            int descuento, double total) {
        this.id_detalle_venta = id_detalle_venta;
        this.fecha_venta = fecha_venta;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.nombre_producto = nombre_producto;
        this.descripcion_producto = descripcion_producto;
        this.cantidad_productos = cantidad_productos;
        this.subprecio = subprecio;
        this.descuento = descuento;
        this.total = total;
    }
    public int getId_detalle_venta() {
        return id_detalle_venta;
    }
    public void setId_detalle_venta(int id_detalle_venta) {
        this.id_detalle_venta = id_detalle_venta;
    }
    public Date getFecha_venta() {
        return fecha_venta;
    }
    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }
    public String getNombre_cliente() {
        return nombre_cliente;
    }
    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }
    public String getApellido_cliente() {
        return apellido_cliente;
    }
    public void setApellido_cliente(String apellido_cliente) {
        this.apellido_cliente = apellido_cliente;
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
    public int getCantidad_productos() {
        return cantidad_productos;
    }
    public void setCantidad_productos(int cantidad_productos) {
        this.cantidad_productos = cantidad_productos;
    }
    public double getSubprecio() {
        return subprecio;
    }
    public void setSubprecio(double subprecio) {
        this.subprecio = subprecio;
    }
    public int getDescuento() {
        return descuento;
    }
    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    

    
    

    
}
