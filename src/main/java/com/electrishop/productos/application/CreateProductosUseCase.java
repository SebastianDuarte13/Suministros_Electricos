package com.electrishop.productos.application;

import com.electrishop.productos.domain.entity.Productos;
import com.electrishop.productos.domain.service.ProductosService;

public class CreateProductosUseCase {
    private final ProductosService productosService;

    public CreateProductosUseCase(ProductosService productosService) {
        this.productosService = productosService;
    }

    public void execute(Productos productos) {
        productosService.CreateProductos(productos);
    }
}
