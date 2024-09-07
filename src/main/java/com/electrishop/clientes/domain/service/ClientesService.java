package com.electrishop.clientes.domain.service;

import com.electrishop.clientes.domain.entity.Clientes;

public interface ClientesService {
    Clientes FindClientesById(int id_cliente);
    void CreateClientes(Clientes clientes);
    void UpdateClientes(Clientes clientes);
    void DeliteCliente(int id_cliente);
}
