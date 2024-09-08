package com.electrishop.pedido.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.electrishop.pedido.domain.entity.Pedido;
import com.electrishop.pedido.domain.service.PedidoService;
import com.electrishop.infrastructure.config.DatabaseConfig;

public class PedidoRepository implements PedidoService {

    // Buscar pedido por ID
    @Override
    public Pedido FindPedidoById(int id_pedido) {
        String sql = "SELECT id_pedido, id_cliente, fecha_pedido, estado_pedido FROM pedidos WHERE id_pedido = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_pedido);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Crear objeto Pedido a partir de los datos de la base
                Pedido pedido = new Pedido(
                        resultSet.getInt("id_cliente"),
                        resultSet.getTimestamp("fecha_pedido"),
                        resultSet.getString("estado_pedido"));
                pedido.setId_pedido(resultSet.getInt("id_pedido"));
                return pedido;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Crear un nuevo pedido
    @Override
    public void CreatePedido(Pedido pedido) {
        String sql = "INSERT INTO pedidos (id_cliente, fecha_pedido, estado_pedido) VALUES (?,?,?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, pedido.getId_cliente());
            statement.setTimestamp(2, pedido.getFecha_pedido());
            statement.setString(3, pedido.getEstado_pedido());
            statement.executeUpdate(); // Ejecutar la consulta
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Actualizar un pedido existente
    @Override
    public void UpdatePedido(Pedido pedido) {
        String sql = "UPDATE pedidos SET id_cliente = ?, fecha_pedido = ?, estado_pedido = ? WHERE id_pedido = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, pedido.getId_cliente());
            statement.setTimestamp(2, pedido.getFecha_pedido());
            statement.setString(3, pedido.getEstado_pedido());
            statement.setInt(4, pedido.getId_pedido());
            statement.executeUpdate(); // Ejecutar la consulta
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar un pedido por ID
    @Override
    public void DeletePedido(int id_pedido) {
        String sql = "DELETE FROM pedidos WHERE id_pedido = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_pedido);
            statement.executeUpdate(); // Ejecutar la consulta
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
