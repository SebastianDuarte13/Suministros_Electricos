package com.electrishop.bodega.domain.entity;

public class Bodega {
    private int id_bodega;
    private int id_inventario;

    public Bodega(int id_inventario) {
        this.id_inventario = id_inventario;
    }

    public int getId_bodega() {
        return id_bodega;
    }

    public void setId_bodega(int id_bodega) {
        this.id_bodega = id_bodega;
    }

    public int getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }
}
