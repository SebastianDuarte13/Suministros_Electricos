package com.electrishop.inventario.domain.entity;

import java.sql.Date;

public class Inventario {
    private int id_inventario;
    private int id_producto;
    private int cantidad_inventario;
    private Date fecha_ingreso;
    private Date fecha_actualizacion;

    public Inventario(int id_producto, int cantidad_inventario, Date fecha_ingreso, Date fecha_actualizacion) {
        this.id_producto = id_producto;
        this.cantidad_inventario = cantidad_inventario;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_actualizacion = fecha_actualizacion;
    }

    // Getters y setters
    public int getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad_inventario() {
        return cantidad_inventario;
    }

    public void setCantidad_inventario(int cantidad_inventario) {
        this.cantidad_inventario = cantidad_inventario;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(Date fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }
}
