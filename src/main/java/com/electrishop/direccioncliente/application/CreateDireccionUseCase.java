package com.electrishop.direccioncliente.application;

import com.electrishop.direccioncliente.domain.entity.Direccion;
import com.electrishop.direccioncliente.domain.service.DireccionService;

public class CreateDireccionUseCase {
    private final DireccionService direccionService;

    public CreateDireccionUseCase(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    public void execute(Direccion direccion) {
        direccionService.CreateDireccion(direccion);
    }
}
