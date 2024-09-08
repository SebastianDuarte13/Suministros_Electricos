package com.electrishop.inventario.application;

import com.electrishop.inventario.domain.entity.Inventario;
import com.electrishop.inventario.domain.service.InventarioService;

public class CreateInventarioUseCase {
    private final InventarioService inventarioService;

    public CreateInventarioUseCase(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    public void execute(Inventario inventario) {
        inventarioService.createInventario(inventario);
    }
}
