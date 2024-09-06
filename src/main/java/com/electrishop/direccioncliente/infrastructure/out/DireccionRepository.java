package com.electrishop.direccioncliente.infrastructure.out;

// impostaciones de las librerias de java que vamos a utilizar
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//importaciones de las variables que vamos a necesitar
import com.electrishop.direccioncliente.domain.entity.Direccion;
import com.electrishop.direccioncliente.domain.service.DireccionService;
import com.electrishop.infrastructure.config.DatabaseConfig;

public class DireccionRepository implements DireccionService {

    @Override
    public void CreateDireccion(Direccion direccion) {
        // Este método inserta una nueva direccion en la base de datos usando una
        // consulta SQL preparada, tomando el nombre de la direccion
        String sql = "INSERT INTO direccioncliente (direccion) VALUES (?)";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, direccion.getDireccion());
            statement.executeUpdate(); // Ejecuta la consulta
        } catch (SQLException e) {
            e.printStackTrace();
            // Maneja la excepción de manera adecuada aquí.
        }
    }

}
