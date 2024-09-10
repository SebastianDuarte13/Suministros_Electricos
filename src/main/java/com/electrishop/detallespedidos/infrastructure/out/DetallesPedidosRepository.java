package com.electrishop.detallespedidos.infrastructure.out;

import com.electrishop.detallespedidos.domain.entity.DetallesPedidos;
import com.electrishop.detallespedidos.domain.service.DetallesPedidosService;
import com.electrishop.infrastructure.config.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DetallesPedidosRepository implements DetallesPedidosService {


    @Override
    public void addDetallesPedidos(DetallesPedidos detallesPedidos) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String sql = "INSERT INTO detalles_pedidos (id_pedido, id_producto, cantidad_detalle_pedido, descuento, precio_detalle_pedido) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, detallesPedidos.getId_pedido());
            stmt.setInt(2, detallesPedidos.getId_producto());
            stmt.setInt(3, detallesPedidos.getCantidad_detalle_pedido());
            stmt.setInt(4, detallesPedidos.getDescuento());
            stmt.setDouble(5, detallesPedidos.getPrecio_detalle_pedido());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public DetallesPedidos findDetallesPedidosById(int id_detalle_pedido) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String sql = "SELECT id_pedido, id_producto, cantidad_detalle_pedido, descuento, precio_detalle_pedido  FROM detalles_pedidos WHERE id_detalle_pedido = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id_detalle_pedido);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new DetallesPedidos(
                        rs.getInt("id_pedido"),
                        rs.getInt("id_producto"),
                        rs.getInt("cantidad_detalle_pedido"),
                        rs.getInt("descuento"),
                        rs.getDouble("precio_detalle_pedido")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateDetallesPedidos(DetallesPedidos detallesPedidos) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String sql = "UPDATE detalles_pedidos SET id_pedido = ?, id_producto = ?, cantidad_detalle_pedido = ?, descuento = ?, precio_detalle_pedido = ? WHERE id_detalle_pedido = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, detallesPedidos.getId_pedido());
            stmt.setInt(2, detallesPedidos.getId_producto());
            stmt.setInt(3, detallesPedidos.getCantidad_detalle_pedido());
            stmt.setInt(4, detallesPedidos.getDescuento());
            stmt.setDouble(5, detallesPedidos.getPrecio_detalle_pedido());
            stmt.setInt(6, detallesPedidos.getId_detalle_pedido());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDetallesPedidos(int id_detalle_pedido) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String sql = "DELETE FROM detalles_pedidos WHERE id_detalle_pedido = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id_detalle_pedido);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
