package com.electrishop.pedidospendientes.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.electrishop.infrastructure.config.DatabaseConfig;
import com.electrishop.pedidospendientes.domain.entity.PedidosPendientes;
import com.electrishop.pedidospendientes.domain.service.PedidosPendientesService;

public class PedidosPendientesRepository implements PedidosPendientesService {

    @Override
    public List<PedidosPendientes> findAllPedidosPendientes() {
        List<PedidosPendientes> pedidosPendientesList = new ArrayList<>();
        String sql = "SELECT pe.id_pedido, c.nombre_cliente, c.apellido_cliente, pe.estado_pedido, pe.fecha_pedido " +
                     "FROM clientes AS c " +
                     "JOIN pedidos AS pe ON c.id_cliente = pe.id_cliente " +
                     "WHERE pe.estado_pedido = 'Pendiente'";
        
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                PedidosPendientes pedidosPendientes = new PedidosPendientes(
                    resultSet.getInt("id_pedido"),
                    resultSet.getString("nombre_cliente"),
                    resultSet.getString("apellido_cliente"),
                    resultSet.getString("estado_pedido"),
                    resultSet.getDate("fecha_pedido")
                );
                pedidosPendientesList.add(pedidosPendientes);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidosPendientesList;
    }
}
