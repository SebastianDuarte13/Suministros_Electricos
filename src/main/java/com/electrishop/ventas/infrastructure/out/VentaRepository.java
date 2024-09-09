package com.electrishop.ventas.infrastructure.out;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.electrishop.ventas.domain.entity.Venta;
import com.electrishop.ventas.domain.service.VentaService;
import com.electrishop.infrastructure.config.DatabaseConfig;

public class VentaRepository implements VentaService {

    @Override
    public Venta findVentaById(int id_venta) {
        String sql = "SELECT id_venta, id_cliente, fecha_venta FROM ventas WHERE id_venta = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_venta);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id_cliente = resultSet.getInt("id_cliente");
                Date fecha_venta = resultSet.getDate("fecha_venta");

                Venta venta = new Venta(id_cliente, fecha_venta);
                venta.setId_venta(resultSet.getInt("id_venta")); // Asegura que el ID se asigne correctamente
                return venta;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void createVenta(Venta venta) {
        String sql = "INSERT INTO ventas (id_cliente, fecha_venta) VALUES (?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql,
                        PreparedStatement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, venta.getId_cliente());
            statement.setDate(2, venta.getFecha_venta());
            statement.executeUpdate();

            // Obtener el ID generado y asignarlo al objeto venta
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                venta.setId_venta(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateVenta(Venta venta) {
        String sql = "UPDATE ventas SET id_cliente = ?, fecha_venta = ? WHERE id_venta = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, venta.getId_cliente());
            statement.setDate(2, venta.getFecha_venta());
            statement.setInt(3, venta.getId_venta());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteVenta(int id_venta) {
        String sql = "DELETE FROM ventas WHERE id_venta = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_venta);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
