package com.electrishop.compra.domain.entity;

import java.sql.Date;

public class Compra {
    private int id_compra;
    private int id_proveedor;
    private Date fecha_compra;
    private int precio_compra;
    public Compra(int id_proveedor, Date fecha_compra, int precio_compra) {
        this.id_proveedor = id_proveedor;
        this.fecha_compra = fecha_compra;
        this.precio_compra = precio_compra;
    }
    public int getId_compra() {
        return id_compra;
    }
    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }
    public int getId_proveedor() {
        return id_proveedor;
    }
    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }
    public Date getFecha_compra() {
        return fecha_compra;
    }
    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }
    public int getPrecio_compra() {
        return precio_compra;
    }
    public void setPrecio_compra(int precio_compra) {
        this.precio_compra = precio_compra;
    }

    

}
