package com.electrishop.inventario.infrastructure.out;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.electrishop.inventario.domain.entity.Inventario;
import com.electrishop.inventario.domain.service.InventarioService;
import com.electrishop.infrastructure.config.DatabaseConfig;

public class InventarioRepository implements InventarioService {

    @Override
    public Inventario findInventarioById(int id_inventario) {
        String sql = "SELECT id_inventario, id_producto, cantidad_inventario, fecha_ingreso, fecha_actualizacion FROM inventario WHERE id_inventario = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_inventario);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id_producto = resultSet.getInt("id_producto");
                int cantidad_inventario = resultSet.getInt("cantidad_inventario");
                Date fecha_ingreso = resultSet.getDate("fecha_ingreso");
                Date fecha_actualizacion = resultSet.getDate("fecha_actualizacion");

                return new Inventario(id_producto, cantidad_inventario, fecha_ingreso, fecha_actualizacion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void createInventario(Inventario inventario) {
        String sql = "INSERT INTO inventario (id_producto, cantidad_inventario, fecha_ingreso, fecha_actualizacion) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, inventario.getId_producto());
            statement.setInt(2, inventario.getCantidad_inventario());
            statement.setDate(3, inventario.getFecha_ingreso());
            statement.setDate(4, inventario.getFecha_actualizacion());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateInventario(Inventario inventario) {
        String sql = "UPDATE inventario SET id_producto = ?, cantidad_inventario = ?, fecha_ingreso = ?, fecha_actualizacion = ? WHERE id_inventario = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, inventario.getId_producto());
            statement.setInt(2, inventario.getCantidad_inventario());
            statement.setDate(3, inventario.getFecha_ingreso());
            statement.setDate(4, inventario.getFecha_actualizacion());
            statement.setInt(5, inventario.getId_inventario());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteInventario(int id_inventario) {
        String sql = "DELETE FROM inventario WHERE id_inventario = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_inventario);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
