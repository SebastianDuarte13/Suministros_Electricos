package com.electrishop.pais.application;

import com.electrishop.pais.domain.entity.Pais;
import com.electrishop.pais.domain.service.PaisService;

public class CreatePaisUseCase {
    private final PaisService paisService;

    public CreatePaisUseCase(PaisService paisService) {
        this.paisService = paisService;
    }

    public void execute(Pais pais) {
        paisService.CreatePais(pais);
    }
}
