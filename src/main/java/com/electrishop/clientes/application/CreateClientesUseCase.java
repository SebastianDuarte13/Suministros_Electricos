package com.electrishop.clientes.application;

import com.electrishop.clientes.domain.entity.Clientes;
import com.electrishop.clientes.domain.service.ClientesService;

public class CreateClientesUseCase {
    private final ClientesService clientesService;

    public CreateClientesUseCase(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    public void execute(Clientes clientes) {
        clientesService.CreateClientes(clientes);
    }
}
