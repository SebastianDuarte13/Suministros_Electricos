package com.electrishop.detallesventas.domain.entity;

public class DetallesVentas {
    private int id_detalle_venta;
    private int id_venta;
    private int id_producto;
    private int cantidad_productos;
    private double subprecio;
    private int descuento;
    private double total;

    // Constructor
    public DetallesVentas(int id_venta, int id_producto, int cantidad_productos, double subprecio, int descuento, double total) {
        this.id_venta = id_venta;
        this.id_producto = id_producto;
        this.cantidad_productos = cantidad_productos;
        this.subprecio = subprecio;
        this.descuento = descuento;
        this.total = total;
    }

    // Getters y setters
    public int getId_detalle_venta() {
        return id_detalle_venta;
    }

    public void setId_detalle_venta(int id_detalle_venta) {
        this.id_detalle_venta = id_detalle_venta;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
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
