package com.electrishop.clientes.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.electrishop.clientes.domain.entity.Clientes;
import com.electrishop.clientes.domain.service.ClientesService;
import com.electrishop.infrastructure.config.DatabaseConfig;


public class ClientesRepository implements ClientesService{

    @Override
    public Clientes FindClientesById(int id_cliente) {
        String sql = "SELECT id_cliente, nombre_cliente, apellido_cliente, email_cliente, telefono_cliente, id_direccioncliente FROM clientes WHERE id_cliente = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_cliente);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Clientes clientes = new Clientes(
                    resultSet.getString("nombre_cliente"),
                    resultSet.getString("apellido_cliente"),
                    resultSet.getString("email_cliente"),
                    resultSet.getString("telefono_cliente"),
                    resultSet.getInt("id_direccioncliente"));
                    clientes.setId_cliente(resultSet.getInt("id_cliente"));
                    return clientes;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void CreateClientes(Clientes clientes) {
        String sql = "INSERT INTO clientes (nombre_cliente, apellido_cliente, email_cliente, telefono_cliente, id_direccioncliente) VALUES (?,?,?,?,?)";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, clientes.getNombre_cliente());
            statement.setString(2, clientes.getApellido_cliente());
            statement.setString(3, clientes.getEmail_cliente());
            statement.setString(4, clientes.getTelefono_cliente());
            statement.setInt(5, clientes.getId_direccioncliente());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void UpdateClientes(Clientes clientes) {
        String sql = "UPDATE clientes SET nombre_cliente = ?, apellido_cliente = ?, email_cliente = ?, telefono_cliente = ?, id_direccioncliente = ? WHERE id_cliente = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, clientes.getNombre_cliente());
            statement.setString(2, clientes.getApellido_cliente());
            statement.setString(3, clientes.getEmail_cliente());
            statement.setString(4, clientes.getTelefono_cliente());
            statement.setInt(5, clientes.getId_direccioncliente());
            statement.setInt(6, clientes.getId_cliente());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
public void DeliteCliente(int id_cliente) {
    String sql = "DELETE FROM clientes WHERE id_cliente = ?";
    try (Connection connection = DatabaseConfig.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, id_cliente);
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


}
