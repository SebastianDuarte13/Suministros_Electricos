package com.electrishop.compra.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.electrishop.compra.domain.entity.Compra;
import com.electrishop.compra.domain.service.CompraService;
import com.electrishop.infrastructure.config.DatabaseConfig;

public class CompraRepository implements CompraService {

    @Override
    public Compra FindCompraById(int id_compra) {
        String sql = "SELECT id_compra, id_proveedor, fecha_compra, precio_compra FROM compra WHERE id_compra = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_compra);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Compra compra = new Compra(
                        resultSet.getInt("id_proveedor"),
                        resultSet.getDate("fecha_compra"),
                        resultSet.getInt("precio_compra"));
                compra.setId_compra(resultSet.getInt("id_compra"));
                return compra;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void CreateCompra(Compra compra) {
        String sql = "INSERT INTO compra (id_proveedor, fecha_compra, precio_compra) VALUES (?,?,?)";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, compra.getId_proveedor());
            statement.setDate(2, compra.getFecha_compra());
            statement.setInt(3, compra.getPrecio_compra());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void UpdateCompra(Compra compra) {
        String sql = "UPDATE compra SET id_proveedor = ?, fecha_compra = ?, precio_compra = ? WHERE id_compra = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, compra.getId_proveedor());
            statement.setDate(2, compra.getFecha_compra());
            statement.setInt(3, compra.getPrecio_compra());
            statement.setInt(4, compra.getId_compra());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void DeleteCompra(int id_compra) {
        String sql = "DELETE FROM compra WHERE id_compra = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_compra);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
