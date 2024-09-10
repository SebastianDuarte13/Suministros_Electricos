package com.electrishop.sucursal.application;

import com.electrishop.sucursal.domain.entity.Sucursal;
import com.electrishop.sucursal.domain.service.SucursalService;

public class CreateSucursalUseCase {
    private SucursalService sucursalService;

             // Constructor que recibe el servicio de sucursal
    public CreateSucursalUseCase(SucursalService sucursalService) {
        this.sucursalService = sucursalService;
    }

            // Ejecuta la creación de una nueva sucursal
    public void execute(Sucursal sucursal) {
        sucursalService.addSucursal(sucursal);
    }
}
