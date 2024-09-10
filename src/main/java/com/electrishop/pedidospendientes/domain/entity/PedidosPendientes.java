package com.electrishop.pedidospendientes.domain.entity;

import java.sql.Date;

public class PedidosPendientes {
    private int id_pedido;
    private String nombre_cliente;
    private String apellido_cliente;
    private String estado_pedido;
    private Date fecha_pedido;

    public PedidosPendientes(int id_pedido, String nombre_cliente, String apellido_cliente, String estado_pedido, Date fecha_pedido) {
        this.id_pedido = id_pedido;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.estado_pedido = estado_pedido;
        this.fecha_pedido = fecha_pedido;
    }

    public int getId_pedido() {
        return id_pedido;
    }
    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
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
    public String getEstado_pedido() {
        return estado_pedido;
    }
    public void setEstado_pedido(String estado_pedido) {
        this.estado_pedido = estado_pedido;
    }
    public Date getFecha_pedido() {
        return fecha_pedido;
    }
    public void setFecha_pedido(Date fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }
}
