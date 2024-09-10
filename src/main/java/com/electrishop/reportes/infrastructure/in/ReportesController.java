package com.electrishop.reportes.infrastructure.in;

import javax.swing.JOptionPane;
import java.util.List;
import com.electrishop.reportes.domain.entity.Reportes;
import com.electrishop.reportes.domain.service.ReportesService;

public class ReportesController {
    private ReportesService reportesService;

    public ReportesController(ReportesService reportesService) {
        this.reportesService = reportesService;
    }

    public void tabla_Reporte() {
        while (true) {
            String[] options = { "Reporte Ventas", "Reportes cliente", "Reportes productos", "Salir" };
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Reportes",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    reportventa();
                    break;
                case 1:
                    reportclientes();
                    break;
                case 2:
                    reportproduct();
                    break;
                case 3:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private void reportventa() {
        List<Reportes> reportes = reportesService.getAllVentas();
        if (reportes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron reportes de ventas.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Reportes reporte : reportes) {
                sb.append("Venta ID: ").append(reporte.getId_venta()).append("\n")
                  .append("Cliente ID: ").append(reporte.getId_cliente()).append("\n")
                  .append("Fecha: ").append(reporte.getFecha_venta()).append("\n")
                  .append("------------------------------\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    private void reportclientes() {
        List<Reportes> reportes = reportesService.getAllClientes();
        if (reportes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron reportes de clientes.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Reportes reporte : reportes) {
                sb.append("Cliente ID: ").append(reporte.getId_cliente()).append("\n")
                  .append("Nombre: ").append(reporte.getNombre_cliente()).append("\n")
                  .append("Apellido: ").append(reporte.getApellido_cliente()).append("\n")
                  .append("Email: ").append(reporte.getEmail_cliente()).append("\n")
                  .append("Teléfono: ").append(reporte.getTelefono_cliente()).append("\n")
                  .append("------------------------------\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    private void reportproduct() {
        List<Reportes> reportes = reportesService.getAllProductos();
        if (reportes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron reportes de productos.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Reportes reporte : reportes) {
                sb.append("Producto ID: ").append(reporte.getId_producto()).append("\n")
                  .append("Nombre: ").append(reporte.getNombre_producto()).append("\n")
                  .append("Descripción: ").append(reporte.getDescripcion_producto()).append("\n")
                  .append("Precio: ").append(reporte.getPrecio_producto()).append("\n")
                  .append("Categoría ID: ").append(reporte.getId_categoria()).append("\n")
                  .append("------------------------------\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }
}
