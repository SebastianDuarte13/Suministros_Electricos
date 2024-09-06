package com.electrishop.proveedor.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.electrishop.infrastructure.config.DatabaseConfig;
import com.electrishop.proveedor.domain.entity.Proveedores;
import com.electrishop.proveedor.domain.service.ProveedoresService;

public class ProveedoresRepository implements ProveedoresService{

    @Override
    public Proveedores FindProveedoresById(int id_proveedor) {
        String sql = "SELECT id_proveedor, nombre_proveedor, apellido_proveedor, email_proveedor, telefono_proveedor, direccion_proveedor FROM proveedores WHERE id_proveedor = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id_proveedor);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int returnid = resultSet.getInt("id_proveedor");
                String nombre_proveedor = resultSet.getString("nombre_proveedor");
                String apellido_proveedor = resultSet.getString("apellido_proveedor");
                String email_proveedor = resultSet.getString("email_proveedor");
                String telefono_proveedor = resultSet.getString("telefono_proveedor");
                String direccion_proveedor = resultSet.getString("direccion_proveedor");

                Proveedores proveedores = new Proveedores(nombre_proveedor, apellido_proveedor, email_proveedor, telefono_proveedor, direccion_proveedor);
                proveedores.setId_proveedor(id_proveedor);
                return proveedores;
            }

            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void CreateProvedores(Proveedores proveedores) {
        String sql = "INSERT INTO proveedores (nombre_proveedor, apellido_proveedor, email_proveedor, telefono_proveedor, direccion_proveedor) VALUES (?,?,?,?,?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, proveedores.getNombre_proveedor());
            statement.setString(2, proveedores.getApellido_proveedor());
            statement.setString(3, proveedores.getEmail_proveedor());
            statement.setString(4, proveedores.getTelefono_proveedor());
            statement.setString(5, proveedores.getDireccion_proveedor());
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void UpdateProveedores(Proveedores proveedores) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'UpdateProveedores'");
    }

    @Override
    public void DeleteProveedores(int id_proveedor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'DeleteProveedores'");
    }

}
