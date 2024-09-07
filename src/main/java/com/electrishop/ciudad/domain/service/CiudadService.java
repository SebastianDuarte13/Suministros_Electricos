package com.electrishop.ciudad.domain.service;

import com.electrishop.ciudad.domain.entity.Ciudad;

public interface CiudadService {
    // creamos los servicios que vamos a utilizar
    Ciudad FindCiudadById(int id_ciudad);
    void CreateCiudad(Ciudad ciudad);
    void UpdateCiudad(Ciudad ciudad);
    void DeleteCiudad(int id_ciudad);
}
