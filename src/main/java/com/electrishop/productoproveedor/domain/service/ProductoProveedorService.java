package com.electrishop.productoproveedor.domain.service;

import com.electrishop.productoproveedor.domain.entity.ProductoProveedor;

public interface ProductoProveedorService {
    void addProductoProveedor(ProductoProveedor productoProveedor);
    ProductoProveedor findProductoProveedor(int id_producto, int id_proveedor);
    void deleteProductoProveedor(int id_producto, int id_proveedor);
}
