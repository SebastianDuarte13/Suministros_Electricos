package com.electrishop.sucursal.domain.service;

import com.electrishop.sucursal.domain.entity.Sucursal;

public interface SucursalService {
    void addSucursal(Sucursal sucursal);
    Sucursal findSucursalById(int id_sucursal);
    void updateSucursal(Sucursal sucursal);
    void deleteSucursal(int id_sucursal);
}
