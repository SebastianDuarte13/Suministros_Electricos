package com.electrishop.bodega.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.electrishop.bodega.domain.entity.Bodega;
import com.electrishop.bodega.domain.service.BodegaService;
import com.electrishop.infrastructure.config.DatabaseConfig;

public class BodegaRepository implements BodegaService {

    @Override
    public Bodega findBodegaById(int id_bodega) {
        String sql = "SELECT id_bodega, id_inventario FROM bodega WHERE id_bodega = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_bodega);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int idInventario = resultSet.getInt("id_inventario");
                int idBodega = resultSet.getInt("id_bodega");
                
                // Asegúrate de asignar el ID correctamente
                Bodega bodega = new Bodega(idInventario);
                bodega.setId_bodega(idBodega);
                
                return bodega;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void createBodega(Bodega bodega) {
        String sql = "INSERT INTO bodega (id_inventario) VALUES (?)";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, bodega.getId_inventario());
            statement.executeUpdate();

            // Obtener el id_bodega generado
            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next()) {
                int idBodegaGenerado = keys.getInt(1);
                bodega.setId_bodega(idBodegaGenerado);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBodega(Bodega bodega) {
        String sql = "UPDATE bodega SET id_inventario = ? WHERE id_bodega = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, bodega.getId_inventario());
            statement.setInt(2, bodega.getId_bodega());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBodega(int id_bodega) {
        String sql = "DELETE FROM bodega WHERE id_bodega = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_bodega);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
