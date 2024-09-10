package com.electrishop.factura.application;

import com.electrishop.factura.domain.entity.Factura;
import com.electrishop.factura.domain.service.FacturaService;

public class CreateFacturaUseCase {
    private final FacturaService facturaService;

             // Constructor que recibe el servicio de factura
    public CreateFacturaUseCase(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

            // Ejecuta la creación de un nueva factura
    public void execute(Factura factura) {
        facturaService.FindFacturaById(0);
    }
}
