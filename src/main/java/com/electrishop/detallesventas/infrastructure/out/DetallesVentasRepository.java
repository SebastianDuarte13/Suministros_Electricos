package com.electrishop.detallesventas.infrastructure.out;

import com.electrishop.detallesventas.domain.entity.DetallesVentas;
import com.electrishop.detallesventas.domain.service.DetallesVentasService;
import com.electrishop.infrastructure.config.DatabaseConfig;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DetallesVentasRepository implements DetallesVentasService {

 

    @Override
    public void addDetallesVentas(DetallesVentas detallesVentas) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String sql = "INSERT INTO detalles_ventas (id_venta, id_producto, cantidad_productos, subprecio, descuento, total) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, detallesVentas.getId_venta());
            stmt.setInt(2, detallesVentas.getId_producto());
            stmt.setInt(3, detallesVentas.getCantidad_productos());
            stmt.setDouble(4, detallesVentas.getSubprecio());
            stmt.setInt(5, detallesVentas.getDescuento());
            stmt.setDouble(6, detallesVentas.getTotal());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public DetallesVentas findDetallesVentasById(int id_detalle_venta) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String sql = "SELECT * FROM detalles_ventas WHERE id_detalle_venta = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id_detalle_venta);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new DetallesVentas(
                        rs.getInt("id_venta"),
                        rs.getInt("id_producto"),
                        rs.getInt("cantidad_productos"),
                        rs.getDouble("subprecio"),
                        rs.getInt("descuento"),
                        rs.getDouble("total"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateDetallesVentas(DetallesVentas detallesVentas) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String sql = "UPDATE detalles_ventas SET id_venta = ?, id_producto = ?, cantidad_productos = ?, subprecio = ?, descuento = ?, total = ? WHERE id_detalle_venta = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, detallesVentas.getId_venta());
            stmt.setInt(2, detallesVentas.getId_producto());
            stmt.setInt(3, detallesVentas.getCantidad_productos());
            stmt.setDouble(4, detallesVentas.getSubprecio());
            stmt.setInt(5, detallesVentas.getDescuento());
            stmt.setDouble(6, detallesVentas.getTotal());
            stmt.setInt(7, detallesVentas.getId_detalle_venta()); // Asegúrate de que este ID es correcto
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("No se actualizó ningún registro. Verifica el ID.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDetallesVentas(int id_detalle_venta) {
        try (Connection connection = DatabaseConfig.getConnection()) {
            String sql = "DELETE FROM detalles_ventas WHERE id_detalle_venta = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id_detalle_venta);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
