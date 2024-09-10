package com.electrishop.compra.application;

import com.electrishop.compra.domain.entity.Compra;
import com.electrishop.compra.domain.service.CompraService;

public class CreateCompraUseCase {
    private final CompraService compraService;

         // Constructor que recibe el servicio de compra
    public CreateCompraUseCase(CompraService compraService) {
        this.compraService = compraService;
    }

        // Ejecuta la creación de una nueva compra
    public void execute(Compra compra) {
        compraService.CreateCompra(compra);
    }
}
