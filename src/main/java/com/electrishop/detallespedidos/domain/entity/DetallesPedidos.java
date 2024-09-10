package com.electrishop.detallespedidos.domain.entity;

public class DetallesPedidos {
    private int id_detalle_pedido;
    private int id_pedido;
    private int id_producto;
    private int cantidad_detalle_pedido;
    private int descuento;
    private double precio_detalle_pedido;

    // Constructor
    public DetallesPedidos(int id_pedido, int id_producto, int cantidad_detalle_pedido, int descuento, double precio_detalle_pedido) {
        this.id_pedido = id_pedido;
        this.id_producto = id_producto;
        this.cantidad_detalle_pedido = cantidad_detalle_pedido;
        this.descuento = descuento;
        this.precio_detalle_pedido = precio_detalle_pedido;
    }

    // Getters y setters
    public int getId_detalle_pedido() {
        return id_detalle_pedido;
    }

    public void setId_detalle_pedido(int id_detalle_pedido) {
        this.id_detalle_pedido = id_detalle_pedido;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad_detalle_pedido() {
        return cantidad_detalle_pedido;
    }

    public void setCantidad_detalle_pedido(int cantidad_detalle_pedido) {
        this.cantidad_detalle_pedido = cantidad_detalle_pedido;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public double getPrecio_detalle_pedido() {
        return precio_detalle_pedido;
    }

    public void setPrecio_detalle_pedido(double precio_detalle_pedido) {
        this.precio_detalle_pedido = precio_detalle_pedido;
    }
}
