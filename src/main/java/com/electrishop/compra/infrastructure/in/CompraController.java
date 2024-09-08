package com.electrishop.compra.infrastructure.in;

import javax.swing.JOptionPane;
import java.sql.Date;

import com.electrishop.compra.application.CreateCompraUseCase;
import com.electrishop.compra.domain.entity.Compra;
import com.electrishop.compra.domain.service.CompraService;

public class CompraController {
    private CreateCompraUseCase createCompraUseCase;
    private CompraService compraService;

    public CompraController(CreateCompraUseCase createCompraUseCase, CompraService compraService) {
        this.createCompraUseCase = createCompraUseCase;
        this.compraService = compraService;
    }

    public void tabla_Compra() {
        while (true) {
            String[] options = { "Añadir Compra", "Editar Compra", "Mostrar Compra", "Eliminar Compra", "Salir al menú anterior" };
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Compra",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addCompra();
                    break;
                case 1:
                    editaCompra();
                    break;
                case 2:
                    searchCompra();
                    break;
                case 3:
                    deleteCompra();
                    break;
                case 4:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private void addCompra() {
        String id_proveedor = JOptionPane.showInputDialog("Ingrese el ID del proveedor:");
        String fecha_compraStr = JOptionPane.showInputDialog("Ingrese la fecha de la compra (yyyy-MM-dd):");
        int precio_compra = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio de la compra:"));

        try {
            Date fecha_compra = Date.valueOf(fecha_compraStr);

            if (id_proveedor != null && !id_proveedor.trim().isEmpty() && precio_compra > 0) {
                Compra compra = new Compra(Integer.parseInt(id_proveedor), fecha_compra, precio_compra);
                createCompraUseCase.execute(compra);
                JOptionPane.showMessageDialog(null, "Compra añadida exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Datos de la compra no válidos.");
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto.");
        }
    }

    private void editaCompra() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID de la compra que desea editar:");
        if (idString != null && !idString.trim().isEmpty()) {
            int id_compra = Integer.parseInt(idString);
            Compra compra = compraService.FindCompraById(id_compra);
    
            if (compra != null) {
                String nuevoIdProveedor = JOptionPane.showInputDialog("Ingrese el nuevo ID del proveedor:", compra.getId_proveedor());
                String nuevaFechaCompraStr = JOptionPane.showInputDialog("Ingrese la nueva fecha de la compra (yyyy-MM-dd):", compra.getFecha_compra().toString());
                int nuevoPrecioCompra = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo precio de la compra:", compra.getPrecio_compra()));
    
                try {
                    Date nuevaFechaCompra = Date.valueOf(nuevaFechaCompraStr);
    
                    compra.setId_proveedor(Integer.parseInt(nuevoIdProveedor));
                    compra.setFecha_compra(nuevaFechaCompra);
                    compra.setPrecio_compra(nuevoPrecioCompra);
    
                    compraService.UpdateCompra(compra);
                    JOptionPane.showMessageDialog(null, "Compra actualizada exitosamente.");
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Compra no encontrada.");
            }
        }
    }
    

    private void searchCompra() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID de la compra que desea buscar:");
        if (idString != null && !idString.trim().isEmpty()) {
            int id_compra = Integer.parseInt(idString);
            Compra compra = compraService.FindCompraById(id_compra);
    
            if (compra != null) {
                String mensaje = String.format("ID: %d\nID Proveedor: %d\nFecha de Compra: %s\nPrecio de Compra: %d",
                        compra.getId_compra(),
                        compra.getId_proveedor(),
                        compra.getFecha_compra().toString(),
                        compra.getPrecio_compra());
                JOptionPane.showMessageDialog(null, mensaje);
            } else {
                JOptionPane.showMessageDialog(null, "Compra no encontrada.");
            }
        }
    }
    

    private void deleteCompra() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID de la compra que desea eliminar:");
        if (idString != null && !idString.trim().isEmpty()) {
            int id_compra = Integer.parseInt(idString);
            Compra compra = compraService.FindCompraById(id_compra);

            if (compra != null) {
                compraService.DeleteCompra(id_compra);
                JOptionPane.showMessageDialog(null, "Compra eliminada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Compra no encontrada.");
            }
        }
    }
}
