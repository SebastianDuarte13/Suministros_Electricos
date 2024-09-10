package com.electrishop.historialventas.infrastructure.in;

import javax.swing.JOptionPane;
import java.util.List;

import com.electrishop.historialventas.domain.entity.HistorialVentas;
import com.electrishop.historialventas.domain.service.HistorialVentasService;

public class HistorialVentasController {
    private HistorialVentasService historialVentasService;

    public HistorialVentasController(HistorialVentasService historialVentasService) {
        this.historialVentasService = historialVentasService;
    }

    public void tabla_Historial_ventas() {
        while (true) {
            String[] options = { "Historial Ventas", "Salir al menú anterior" };
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Facturas",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    Historial();
                    break;
                case 1:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private void Historial() {
        List<HistorialVentas> historialVentasList = historialVentasService.FindAllHistorial();
        StringBuilder message = new StringBuilder();

        for (HistorialVentas historialVentas : historialVentasList) {
            message.append(String.format("Id_venta: %d\nFecha_venta: %s\nNombre Cliente: %s\nApellido cliente: %s\n\n",
                historialVentas.getId_venta(),
                historialVentas.getFecha_venta(),
                historialVentas.getNombre_cliente(),
                historialVentas.getApellido_cliente()));
        }

        if (message.length() > 0) {
            JOptionPane.showMessageDialog(null, message.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No hay registros para mostrar.");
        }
    }
}
