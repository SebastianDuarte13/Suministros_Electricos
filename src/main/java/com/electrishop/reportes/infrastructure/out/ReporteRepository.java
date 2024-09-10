package com.electrishop.reportes.infrastructure.out;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.electrishop.infrastructure.config.DatabaseConfig;
import com.electrishop.reportes.domain.entity.Reportes;
import com.electrishop.reportes.domain.service.ReportesService;

public class ReporteRepository implements ReportesService {

    @Override
    public List<Reportes> getAllVentas() {
        String sql = "SELECT id_venta, id_cliente, fecha_venta FROM ventas";
        List<Reportes> reportes = new ArrayList<>();
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id_cliente = resultSet.getInt("id_cliente");
                Date fecha_venta = resultSet.getDate("fecha_venta");
                reportes.add(new Reportes(id_cliente, null, null, null, null, 0, 
                                          resultSet.getInt("id_venta"), fecha_venta, 
                                          0, null, null, null, 0));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reportes;
    }

    @Override
    public List<Reportes> getAllClientes() {
        String sql = "SELECT id_cliente, nombre_cliente, apellido_cliente, email_cliente, telefono_cliente, id_direccioncliente FROM clientes";
        List<Reportes> reportes = new ArrayList<>();
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                reportes.add(new Reportes(resultSet.getInt("id_cliente"),
                                          resultSet.getString("nombre_cliente"),
                                          resultSet.getString("apellido_cliente"),
                                          resultSet.getString("email_cliente"),
                                          resultSet.getString("telefono_cliente"),
                                          resultSet.getInt("id_direccioncliente"),
                                          0, null, 0, null, null, null, 0));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reportes;
    }

    @Override
    public List<Reportes> getAllProductos() {
        String sql = "SELECT id_producto, nombre_producto, descripcion_producto, precio_producto, id_categoria FROM productos";
        List<Reportes> reportes = new ArrayList<>();
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                reportes.add(new Reportes(0, null, null, null, null, 0, 
                                          0, null, resultSet.getInt("id_producto"),
                                          resultSet.getString("nombre_producto"),
                                          resultSet.getString("descripcion_producto"),
                                          resultSet.getBigDecimal("precio_producto"),
                                          resultSet.getInt("id_categoria")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reportes;
    }
}
