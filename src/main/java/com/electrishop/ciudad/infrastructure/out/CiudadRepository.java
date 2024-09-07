package com.electrishop.ciudad.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.electrishop.ciudad.domain.entity.Ciudad;
import com.electrishop.ciudad.domain.service.CiudadService;
import com.electrishop.infrastructure.config.DatabaseConfig;

public class CiudadRepository implements CiudadService {

    // Busca una ciudad por su ID
    @Override
    public Ciudad FindCiudadById(int id_ciudad) {
        String sql = "SELECT id_ciudad, nombre, id_pais FROM ciudad WHERE id_ciudad = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_ciudad);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Ciudad(
                    resultSet.getInt("id_ciudad"),
                    resultSet.getString("nombre"),
                    resultSet.getInt("id_pais"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Crea una nueva ciudad
    @Override
    public void CreateCiudad(Ciudad ciudad) {
        String sql = "INSERT INTO ciudad (nombre, id_pais) VALUES (?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, ciudad.getNombre());
            statement.setInt(2, ciudad.getId_pais());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Actualiza los datos de una ciudad
    @Override
    public void UpdateCiudad(Ciudad ciudad) {
        String sql = "UPDATE ciudad SET nombre = ?, id_pais = ? WHERE id_ciudad = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, ciudad.getNombre());
            statement.setInt(2, ciudad.getId_pais());
            statement.setInt(3, ciudad.getId_ciudad());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Elimina una ciudad por su ID
    @Override
    public void DeleteCiudad(int id_ciudad) {
        String sql = "DELETE FROM productos WHERE id_producto = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_ciudad);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
