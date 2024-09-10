package com.electrishop.productoproveedor.infrastructure.in;

import javax.swing.JOptionPane;
import com.electrishop.productoproveedor.application.CreateProductoProveedorUseCase;
import com.electrishop.productoproveedor.domain.entity.ProductoProveedor;
import com.electrishop.productoproveedor.domain.service.ProductoProveedorService;

public class ProductoProveedorController {
    private CreateProductoProveedorUseCase createProductoProveedorUseCase;
    private ProductoProveedorService productoProveedorService;

    public ProductoProveedorController(CreateProductoProveedorUseCase createProductoProveedorUseCase, ProductoProveedorService productoProveedorService) {
        this.createProductoProveedorUseCase = createProductoProveedorUseCase;
        this.productoProveedorService = productoProveedorService;
    }

    public void tabla_ProductoProveedor() {
        while (true) {
            String[] options = { "Añadir Producto-Proveedor", "Eliminar Producto-Proveedor", "Buscar Producto-Proveedor", "Salir al menú anterior" };
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Productos-Proveedores", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addProductoProveedor();
                    break;
                case 1:
                    deleteProductoProveedor();
                    break;
                case 2:
                    searchProductoProveedor();
                    break;
                case 3:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private void addProductoProveedor() {
        int id_producto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto:"));
        int id_proveedor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del proveedor:"));

        ProductoProveedor productoProveedor = new ProductoProveedor(id_producto, id_proveedor);
        createProductoProveedorUseCase.execute(productoProveedor);
        JOptionPane.showMessageDialog(null, "Producto-Proveedor añadido exitosamente.");
    }

    private void deleteProductoProveedor() {
        int id_producto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto:"));
        int id_proveedor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del proveedor:"));

        productoProveedorService.deleteProductoProveedor(id_producto, id_proveedor);
        JOptionPane.showMessageDialog(null, "Producto-Proveedor eliminado exitosamente.");
    }

    private void searchProductoProveedor() {
        int id_producto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto:"));
        int id_proveedor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del proveedor:"));

        ProductoProveedor productoProveedor = productoProveedorService.findProductoProveedor(id_producto, id_proveedor);

        if (productoProveedor != null) {
            String mensaje = String.format("ID Producto: %d\nID Proveedor: %d", productoProveedor.getId_producto(), productoProveedor.getId_proveedor());
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            JOptionPane.showMessageDialog(null, "Producto-Proveedor no encontrado.");
        }
    }
}
