package com.electrishop.productoproveedor.infrastructure.out;

import com.electrishop.productoproveedor.domain.entity.ProductoProveedor;
import com.electrishop.productoproveedor.domain.service.ProductoProveedorService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductoProveedorRepository implements ProductoProveedorService {

    private Connection getConnection() throws Exception {
        return com.electrishop.infrastructure.config.DatabaseConfig.getConnection();
    }

    @Override
    public void addProductoProveedor(ProductoProveedor productoProveedor) {
        try (Connection connection = getConnection()) {
            String sql = "INSERT INTO productoproveedor (id_producto, id_proveedor) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, productoProveedor.getId_producto());
            stmt.setInt(2, productoProveedor.getId_proveedor());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ProductoProveedor findProductoProveedor(int id_producto, int id_proveedor) {
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM productoproveedor WHERE id_producto = ? AND id_proveedor = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id_producto);
            stmt.setInt(2, id_proveedor);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new ProductoProveedor(
                        rs.getInt("id_producto"),
                        rs.getInt("id_proveedor")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteProductoProveedor(int id_producto, int id_proveedor) {
        try (Connection connection = getConnection()) {
            String sql = "DELETE FROM productoproveedor WHERE id_producto = ? AND id_proveedor = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id_producto);
            stmt.setInt(2, id_proveedor);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
