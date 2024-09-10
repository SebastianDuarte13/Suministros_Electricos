package com.electrishop.reportes.domain.service;

import java.util.List;
import com.electrishop.reportes.domain.entity.Reportes;

public interface ReportesService {
    List<Reportes> getAllVentas();
    List<Reportes> getAllClientes();
    List<Reportes> getAllProductos();
}
