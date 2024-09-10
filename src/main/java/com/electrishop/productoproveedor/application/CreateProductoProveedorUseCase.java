package com.electrishop.productoproveedor.application;

import com.electrishop.productoproveedor.domain.entity.ProductoProveedor;
import com.electrishop.productoproveedor.domain.service.ProductoProveedorService;

public class CreateProductoProveedorUseCase {
    private ProductoProveedorService productoProveedorService;

    public CreateProductoProveedorUseCase(ProductoProveedorService productoProveedorService) {
        this.productoProveedorService = productoProveedorService;
    }

    public void execute(ProductoProveedor productoProveedor) {
        productoProveedorService.addProductoProveedor(productoProveedor);
    }
}
