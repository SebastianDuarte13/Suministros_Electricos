package com.electrishop.detallescompra.application;

import com.electrishop.detallescompra.domain.entity.DetallesCompra;
import com.electrishop.detallescompra.domain.service.DetallesCompraService;

public class CreateDetallesCompraUseCase {
    private DetallesCompraService detallesCompraService;

    public CreateDetallesCompraUseCase(DetallesCompraService detallesCompraService) {
        this.detallesCompraService = detallesCompraService;
    }

    public void execute(DetallesCompra detallesCompra) {
        detallesCompraService.addDetallesCompra(detallesCompra);
    }
}
