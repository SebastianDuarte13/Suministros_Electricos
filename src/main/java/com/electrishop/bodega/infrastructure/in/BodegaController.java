package com.electrishop.bodega.infrastructure.in;

import javax.swing.JOptionPane;
import com.electrishop.bodega.application.CreateBodegaUseCase;
import com.electrishop.bodega.domain.entity.Bodega;
import com.electrishop.bodega.domain.service.BodegaService;

public class BodegaController {
    private CreateBodegaUseCase createBodegaUseCase;
    private BodegaService bodegaService;

    public BodegaController(CreateBodegaUseCase createBodegaUseCase, BodegaService bodegaService) {
        this.createBodegaUseCase = createBodegaUseCase;
        this.bodegaService = bodegaService;
    }

    public void tabla_Bodega() {
        while (true) {
            String[] options = { "Añadir Bodega", "Editar Bodega", "Mostrar Bodega", "Eliminar Bodega", "Salir" };
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Bodega",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addBodega();
                    break;
                case 1:
                    editaBodega();
                    break;
                case 2:
                    searchBodega();
                    break;
                case 3:
                    deleteBodega();
                    break;
                case 4:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private void addBodega() {
        int id_inventario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del inventario:"));
        Bodega bodega = new Bodega(id_inventario);
        createBodegaUseCase.execute(bodega);
        JOptionPane.showMessageDialog(null, "Bodega añadida exitosamente.");
    }

    private void editaBodega() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID de la bodega que desea editar:");
        if (idString != null && !idString.trim().isEmpty()) {
            int id_bodega = Integer.parseInt(idString);
            Bodega bodega = bodegaService.findBodegaById(id_bodega);

            if (bodega != null) {
                int id_inventario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ID del inventario:", bodega.getId_inventario()));
                bodega.setId_inventario(id_inventario);

                bodegaService.updateBodega(bodega);
                JOptionPane.showMessageDialog(null, "Bodega actualizada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Bodega no encontrada.");
            }
        }
    }

    private void searchBodega() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID de la bodega que desea buscar:");
        if (idString != null && !idString.trim().isEmpty()) {
            int id_bodega = Integer.parseInt(idString);
            Bodega bodega = bodegaService.findBodegaById(id_bodega);

            if (bodega != null) {
                String mensaje = String.format("ID: %d\nID inventario: %d", bodega.getId_bodega(), bodega.getId_inventario());
                JOptionPane.showMessageDialog(null, mensaje);
            } else {
                JOptionPane.showMessageDialog(null, "Bodega no encontrada.");
            }
        }
    }

    private void deleteBodega() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID de la bodega que desea eliminar:");
        if (idString != null && !idString.trim().isEmpty()) {
            int id_bodega = Integer.parseInt(idString);
            bodegaService.deleteBodega(id_bodega);
            JOptionPane.showMessageDialog(null, "Bodega eliminada exitosamente.");
        }
    }
}
