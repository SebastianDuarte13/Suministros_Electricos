package com.electrishop.productoproveedor.domain.entity;

public class ProductoProveedor {
    private int id_producto;
    private int id_proveedor;

    // Constructor
    public ProductoProveedor(int id_producto, int id_proveedor) {
        this.id_producto = id_producto;
        this.id_proveedor = id_proveedor;
    }

    // Getters y setters
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }
}
