package com.electrishop.proveedor.domain.service;

import com.electrishop.proveedor.domain.entity.Proveedores;

public interface ProveedoresService {
    // creamos el servicio de lo que vamos a hacer en este caso solo agregar

    Proveedores FindProveedoresById(int id_proveedor);

    void CreateProveedores(Proveedores proveedores);

    void UpdateProveedores(Proveedores proveedores);

    void DeleteProveedores(int id_proveedor);
}
