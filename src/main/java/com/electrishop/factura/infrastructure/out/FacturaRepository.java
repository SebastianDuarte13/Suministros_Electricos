package com.electrishop.factura.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.electrishop.factura.domain.entity.Factura;
import com.electrishop.factura.domain.service.FacturaService;
import com.electrishop.infrastructure.config.DatabaseConfig;

public class FacturaRepository implements FacturaService {

    @Override
    public Factura FindFacturaById(int id_detalle_venta) {
        String sql = "SELECT dv.id_detalle_venta, v.fecha_venta, c.nombre_cliente, c.apellido_cliente ,p.nombre_producto, p.descripcion_producto, dv.cantidad_productos, dv.subprecio, dv.descuento, dv.total " +
                     "FROM clientes AS c " +
                     "JOIN ventas AS v ON c.id_cliente = v.id_cliente " +
                     "JOIN detalles_ventas AS dv ON v.id_venta = dv.id_venta " +
                     "JOIN productos AS p ON dv.id_producto = p.id_producto " +
                     "WHERE dv.id_detalle_venta = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_detalle_venta);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Factura factura = new Factura(
                    resultSet.getInt("id_detalle_venta"),
                    resultSet.getDate("fecha_venta"),
                    resultSet.getString("nombre_cliente"),
                    resultSet.getString("apellido_cliente"),
                    resultSet.getString("nombre_producto"),
                    resultSet.getString("descripcion_producto"),
                    resultSet.getInt("cantidad_productos"),
                    resultSet.getDouble("subprecio"),
                    resultSet.getInt("descuento"),
                    resultSet.getDouble("total")
                );
                return factura;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
