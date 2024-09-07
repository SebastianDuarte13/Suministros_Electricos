package com.electrishop.productos.domain.service;

import com.electrishop.productos.domain.entity.Productos;

public interface ProductosService {
    Productos FindProductosById(int id_producto);
    void CreateProductos(Productos productos);
    void UpdateProductos(Productos productos);
    void DeleteProductos(int id_producto);
}
