package com.electrishop.sucursal.application;

import com.electrishop.sucursal.domain.entity.Sucursal;
import com.electrishop.sucursal.domain.service.SucursalService;

public class CreateSucursalUseCase {
    private SucursalService sucursalService;

    public CreateSucursalUseCase(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

    public void execute(Sucursal sucursal) {
        sucursalService.addSucursal(sucursal);
    }
}
