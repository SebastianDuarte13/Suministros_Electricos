package com.electrishop.bodega.domain.service;

import com.electrishop.bodega.domain.entity.Bodega;

public interface BodegaService {
    // creamos el servicio de lo que vamos a hacer en este caso solo agregar

    Bodega findBodegaById(int id_bodega);

    void createBodega(Bodega bodega);

    void updateBodega(Bodega bodega);

    void deleteBodega(int id_bodega);
}
