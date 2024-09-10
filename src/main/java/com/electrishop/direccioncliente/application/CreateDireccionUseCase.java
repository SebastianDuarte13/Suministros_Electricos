package com.electrishop.direccioncliente.application;

import com.electrishop.direccioncliente.domain.entity.Direccion;
import com.electrishop.direccioncliente.domain.service.DireccionService;

public class CreateDireccionUseCase {
    private final DireccionService direccionService;

         // Constructor que recibe el servicio de direccion
    public CreateDireccionUseCase(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

        // Ejecuta la creación de una nueva direccion
    public void execute(Direccion direccion) {
        direccionService.CreateDireccion(direccion);
    }
}
