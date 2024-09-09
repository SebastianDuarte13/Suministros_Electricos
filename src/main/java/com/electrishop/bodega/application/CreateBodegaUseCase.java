package com.electrishop.bodega.application;

import com.electrishop.bodega.domain.entity.Bodega;
import com.electrishop.bodega.domain.service.BodegaService;

public class CreateBodegaUseCase {
    private BodegaService bodegaService;

    public CreateBodegaUseCase(BodegaService bodegaService) {
        this.bodegaService = bodegaService;
    }

    public void execute(Bodega bodega) {
        bodegaService.createBodega(bodega);
    }
}
