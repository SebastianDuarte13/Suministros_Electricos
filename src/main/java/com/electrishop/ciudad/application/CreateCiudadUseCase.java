package com.electrishop.ciudad.application;

import com.electrishop.ciudad.domain.entity.Ciudad;
import com.electrishop.ciudad.domain.service.CiudadService;

/**
 * Caso de uso para la creación de una ciudad.
 * Esta clase sigue el patrón de caso de uso (Use Case) dentro de la arquitectura
 * para ejecutar la acción de creación de una nueva ciudad en el sistema.
 */
public class CreateCiudadUseCase {
    // Servicio de la ciudad que proporciona las operaciones necesarias para interactuar
    // con el repositorio de la ciudad.
    private final CiudadService ciudadService;

    public CreateCiudadUseCase(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    public void execute(Ciudad ciudad) {
        // Utiliza el servicio de ciudad para realizar la operación de creación
        ciudadService.CreateCiudad(ciudad);
    }
}
