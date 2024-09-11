package com.electrishop.historialventas.domain.entity;

import java.sql.Date;

public class HistorialVentas {
    // agragamos las variables queexisten en la base de datos
    private int id_venta;
    private Date fecha_venta;
    private String nombre_cliente;
    private String apellido_cliente;

    public HistorialVentas() {
    }

    // agregamos un constructor
    public HistorialVentas(int id_venta, Date fecha_venta, String nombre_cliente, String apellido_cliente) {
        this.id_venta = id_venta;
        this.fecha_venta = fecha_venta;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
    }

    // hacemos los metodos getter y setter
    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
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

}
