package com.electrishop.reportes.domain.service;

import java.util.List;
import com.electrishop.reportes.domain.entity.Reportes;

public interface ReportesService {
    // creamos el servicio de lo que vamos a hacer en este caso solo agregar

    List<Reportes> getAllVentas();

    List<Reportes> getAllClientes();

    List<Reportes> getAllProductos();
}
