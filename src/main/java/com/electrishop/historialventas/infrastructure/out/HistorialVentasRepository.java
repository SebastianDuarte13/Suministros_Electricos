package com.electrishop.historialventas.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.electrishop.historialventas.domain.entity.HistorialVentas;
import com.electrishop.historialventas.domain.service.HistorialVentasService;
import com.electrishop.infrastructure.config.DatabaseConfig;

public class HistorialVentasRepository implements HistorialVentasService {

    @Override
    public List<HistorialVentas> FindAllHistorial() {
        String sql = "SELECT v.id_venta, v.fecha_venta, c.nombre_cliente, c.apellido_cliente FROM ventas AS v JOIN clientes AS c ON c.id_cliente = v.id_cliente;";
        List<HistorialVentas> historialVentasList = new ArrayList<>();

        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                HistorialVentas historialVentas = new HistorialVentas(
                    resultSet.getInt("id_venta"),
                    resultSet.getDate("fecha_venta"),
                    resultSet.getString("nombre_cliente"),
                    resultSet.getString("apellido_cliente")
                );
                historialVentasList.add(historialVentas);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return historialVentasList;
    }
}
