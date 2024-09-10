package com.electrishop.bodega.application;

import com.electrishop.bodega.domain.entity.Bodega;
import com.electrishop.bodega.domain.service.BodegaService;

public class CreateBodegaUseCase {
    private BodegaService bodegaService;

     // Constructor que recibe el servicio de bodega
    public CreateBodegaUseCase(BodegaService bodegaService) {
        this.bodegaService = bodegaService;
    }
    
    // Ejecuta la creación de una nueva bodega
    public void execute(Bodega bodega) {
        bodegaService.createBodega(bodega);
    }
}
