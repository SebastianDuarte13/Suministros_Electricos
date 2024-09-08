package com.electrishop.inventario.infrastructure.in;

import javax.swing.JOptionPane;
import java.sql.Date;
import com.electrishop.inventario.application.CreateInventarioUseCase;
import com.electrishop.inventario.domain.entity.Inventario;
import com.electrishop.inventario.domain.service.InventarioService;

public class InventarioController {
    private CreateInventarioUseCase createInventarioUseCase;
    private InventarioService inventarioService;

    public InventarioController(CreateInventarioUseCase createInventarioUseCase, InventarioService inventarioService) {
        this.createInventarioUseCase = createInventarioUseCase;
        this.inventarioService = inventarioService;
    }

    public void tabla_Inventario() {
        while (true) {
            String[] options = { "Añadir Inventario", "Editar Inventario", "Mostrar Inventario", "Eliminar Inventario", "Salir" };
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Inventario",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addInventario();
                    break;
                case 1:
                    editaInventario();
                    break;
                case 2:
                    searchInventario();
                    break;
                case 3:
                    deleteInventario();
                    break;
                case 4:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private void addInventario() {
        int id_producto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto:"));
        int cantidad_inventario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de inventario:"));
        Date fecha_ingreso = Date.valueOf(JOptionPane.showInputDialog("Ingrese la fecha de ingreso (YYYY-MM-DD):"));
        Date fecha_actualizacion = Date.valueOf(JOptionPane.showInputDialog("Ingrese la fecha de actualización (YYYY-MM-DD):"));

        if (fecha_ingreso != null && fecha_actualizacion != null) {
            Inventario inventario = new Inventario(id_producto, cantidad_inventario, fecha_ingreso, fecha_actualizacion);
            createInventarioUseCase.execute(inventario);
            JOptionPane.showMessageDialog(null, "Inventario añadido exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Datos del inventario no válidos.");
        }
    }

    private void editaInventario() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID del inventario que desea editar:");
        if (idString != null && !idString.trim().isEmpty()) {
            int id_inventario = Integer.parseInt(idString);
            Inventario inventario = inventarioService.findInventarioById(id_inventario);

            if (inventario != null) {
                int id_producto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ID del producto:", inventario.getId_producto()));
                int cantidad_inventario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad de inventario:", inventario.getCantidad_inventario()));
                Date fecha_ingreso = Date.valueOf(JOptionPane.showInputDialog("Ingrese la nueva fecha de ingreso (YYYY-MM-DD):", inventario.getFecha_ingreso()));
                Date fecha_actualizacion = Date.valueOf(JOptionPane.showInputDialog("Ingrese la nueva fecha de actualización (YYYY-MM-DD):", inventario.getFecha_actualizacion()));

                inventario.setId_producto(id_producto);
                inventario.setCantidad_inventario(cantidad_inventario);
                inventario.setFecha_ingreso(fecha_ingreso);
                inventario.setFecha_actualizacion(fecha_actualizacion);

                inventarioService.updateInventario(inventario);
                JOptionPane.showMessageDialog(null, "Inventario actualizado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Inventario no encontrado.");
            }
        }
    }

    private void searchInventario() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID del inventario que desea buscar:");
        if (idString != null && !idString.trim().isEmpty()) {
            int id_inventario = Integer.parseInt(idString);
            Inventario inventario = inventarioService.findInventarioById(id_inventario);

            if (inventario != null) {
                String mensaje = String.format("ID: %d\nID producto: %d\nCantidad: %d\nFecha de ingreso: %s\nFecha de actualización: %s",
                        inventario.getId_inventario(), inventario.getId_producto(), inventario.getCantidad_inventario(),
                        inventario.getFecha_ingreso().toString(), inventario.getFecha_actualizacion().toString());
                JOptionPane.showMessageDialog(null, mensaje);
            } else {
                JOptionPane.showMessageDialog(null, "Inventario no encontrado.");
            }
        }
    }

    private void deleteInventario() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID del inventario que desea eliminar:");
        if (idString != null && !idString.trim().isEmpty()) {
            int id_inventario = Integer.parseInt(idString);
            inventarioService.deleteInventario(id_inventario);
            JOptionPane.showMessageDialog(null, "Inventario eliminado exitosamente.");
        }
    }
}
