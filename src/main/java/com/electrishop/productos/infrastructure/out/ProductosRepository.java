package com.electrishop.productos.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.electrishop.infrastructure.config.DatabaseConfig;
import com.electrishop.productos.domain.entity.Productos;
import com.electrishop.productos.domain.service.ProductosService;

public class ProductosRepository implements ProductosService{

    @Override
    public Productos FindProductosById(int id_producto) {
        String sql = "SELECT id_producto, nombre_producto, descripcion_producto, precio_producto, id_categoria FROM productos WHERE id_producto = ?";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_producto);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Productos productos = new Productos(
                        resultSet.getString("nombre_producto"),
                        resultSet.getString("descripcion_producto"),
                        resultSet.getBigDecimal("precio_producto"),
                        resultSet.getInt("id_categoria"));
                productos.setId_producto(resultSet.getInt("id_producto"));
                return productos;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void CreateProductos(Productos productos) {
        String sql = "INSERT INTO productos (nombre_producto, descripcion_producto, precio_producto, id_categoria) VALUES (?,?,?,?)";
        try (Connection connection = DatabaseConfig.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, productos.getNombre_producto());
            statement.setString(2, productos.getDescripcion_producto());
            statement.setBigDecimal(3, productos.getPrecio_producto());
            statement.setInt(4, productos.getId_categoria());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void UpdateProductos(Productos productos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'UpdateProductos'");
    }

    @Override
    public void DeleteProductos(int id_producto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'DeleteProductos'");
    }

}
