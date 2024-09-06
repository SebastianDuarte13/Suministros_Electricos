package com.electrishop.proveedor.infrastructure.in;

import javax.swing.JOptionPane;

import com.electrishop.proveedor.application.CreateProveedoresUseCase;
import com.electrishop.proveedor.domain.entity.Proveedores;
import com.electrishop.proveedor.domain.service.ProveedoresService;

public class ProveedoresController {
    private CreateProveedoresUseCase createProveedoresUseCase;
    private ProveedoresService proveedoresService;

    public ProveedoresController(CreateProveedoresUseCase createProveedoresUseCase,
            ProveedoresService proveedoresService) {
        this.createProveedoresUseCase = createProveedoresUseCase;
        this.proveedoresService = proveedoresService;
    }

    public void tabla_proveedor() {
        while (true) {
            String[] options = { "Añadir proveedor", "Editar proveedor", "Mostrar proveedor", "Eliminar proveedor", "Salir al menú anterior" };
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Proveedores",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addProveedor();
                    break;
                case 1:
                    editaProveedor();
                    break;
                case 2:
                    searchProveedor();
                    break;
                case 3:
                    deleteProveedor();
                    break;
                case 4:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private void addProveedor() {
        String nombre_proveedor = JOptionPane.showInputDialog("Ingrese el nombre del proveedor:");
        String apellido_proveedor = JOptionPane.showInputDialog("Ingrese el apellido del proveedor:");
        String email_proveedor = JOptionPane.showInputDialog( "ingrese el email del proveedor");
        String telefono_proveedor = JOptionPane.showInputDialog( "ingrese el telefono del proveedor");
        String direccion_proveedor = JOptionPane.showInputDialog( "ingrese la direccion del proveedor");
    
        if (nombre_proveedor != null && !apellido_proveedor.trim().isEmpty() && email_proveedor != null && !telefono_proveedor.trim().isEmpty()) {
            Proveedores proveedores = new Proveedores(direccion_proveedor, direccion_proveedor, direccion_proveedor, direccion_proveedor, direccion_proveedor);
            createProveedoresUseCase.execute(proveedores); 
            JOptionPane.showMessageDialog(null, "Usuario añadido exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Datos del usuario no válidos.");
        }
    }    


    private void editaProveedor() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID del proveedor que desea editar:");
        if (idString != null && !idString.trim().isEmpty()) {
            int id_proveedor = Integer.parseInt(idString);
            Proveedores proveedor = proveedoresService.FindProveedoresById(id_proveedor);
    
            if (proveedor != null) {
                String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del proveedor:", proveedor.getNombre_proveedor());
                String nuevoApellido = JOptionPane.showInputDialog("Ingrese el nuevo apellido del proveedor:", proveedor.getApellido_proveedor());
                String nuevoEmail = JOptionPane.showInputDialog("Ingrese el nuevo email del proveedor:", proveedor.getEmail_proveedor());
                String nuevoTelefono = JOptionPane.showInputDialog("Ingrese el nuevo teléfono del proveedor:", proveedor.getTelefono_proveedor());
                String nuevaDireccion = JOptionPane.showInputDialog("Ingrese la nueva dirección del proveedor:", proveedor.getDireccion_proveedor());
    
                if (nuevoNombre != null && !nuevoNombre.trim().isEmpty() && nuevoApellido != null && !nuevoApellido.trim().isEmpty() &&
                    nuevoEmail != null && !nuevoEmail.trim().isEmpty() && nuevoTelefono != null && !nuevoTelefono.trim().isEmpty() &&
                    nuevaDireccion != null && !nuevaDireccion.trim().isEmpty()) {
    
                    proveedor.setNombre_proveedor(nuevoNombre);
                    proveedor.setApellido_proveedor(nuevoApellido);
                    proveedor.setEmail_proveedor(nuevoEmail);
                    proveedor.setTelefono_proveedor(nuevoTelefono);
                    proveedor.setDireccion_proveedor(nuevaDireccion);
    
                    proveedoresService.UpdateProveedores(proveedor);
                    JOptionPane.showMessageDialog(null, "Proveedor editado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Datos del proveedor no válidos.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Proveedor no encontrado.");
            }
        }
    }
    
    

    
    

    private void searchProveedor() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID del proveedor que desea buscar:");
        if (idString != null && !idString.trim().isEmpty()) {
            int id_proveedor = Integer.parseInt(idString);
            Proveedores proveedor = proveedoresService.FindProveedoresById(id_proveedor);
    
            if (proveedor != null) {
                String message = String.format("ID: %d\nNombre: %s\nApellido: %s\nEmail: %s\nTeléfono: %s\nDirección: %s",
                        proveedor.getId_proveedor(), proveedor.getNombre_proveedor(), proveedor.getApellido_proveedor(),
                        proveedor.getEmail_proveedor(), proveedor.getTelefono_proveedor(), proveedor.getDireccion_proveedor());
                JOptionPane.showMessageDialog(null, message);
            } else {
                JOptionPane.showMessageDialog(null, "Proveedor no encontrado.");
            }
        }
    }
    

    private void deleteProveedor() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID del proveedor que desea eliminar:");
        if (idString != null && !idString.trim().isEmpty()) {
            int id_proveedor = Integer.parseInt(idString);
            Proveedores proveedor = proveedoresService.FindProveedoresById(id_proveedor);
    
            if (proveedor != null) {
                proveedoresService.DeleteProveedores(id_proveedor);
                JOptionPane.showMessageDialog(null, "Proveedor eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Proveedor no encontrado.");
            }
        }
    }
    
    
    
}
