package com.electrishop.clientes.infrastructure.in;

import javax.swing.JOptionPane;

import com.electrishop.clientes.application.CreateClientesUseCase;
import com.electrishop.clientes.domain.entity.Clientes;
import com.electrishop.clientes.domain.service.ClientesService;

public class ClientesController {
    private CreateClientesUseCase createClientesUseCase;
    private ClientesService clientesService;
    public ClientesController(CreateClientesUseCase createClientesUseCase, ClientesService clientesService) {
        this.createClientesUseCase = createClientesUseCase;
        this.clientesService = clientesService;
    }

    public void tabla_Clientes() {
        while (true) {
            String[] options = { "Añadir Clientes", "Editar Clientes", "Mostrar Clientes", "Eliminar Clientes", "Salir al menú anterior" };
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Clientes",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addClientes();
                    break;
                case 1:
                    editaClientes();
                    break;
                case 2:
                    searchClientes();
                    break;
                case 3:
                    deleteClientes();
                    break;
                case 4:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }
    private void addClientes() {
        String nombre_cliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
        String apellido_cliente = JOptionPane.showInputDialog("Ingrese el apellido del cliente:");
        String email_cliente = JOptionPane.showInputDialog( "ingrese el email del cliente");
        String telefono_cliente = JOptionPane.showInputDialog( "ingrese el telefono del cliente");
        int id_direcciionclien = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la direccion del cliente:"));
    
        if (nombre_cliente != null && !apellido_cliente.trim().isEmpty() && email_cliente != null && !telefono_cliente.trim().isEmpty()) {
            Clientes clientes = new Clientes(telefono_cliente, telefono_cliente, telefono_cliente, telefono_cliente, id_direcciionclien);
            createClientesUseCase.execute(clientes); 
            JOptionPane.showMessageDialog(null, "cliente añadido exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Datos del cliente no válidos.");
        }
    }    


    private void editaClientes() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID del cliente que desea editar:");
        if (idString != null && !idString.trim().isEmpty()) {
            int id_cliente = Integer.parseInt(idString);
            Clientes clientes = clientesService.FindClientesById(id_cliente);
    
            if (clientes != null) {
                String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del cliente:", clientes.getNombre_cliente());
                String nuevoApellido = JOptionPane.showInputDialog("Ingrese el nuevo apellido del cliente:", clientes.getApellido_cliente());
                String nuevoEmail = JOptionPane.showInputDialog("Ingrese el nuevo email del cliente:", clientes.getEmail_cliente());
                String nuevoTelefono = JOptionPane.showInputDialog("Ingrese el nuevo teléfono del cliente:", clientes.getTelefono_cliente());
                int nuevaid_direcciionclien = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la direccion del cliente:", clientes.getId_direccioncliente()));
    
                if (nuevoNombre != null && !nuevoNombre.trim().isEmpty() && nuevoApellido != null && !nuevoApellido.trim().isEmpty() &&
                    nuevoEmail != null && !nuevoEmail.trim().isEmpty() && nuevoTelefono != null && !nuevoTelefono.trim().isEmpty() &&
                    nuevaid_direcciionclien != 0) {
    
                        clientes.setNombre_cliente(nuevoNombre);
                        clientes.setApellido_cliente(nuevoApellido);
                        clientes.setEmail_cliente(nuevoEmail);
                        clientes.setTelefono_cliente(nuevoTelefono);
                        clientes.setId_direccioncliente(nuevaid_direcciionclien);
    
                    clientesService.UpdateClientes(clientes);
                    JOptionPane.showMessageDialog(null, "cliente editado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Datos del cliente no válidos.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "cliente no encontrado.");
            }
        }
    }
    
    

    
    

    private void searchClientes() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID del cliente que desea buscar:");
        if (idString != null && !idString.trim().isEmpty()) {
            int id_cliente = Integer.parseInt(idString);
            Clientes clientes = clientesService.FindClientesById(id_cliente);
    
            if (clientes != null) {
                String message = String.format("ID: %d\nNombre: %s\nApellido: %s\nEmail: %s\nTeléfono: %s\nDirección: %s",
                clientes.getId_cliente(), clientes.getNombre_cliente(), clientes.getApellido_cliente(),
                clientes.getEmail_cliente(), clientes.getTelefono_cliente(), clientes.getId_direccioncliente());
                JOptionPane.showMessageDialog(null, message);
            } else {
                JOptionPane.showMessageDialog(null, "cliente no encontrado.");
            }
        }
    }
    

    private void deleteClientes() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID del clientes que desea eliminar:");
        if (idString != null && !idString.trim().isEmpty()) {
            int id_cliente = Integer.parseInt(idString);
            Clientes clientes = clientesService.FindClientesById(id_cliente);
    
            if (clientes != null) {
                clientesService.DeliteCliente(id_cliente);
                JOptionPane.showMessageDialog(null, "clientes eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "clientes no encontrado.");
            }
        }
    }
}
