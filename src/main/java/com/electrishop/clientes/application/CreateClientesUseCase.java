package com.electrishop.clientes.application;

import com.electrishop.clientes.domain.entity.Clientes;
import com.electrishop.clientes.domain.service.ClientesService;

public class CreateClientesUseCase {
    private final ClientesService clientesService;

         // Constructor que recibe el servicio de cliente
    public CreateClientesUseCase(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

        // Ejecuta la creación de un nuevo cliente
    public void execute(Clientes clientes) {
        clientesService.CreateClientes(clientes);
    }
}
