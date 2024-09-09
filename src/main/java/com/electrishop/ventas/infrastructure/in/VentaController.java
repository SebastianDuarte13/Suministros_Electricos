package com.electrishop.ventas.infrastructure.in;

import javax.swing.JOptionPane;
import java.sql.Date;
import com.electrishop.ventas.application.CreateVentaUseCase;
import com.electrishop.ventas.domain.entity.Venta;
import com.electrishop.ventas.domain.service.VentaService;

public class VentaController {
    private CreateVentaUseCase createVentaUseCase;
    private VentaService ventaService;

    public VentaController(CreateVentaUseCase createVentaUseCase, VentaService ventaService) {
        this.createVentaUseCase = createVentaUseCase;
        this.ventaService = ventaService;
    }

    public void tabla_Ventas() {
        while (true) {
            String[] options = { "Añadir Venta", "Editar Venta", "Mostrar Venta", "Eliminar Venta", "Salir" };
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Ventas",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addVenta();
                    break;
                case 1:
                    editaVenta();
                    break;
                case 2:
                    searchVenta();
                    break;
                case 3:
                    deleteVenta();
                    break;
                case 4:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private void addVenta() {
        int id_cliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del cliente:"));
        Date fecha_venta = Date.valueOf(JOptionPane.showInputDialog("Ingrese la fecha de venta (YYYY-MM-DD):"));

        Venta venta = new Venta(id_cliente, fecha_venta);
        createVentaUseCase.execute(venta);
        JOptionPane.showMessageDialog(null, "Venta añadida exitosamente.");
    }

    private void editaVenta() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID de la venta que desea editar:");
        if (idString != null && !idString.trim().isEmpty()) {
            int id_venta = Integer.parseInt(idString);
            Venta venta = ventaService.findVentaById(id_venta);

            if (venta != null) {
                int id_cliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ID del cliente:", venta.getId_cliente()));
                Date fecha_venta = Date.valueOf(JOptionPane.showInputDialog("Ingrese la nueva fecha de venta (YYYY-MM-DD):", venta.getFecha_venta()));

                venta.setId_cliente(id_cliente);
                venta.setFecha_venta(fecha_venta);

                ventaService.updateVenta(venta);
                JOptionPane.showMessageDialog(null, "Venta actualizada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Venta no encontrada.");
            }
        }
    }

    private void searchVenta() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID de la venta que desea buscar:");
        if (idString != null && !idString.trim().isEmpty()) {
            int id_venta = Integer.parseInt(idString);
            Venta venta = ventaService.findVentaById(id_venta);
    
            if (venta != null) {
                String mensaje = String.format("ID Venta: %d\nID Cliente: %d\nFecha de venta: %s",
                        venta.getId_venta(),  // Asegúrate de mostrar el ID correcto
                        venta.getId_cliente(),
                        venta.getFecha_venta());
                JOptionPane.showMessageDialog(null, mensaje);
            } else {
                JOptionPane.showMessageDialog(null, "Venta no encontrada.");
            }
        }
    }
    

    private void deleteVenta() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID de la venta que desea eliminar:");
        if (idString != null && !idString.trim().isEmpty()) {
            int id_venta = Integer.parseInt(idString);
            Venta venta = ventaService.findVentaById(id_venta);

            if (venta != null) {
                ventaService.deleteVenta(id_venta);
                JOptionPane.showMessageDialog(null, "Venta eliminada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Venta no encontrada.");
            }
        }
    }
}
