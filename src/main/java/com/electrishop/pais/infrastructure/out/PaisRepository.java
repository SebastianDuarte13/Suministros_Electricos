package com.electrishop.pais.infrastructure.out;

// impostaciones de las librerias de java que vamos a utilizar
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//importaciones de las variables que vamos a necesitar
import com.electrishop.infrastructure.config.DatabaseConfig;
import com.electrishop.pais.domain.entity.Pais;
import com.electrishop.pais.domain.service.PaisService;

public class PaisRepository implements PaisService{

    //Este método inserta una nueva categoría en la base de datos usando una consulta SQL preparada, tomando el nombre del pais 
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
