package com.electrishop.pedido.domain.entity;

import java.sql.Timestamp;

public class Pedido {
    private int id_pedido;
    private int id_cliente;
    private Timestamp fecha_pedido;
    private String estado_pedido;

    // Constructor del pedido
    public Pedido(int id_cliente, Timestamp fecha_pedido, String estado_pedido) {
        this.id_cliente = id_cliente;
        this.fecha_pedido = fecha_pedido;
        this.estado_pedido = estado_pedido;
    }

    // Getters y setters
    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Timestamp getFecha_pedido() {
        return fecha_pedido;
    }

    public void setFecha_pedido(Timestamp fecha_pedido) {
        this.fecha_pedido = fecha_pedido;
    }

    public String getEstado_pedido() {
        return estado_pedido;
    }

    public void setEstado_pedido(String estado_pedido) {
        this.estado_pedido = estado_pedido;
    }

  
}
