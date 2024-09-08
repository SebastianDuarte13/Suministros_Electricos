package com.electrishop.compra.application;

import com.electrishop.compra.domain.entity.Compra;
import com.electrishop.compra.domain.service.CompraService;

public class CreateCompraUseCase {
    private final CompraService compraService;

    public CreateCompraUseCase(CompraService compraService) {
        this.compraService = compraService;
    }

    public void execute(Compra compra) {
        compraService.CreateCompra(compra);
    }
}
