package com.electrishop.detallescompra.infrastructure.out;

import com.electrishop.detallescompra.domain.entity.DetallesCompra;
import com.electrishop.detallescompra.domain.service.DetallesCompraService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DetallesCompraRepository implements DetallesCompraService {

    private Connection getConnection() throws Exception {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/electrishop", "root", "sebastrin77");
    }

    @Override
    public void addDetallesCompra(DetallesCompra detallesCompra) {
        try (Connection connection = getConnection()) {
            String sql = "INSERT INTO detalles_compra (id_compra, id_producto, nombre_compra, detalles, cantidad, precio_unidad) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, detallesCompra.getId_compra());
            stmt.setInt(2, detallesCompra.getId_producto());
            stmt.setString(3, detallesCompra.getNombre_compra());
            stmt.setString(4, detallesCompra.getDetalles());
            stmt.setInt(5, detallesCompra.getCantidad());
            stmt.setInt(6, detallesCompra.getPrecio_unidad());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public DetallesCompra findDetallesCompraById(int id_detalles_compra) {
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM detalles_compra WHERE id_detalles_compra = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id_detalles_compra);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                DetallesCompra detallesCompra = new DetallesCompra(
                        rs.getInt("id_compra"),
                        rs.getInt("id_producto"),
                        rs.getString("nombre_compra"),
                        rs.getString("detalles"),
                        rs.getInt("cantidad"),
                        rs.getInt("precio_unidad")
                );
                detallesCompra.setId_detalles_compra(rs.getInt("id_detalles_compra"));
                return detallesCompra;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateDetallesCompra(DetallesCompra detallesCompra) {
        try (Connection connection = getConnection()) {
            String sql = "UPDATE detalles_compra SET id_compra = ?, id_producto = ?, nombre_compra = ?, detalles = ?, cantidad = ?, precio_unidad = ? WHERE id_detalles_compra = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, detallesCompra.getId_compra());
            stmt.setInt(2, detallesCompra.getId_producto());
            stmt.setString(3, detallesCompra.getNombre_compra());
            stmt.setString(4, detallesCompra.getDetalles());
            stmt.setInt(5, detallesCompra.getCantidad());
            stmt.setInt(6, detallesCompra.getPrecio_unidad());
            stmt.setInt(7, detallesCompra.getId_detalles_compra());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDetallesCompra(int id_detalles_compra) {
        try (Connection connection = getConnection()) {
            String sql = "DELETE FROM detalles_compra WHERE id_detalles_compra = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id_detalles_compra);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
