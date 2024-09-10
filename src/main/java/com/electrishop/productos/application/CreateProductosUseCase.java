package com.electrishop.productos.application;

import com.electrishop.productos.domain.entity.Productos;
import com.electrishop.productos.domain.service.ProductosService;

public class CreateProductosUseCase {
    private final ProductosService productosService;

             // Constructor que recibe el servicio de productos
    public CreateProductosUseCase(ProductosService productosService) {
        this.productosService = productosService;
    }

            // Ejecuta la creación de un nuevo producto
    public void execute(Productos productos) {
        productosService.CreateProductos(productos);
    }
}
