package com.electrishop.proveedor.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.electrishop.infrastructure.config.DatabaseConfig;
import com.electrishop.proveedor.domain.entity.Proveedores;
import com.electrishop.proveedor.domain.service.ProveedoresService;

public class ProveedoresRepository implements ProveedoresService {

    @Override
    public Proveedores FindProveedoresById(int id_proveedor) {
        String sql = "SELECT id_proveedor, nombre_proveedor, apellido_proveedor, email_proveedor, telefono_proveedor, direccion_proveedor FROM proveedores WHERE id_proveedor = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_proveedor);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Proveedores proveedores = new Proveedores(
                        resultSet.getString("nombre_proveedor"),
                        resultSet.getString("apellido_proveedor"),
                        resultSet.getString("email_proveedor"),
                        resultSet.getString("telefono_proveedor"),
                        resultSet.getString("direccion_proveedor"));
                proveedores.setId_proveedor(resultSet.getInt("id_proveedor"));
                return proveedores;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void CreateProveedores(Proveedores proveedores) {
        String sql = "INSERT INTO proveedores (nombre_proveedor, apellido_proveedor, email_proveedor, telefono_proveedor, direccion_proveedor) VALUES (?,?,?,?,?)";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, proveedores.getNombre_proveedor());
            statement.setString(2, proveedores.getApellido_proveedor());
            statement.setString(3, proveedores.getEmail_proveedor());
            statement.setString(4, proveedores.getTelefono_proveedor());
            statement.setString(5, proveedores.getDireccion_proveedor());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void UpdateProveedores(Proveedores proveedores) {
        String sql = "UPDATE proveedores SET nombre_proveedor = ?, apellido_proveedor = ?, email_proveedor = ?, telefono_proveedor = ?, direccion_proveedor = ? WHERE id_proveedor = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, proveedores.getNombre_proveedor());
            statement.setString(2, proveedores.getApellido_proveedor());
            statement.setString(3, proveedores.getEmail_proveedor());
            statement.setString(4, proveedores.getTelefono_proveedor());
            statement.setString(5, proveedores.getDireccion_proveedor());
            statement.setInt(6, proveedores.getId_proveedor());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void DeleteProveedores(int id_proveedor) {
        String sql = "DELETE FROM proveedores WHERE id_proveedor = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_proveedor);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
