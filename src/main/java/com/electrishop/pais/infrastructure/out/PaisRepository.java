package com.electrishop.pais.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.electrishop.infrastructure.config.DatabaseConfig;
import com.electrishop.pais.domain.entity.Pais;
import com.electrishop.pais.domain.service.PaisService;

public class PaisRepository implements PaisService{

    @Override
    public void CreatePais(Pais pais) {
         String sql = "INSERT INTO pais (nombre) VALUES (?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, pais.getNombre());
            statement.executeUpdate(); // Ejecuta la consulta
        } catch (SQLException e) {
            e.printStackTrace();
            // Maneja la excepción de manera adecuada aquí.
        }
    }

}
