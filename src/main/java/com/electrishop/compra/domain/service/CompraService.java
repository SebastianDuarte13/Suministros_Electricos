package com.electrishop.compra.domain.service;

import com.electrishop.compra.domain.entity.Compra;

public interface CompraService {
    Compra FindCompraById(int id_compra);
    void CreateCompra(Compra compra);
    void UpdateCompra(Compra compra);
    void DeleteCompra(int id_compra);
}
