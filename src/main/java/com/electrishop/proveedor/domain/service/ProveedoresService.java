package com.electrishop.proveedor.domain.service;

import com.electrishop.proveedor.domain.entity.Proveedores;

public interface ProveedoresService {
    Proveedores FindProveedoresById(int id_proveedor);
    void CreateProveedores(Proveedores proveedores);
    void UpdateProveedores(Proveedores proveedores);
    void DeleteProveedores(int id_proveedor);
}
