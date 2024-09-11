package com.electrishop.detallesventas.domain.service;

import com.electrishop.detallesventas.domain.entity.DetallesVentas;

public interface DetallesVentasService {
    // creamos el servicio de lo que vamos a hacer en este caso solo agregar

    void addDetallesVentas(DetallesVentas detallesVentas);

    DetallesVentas findDetallesVentasById(int id_detalle_venta);

    void updateDetallesVentas(DetallesVentas detallesVentas);

    void deleteDetallesVentas(int id_detalle_venta);
}
