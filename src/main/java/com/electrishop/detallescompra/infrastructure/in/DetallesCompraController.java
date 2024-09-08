package com.electrishop.detallescompra.infrastructure.in;

import javax.swing.JOptionPane;

import com.electrishop.detallescompra.application.CreateDetallesCompraUseCase;
import com.electrishop.detallescompra.domain.entity.DetallesCompra;
import com.electrishop.detallescompra.domain.service.DetallesCompraService;

public class DetallesCompraController {
    private CreateDetallesCompraUseCase createDetallesCompraUseCase;
    private DetallesCompraService detallesCompraService;

    public DetallesCompraController(CreateDetallesCompraUseCase createDetallesCompraUseCase, DetallesCompraService detallesCompraService) {
        this.createDetallesCompraUseCase = createDetallesCompraUseCase;
        this.detallesCompraService = detallesCompraService;
    }

    public void tabla_DetallesCompra() {
        while (true) {
            String[] options = { "Añadir Detalles de Compra", "Editar Detalles de Compra", "Mostrar Detalles de Compra", "Eliminar Detalles de Compra", "Salir al menú anterior" };
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Detalles de Compra", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addDetallesCompra();
                    break;
                case 1:
                    editaDetallesCompra();
                    break;
                case 2:
                    searchDetallesCompra();
                    break;
                case 3:
                    deleteDetallesCompra();
                    break;
                case 4:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private void addDetallesCompra() {
        int id_compra = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la compra:"));
        int id_producto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto:"));
        String nombre_compra = JOptionPane.showInputDialog("Ingrese el nombre de la compra:");
        String detalles = JOptionPane.showInputDialog("Ingrese los detalles de la compra:");
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad:"));
        int precio_unidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio por unidad:"));

        if (nombre_compra != null && !nombre_compra.trim().isEmpty() && cantidad > 0 && precio_unidad > 0) {
            DetallesCompra detallesCompra = new DetallesCompra(id_compra, id_producto, nombre_compra, detalles, cantidad, precio_unidad);
            createDetallesCompraUseCase.execute(detallesCompra);
            JOptionPane.showMessageDialog(null, "Detalles de compra añadidos exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Datos de los detalles de compra no válidos.");
        }
    }

    private void editaDetallesCompra() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID de los detalles de compra que desea editar:");
        if (idString != null && !idString.trim().isEmpty()) {
            int id_detalles_compra = Integer.parseInt(idString);
            DetallesCompra detallesCompra = detallesCompraService.findDetallesCompraById(id_detalles_compra);

            if (detallesCompra != null) {
                int nuevoIdCompra = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ID de la compra:", detallesCompra.getId_compra()));
                int nuevoIdProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ID del producto:", detallesCompra.getId_producto()));
                String nuevoNombreCompra = JOptionPane.showInputDialog("Ingrese el nuevo nombre de la compra:", detallesCompra.getNombre_compra());
                String nuevosDetalles = JOptionPane.showInputDialog("Ingrese los nuevos detalles:", detallesCompra.getDetalles());
                int nuevaCantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad:", detallesCompra.getCantidad()));
                int nuevoPrecioUnidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo precio por unidad:", detallesCompra.getPrecio_unidad()));

                detallesCompra.setId_compra(nuevoIdCompra);
                detallesCompra.setId_producto(nuevoIdProducto);
                detallesCompra.setNombre_compra(nuevoNombreCompra);
                detallesCompra.setDetalles(nuevosDetalles);
                detallesCompra.setCantidad(nuevaCantidad);
                detallesCompra.setPrecio_unidad(nuevoPrecioUnidad);

                detallesCompraService.updateDetallesCompra(detallesCompra);
                JOptionPane.showMessageDialog(null, "Detalles de compra actualizados exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Detalles de compra no encontrados.");
            }
        }
    }

    private void searchDetallesCompra() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID de los detalles de compra que desea buscar:");
        if (idString != null && !idString.trim().isEmpty()) {
            int id_detalles_compra = Integer.parseInt(idString);
            DetallesCompra detallesCompra = detallesCompraService.findDetallesCompraById(id_detalles_compra);

            if (detallesCompra != null) {
                String mensaje = String.format("ID: %d\nID Compra: %d\nID Producto: %d\nNombre Compra: %s\nDetalles: %s\nCantidad: %d\nPrecio Unidad: %d",
                        detallesCompra.getId_detalles_compra(),
                        detallesCompra.getId_compra(),
                        detallesCompra.getId_producto(),
                        detallesCompra.getNombre_compra(),
                        detallesCompra.getDetalles(),
                        detallesCompra.getCantidad(),
                        detallesCompra.getPrecio_unidad());
                JOptionPane.showMessageDialog(null, mensaje);
            } else {
                JOptionPane.showMessageDialog(null, "Detalles de compra no encontrados.");
            }
        }
    }

    private void deleteDetallesCompra() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID de los detalles de compra que desea eliminar:");
        if (idString != null && !idString.trim().isEmpty()) {
            int id_detalles_compra = Integer.parseInt(idString);
            DetallesCompra detallesCompra = detallesCompraService.findDetallesCompraById(id_detalles_compra);

            if (detallesCompra != null) {
                detallesCompraService.deleteDetallesCompra(id_detalles_compra);
                JOptionPane.showMessageDialog(null, "Detalles de compra eliminados exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Detalles de compra no encontrados.");
            }
        }
    }
}
