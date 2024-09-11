package com.electrishop.productos.domain.service;

import com.electrishop.productos.domain.entity.Productos;

public interface ProductosService {
    // creamos el servicio de lo que vamos a hacer en este caso solo agregar

    Productos FindProductosById(int id_producto);

    void CreateProductos(Productos productos);

    void UpdateProductos(Productos productos);

    void DeleteProductos(int id_producto);
}
