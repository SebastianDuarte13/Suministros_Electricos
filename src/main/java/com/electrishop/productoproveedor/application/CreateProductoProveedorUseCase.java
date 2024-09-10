package com.electrishop.productoproveedor.application;

import com.electrishop.productoproveedor.domain.entity.ProductoProveedor;
import com.electrishop.productoproveedor.domain.service.ProductoProveedorService;

public class CreateProductoProveedorUseCase {
    private ProductoProveedorService productoProveedorService;

             // Constructor que recibe el servicio de productoprovedor
    public CreateProductoProveedorUseCase(ProductoProveedorService productoProveedorService) {
        this.productoProveedorService = productoProveedorService;
    }

            // Ejecuta la creación de un nuev producto provedor
    public void execute(ProductoProveedor productoProveedor) {
        productoProveedorService.addProductoProveedor(productoProveedor);
    }
}
