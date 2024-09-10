package com.electrishop.sucursal.infrastructure.in;

import javax.swing.JOptionPane;
import com.electrishop.sucursal.application.CreateSucursalUseCase;
import com.electrishop.sucursal.domain.entity.Sucursal;
import com.electrishop.sucursal.domain.service.SucursalService;

public class SucursalController {
    private CreateSucursalUseCase createSucursalUseCase;
    private SucursalService sucursalService;

    public SucursalController(CreateSucursalUseCase createSucursalUseCase, SucursalService sucursalService) {
        this.createSucursalUseCase = createSucursalUseCase;
        this.sucursalService = sucursalService;
    }

    public void tabla_Sucursal() {
        while (true) {
            String[] options = { "Añadir Sucursal", "Editar Sucursal", "Mostrar Sucursal", "Eliminar Sucursal", "Salir al menú anterior" };
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Sucursales", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addSucursal();
                    break;
                case 1:
                    editSucursal();
                    break;
                case 2:
                    searchSucursal();
                    break;
                case 3:
                    deleteSucursal();
                    break;
                case 4:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private void addSucursal() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la sucursal:");
        String direccion = JOptionPane.showInputDialog("Ingrese la dirección:");
        String telefono = JOptionPane.showInputDialog("Ingrese el teléfono:");
        int id_ciudad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la ciudad:"));
        int id_producto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto:"));

        Sucursal sucursal = new Sucursal(nombre, direccion, telefono, id_ciudad, id_producto);
        createSucursalUseCase.execute(sucursal);
        JOptionPane.showMessageDialog(null, "Sucursal añadida exitosamente.");
    }

    private void editSucursal() {
        int id_sucursal = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la sucursal que desea editar:"));
        Sucursal sucursal = sucursalService.findSucursalById(id_sucursal);

        if (sucursal != null) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre de la sucursal:", sucursal.getNombre());
            String direccion = JOptionPane.showInputDialog("Ingrese la nueva dirección:", sucursal.getDireccion());
            String telefono = JOptionPane.showInputDialog("Ingrese el nuevo teléfono:", sucursal.getTelefono());
            int id_ciudad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ID de la ciudad:", sucursal.getId_ciudad()));
            int id_producto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ID del producto:", sucursal.getId_producto()));

            sucursal.setNombre(nombre);
            sucursal.setDireccion(direccion);
            sucursal.setTelefono(telefono);
            sucursal.setId_ciudad(id_ciudad);
            sucursal.setId_producto(id_producto);

            sucursalService.updateSucursal(sucursal);
            JOptionPane.showMessageDialog(null, "Sucursal actualizada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Sucursal no encontrada.");
        }
    }

    private void searchSucursal() {
        int id_sucursal = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la sucursal que desea buscar:"));
        Sucursal sucursal = sucursalService.findSucursalById(id_sucursal);

        if (sucursal != null) {
            String mensaje = String.format("ID: %d\nNombre: %s\nDirección: %s\nTeléfono: %s\nID Ciudad: %d\nID Producto: %d",
                    sucursal.getId_sucursal(), sucursal.getNombre(), sucursal.getDireccion(), sucursal.getTelefono(), sucursal.getId_ciudad(), sucursal.getId_producto());
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            JOptionPane.showMessageDialog(null, "Sucursal no encontrada.");
        }
    }

    private void deleteSucursal() {
        int id_sucursal = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la sucursal que desea eliminar:"));
        sucursalService.deleteSucursal(id_sucursal);
        JOptionPane.showMessageDialog(null, "Sucursal eliminada exitosamente.");
    }
}
