package com.electrishop.detallescompra.application;

import com.electrishop.detallescompra.domain.entity.DetallesCompra;
import com.electrishop.detallescompra.domain.service.DetallesCompraService;

public class CreateDetallesCompraUseCase {
    private DetallesCompraService detallesCompraService;

         // Constructor que recibe el servicio de detalles de compra
    public CreateDetallesCompraUseCase(DetallesCompraService detallesCompraService) {
        this.detallesCompraService = detallesCompraService;
    }

        // Ejecuta la creación de un nuevo detalle de compra
    public void execute(DetallesCompra detallesCompra) {
        detallesCompraService.addDetallesCompra(detallesCompra);
    }
}
