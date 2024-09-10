package com.electrishop.proveedor.application;

import com.electrishop.proveedor.domain.entity.Proveedores;
import com.electrishop.proveedor.domain.service.ProveedoresService;

public class CreateProveedoresUseCase {
    private final ProveedoresService proveedoresService;

             // Constructor que recibe el servicio de proveedor service
    public CreateProveedoresUseCase(ProveedoresService proveedoresService) {
        this.proveedoresService = proveedoresService;
    }

            // Ejecuta la creación de un nuevo proveedor service
    public void execute(Proveedores proveedores) {
        proveedoresService.CreateProveedores(proveedores);
    }
}
