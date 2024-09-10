package com.electrishop.detallesventas.infrastructure.in;

import javax.swing.JOptionPane;
import com.electrishop.detallesventas.application.CreateDetallesVentasUseCase;
import com.electrishop.detallesventas.domain.entity.DetallesVentas;
import com.electrishop.detallesventas.domain.service.DetallesVentasService;

public class DetallesVentasController {
    private CreateDetallesVentasUseCase createDetallesVentasUseCase;
    private DetallesVentasService detallesVentasService;

    public DetallesVentasController(CreateDetallesVentasUseCase createDetallesVentasUseCase, DetallesVentasService detallesVentasService) {
        this.createDetallesVentasUseCase = createDetallesVentasUseCase;
        this.detallesVentasService = detallesVentasService;
    }

    public void tabla_DetallesVentas() {
        while (true) {
            String[] options = { "Añadir Detalles de Venta", "Editar Detalles de Venta", "Mostrar Detalles de Venta", "Eliminar Detalles de Venta", "Salir al menú anterior" };
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Detalles de Venta", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addDetallesVentas();
                    break;
                case 1:
                    editaDetallesVentas();
                    break;
                case 2:
                    searchDetallesVentas();
                    break;
                case 3:
                    deleteDetallesVentas();
                    break;
                case 4:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private void addDetallesVentas() {
        int id_venta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la venta:"));
        int id_producto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto:"));
        int cantidad_productos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de productos:"));
        double subprecio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el subprecio:"));
        int descuento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el descuento:"));
        
        // Calcula el total
        double total = (cantidad_productos * subprecio) - descuento;
    
        // Crea el objeto DetallesVentas con el total calculado
        DetallesVentas detallesVentas = new DetallesVentas(id_venta, id_producto, cantidad_productos, subprecio, descuento, total);
        createDetallesVentasUseCase.execute(detallesVentas);
        JOptionPane.showMessageDialog(null, "Detalles de venta añadidos exitosamente.");
    }
    

    private void editaDetallesVentas() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID de los detalles de venta que desea editar:");
        if (idString == null || idString.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID no válido.");
            return;
        }
        
        int id_detalle_venta;
        try {
            id_detalle_venta = Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID debe ser un número entero.");
            return;
        }
        
        DetallesVentas detallesVentas = detallesVentasService.findDetallesVentasById(id_detalle_venta);
        if (detallesVentas != null) {
            int id_venta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ID de la venta:", detallesVentas.getId_venta()));
            int id_producto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ID del producto:", detallesVentas.getId_producto()));
            int cantidad_productos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad de productos:", detallesVentas.getCantidad_productos()));
            double subprecio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo subprecio:", detallesVentas.getSubprecio()));
            int descuento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo descuento:", detallesVentas.getDescuento()));
            double total = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo total:", detallesVentas.getTotal()));
    
            detallesVentas.setId_venta(id_venta);
            detallesVentas.setId_producto(id_producto);
            detallesVentas.setCantidad_productos(cantidad_productos);
            detallesVentas.setSubprecio(subprecio);
            detallesVentas.setDescuento(descuento);
            detallesVentas.setTotal(total);
    
            detallesVentasService.updateDetallesVentas(detallesVentas);
            JOptionPane.showMessageDialog(null, "Detalles de venta actualizados exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Detalles de venta no encontrados.");
        }
    }
    

    private void searchDetallesVentas() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID de los detalles de venta que desea buscar:");
        int id_detalle_venta = Integer.parseInt(idString);

        DetallesVentas detallesVentas = detallesVentasService.findDetallesVentasById(id_detalle_venta);
        if (detallesVentas != null) {
            String message = String.format(
                "ID Detalle de Venta: %d\nID Venta: %d\nID Producto: %d\nCantidad de Productos: %d\nSubprecio: %.2f\nDescuento: %d\nTotal: %.2f",
                detallesVentas.getId_detalle_venta(),
                detallesVentas.getId_venta(),
                detallesVentas.getId_producto(),
                detallesVentas.getCantidad_productos(),
                detallesVentas.getSubprecio(),
                detallesVentas.getDescuento(),
                detallesVentas.getTotal()
            );
            JOptionPane.showMessageDialog(null, message);
        } else {
            JOptionPane.showMessageDialog(null, "Detalles de venta no encontrados.");
        }
    }

    private void deleteDetallesVentas() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID de los detalles de venta que desea eliminar:");
        int id_detalle_venta = Integer.parseInt(idString);

        detallesVentasService.deleteDetallesVentas(id_detalle_venta);
        JOptionPane.showMessageDialog(null, "Detalles de venta eliminados exitosamente.");
    }
}

