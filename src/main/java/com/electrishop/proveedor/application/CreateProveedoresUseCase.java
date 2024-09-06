package com.electrishop.proveedor.application;

import com.electrishop.proveedor.domain.entity.Proveedores;
import com.electrishop.proveedor.domain.service.ProveedoresService;

public class CreateProveedoresUseCase {
    private final ProveedoresService proveedoresService;

    public CreateProveedoresUseCase(ProveedoresService proveedoresService) {
        this.proveedoresService = proveedoresService;
    }

    public void execute(Proveedores proveedores) {
        proveedoresService.CreateProvedores(proveedores);
    }
}
