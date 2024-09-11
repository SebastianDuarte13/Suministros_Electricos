package com.electrishop.productoproveedor.domain.service;

import com.electrishop.productoproveedor.domain.entity.ProductoProveedor;

public interface ProductoProveedorService {
    // creamos el servicio de lo que vamos a hacer en este caso solo agregar

    void addProductoProveedor(ProductoProveedor productoProveedor);

    ProductoProveedor findProductoProveedor(int id_producto, int id_proveedor);

    void deleteProductoProveedor(int id_producto, int id_proveedor);
}
