package com.electrishop.factura.infrastructure.in;

import javax.swing.JOptionPane;

import com.electrishop.factura.domain.entity.Factura;
import com.electrishop.factura.domain.service.FacturaService;

public class FacturaController {
    private FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    public void tabla_factura() {
        while (true) {
            String[] options = { "Buscar factura", "Salir al menú anterior" };
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Facturas",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    searchFactura();
                    break;
                case 1:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private void searchFactura() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID de la factura que desea buscar:");
        if (idString != null && !idString.trim().isEmpty()) {
            try {
                int id_factura = Integer.parseInt(idString);
                Factura factura = facturaService.FindFacturaById(id_factura);
    
                if (factura != null) {
                    String message = String.format("ID: %d\nFecha: %s\nNombre Cliente: %s\nApellido cliente: %s\nProducto: %s\nDescripcion: %s\nCantidad: %d\nSubPrecio: %.2f\nDescuento: %d\nTotal: %.2f",
                        factura.getId_detalle_venta(),
                        factura.getFecha_venta(),
                        factura.getNombre_cliente(),
                        factura.getApellido_cliente(),
                        factura.getNombre_producto(),
                        factura.getDescripcion_producto(),
                        factura.getCantidad_productos(),
                        factura.getSubprecio(),
                        factura.getDescuento(),
                        factura.getTotal()
                    );
                    JOptionPane.showMessageDialog(null, message);
                } else {
                    JOptionPane.showMessageDialog(null, "Factura no encontrada.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID de factura inválido.");
            }
        }
    }
}
