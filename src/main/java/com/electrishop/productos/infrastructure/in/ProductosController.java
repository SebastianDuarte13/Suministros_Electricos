   package com.electrishop.productos.infrastructure.in;

import java.math.BigDecimal;

import javax.swing.JOptionPane;

import com.electrishop.productos.application.CreateProductosUseCase;
import com.electrishop.productos.domain.entity.Productos;
import com.electrishop.productos.domain.service.ProductosService;

public class ProductosController {
    private CreateProductosUseCase createProductosUseCase;
    private ProductosService productosService;

    public ProductosController(CreateProductosUseCase createProductosUseCase, ProductosService productosService) {
        this.createProductosUseCase = createProductosUseCase;
        this.productosService = productosService;
    }

    public void tabla_Productos() {
        while (true) {
            String[] options = { "Añadir Productos", "Editar Productos", "Mostrar Productos", "Eliminar Productos",
                    "Salir al menú anterior" };
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Productos",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addProductos();
                    break;
                case 1:
                    editaProductos();
                    break;
                case 2:
                    searchProductos();
                    break;
                case 3:
                    deleteProductos();
                    break;
                case 4:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private void addProductos() {
        String nombre_Productos = JOptionPane.showInputDialog("Ingrese el nombre del Productos:");
        String descripcion_Productos = JOptionPane.showInputDialog("Ingrese la descripcion del Productos:");
        int precio_Productos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio del producto :"));
        int id_categoria = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la categoria :"));

        if (nombre_Productos != null && !descripcion_Productos.trim().isEmpty() && precio_Productos != 0) {
            Productos productos = new Productos(nombre_Productos, descripcion_Productos,
                    new BigDecimal(precio_Productos), id_categoria);
            createProductosUseCase.execute(productos);
            JOptionPane.showMessageDialog(null, "Producto añadido exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Datos del Producto no válidos.");
        }
    }

    private void editaProductos() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID del producto que desea editar:");
        if (idString != null && !idString.trim().isEmpty()) {
            int id_producto = Integer.parseInt(idString);
            Productos productos = productosService.FindProductosById(id_producto);
    
            if (productos != null) {
                String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del producto:", productos.getNombre_producto());
                String nuevaDescripcion = JOptionPane.showInputDialog("Ingrese la nueva descripción del producto:", productos.getDescripcion_producto());
                int nuevoPrecio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo precio del producto:", productos.getPrecio_producto()));
                int nuevaIdCategoria = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la categoría del producto:", productos.getId_categoria()));
    
                if (nuevoNombre != null && !nuevoNombre.trim().isEmpty() &&
                    nuevaDescripcion != null && !nuevaDescripcion.trim().isEmpty() &&
                    nuevoPrecio > 0 && nuevaIdCategoria > 0) {
    
                    productos.setNombre_producto(nuevoNombre);
                    productos.setDescripcion_producto(nuevaDescripcion);
                    productos.setPrecio_producto(new BigDecimal(nuevoPrecio));
                    productos.setId_categoria(nuevaIdCategoria);
    
                    productosService.UpdateProductos(productos);
                    JOptionPane.showMessageDialog(null, "Producto editado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Datos del producto no válidos.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado.");
            }
        }
    }
    

    private void searchProductos() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID del producto que desea buscar:");
        if (idString != null && !idString.trim().isEmpty()) {
            int id_productos = Integer.parseInt(idString);
            Productos productos = productosService.FindProductosById(id_productos);

            if (productos != null) {
                String message = String.format("ID: %d\n Descripcion: %s\nNombre: %s\nPrecio: %s\nId_categoria: %s",
                        productos.getId_producto(), productos.getId_categoria(), productos.getNombre_producto(),
                        productos.getPrecio_producto(), productos.getId_categoria());
                JOptionPane.showMessageDialog(null, message);
            } else {
                JOptionPane.showMessageDialog(null, "cliente no encontrado.");
            }
        }
    }

    private void deleteProductos() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID del productos que desea eliminar:");
        if (idString != null && !idString.trim().isEmpty()) {
            int id_productos = Integer.parseInt(idString);
            Productos productos = productosService.FindProductosById(id_productos);

            if (productos != null) {
                productosService.DeleteProductos(id_productos);
                JOptionPane.showMessageDialog(null, "productos eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "productos no encontrado.");
            }
        }
    }
}
