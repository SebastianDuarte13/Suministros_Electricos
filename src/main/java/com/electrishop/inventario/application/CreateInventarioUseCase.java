package com.electrishop.inventario.application;

import com.electrishop.inventario.domain.entity.Inventario;
import com.electrishop.inventario.domain.service.InventarioService;

public class CreateInventarioUseCase {
    private final InventarioService inventarioService;

         // Constructor que recibe el servicio de detalles pedido
    public CreateInventarioUseCase(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }
    
        // Ejecuta la creación de un nuev detalles pedido
    public void execute(Inventario inventario) {
        inventarioService.createInventario(inventario);
    }
}
