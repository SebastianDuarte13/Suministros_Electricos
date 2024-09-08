package com.electrishop.pedido.infrastructure.in;

import javax.swing.JOptionPane;
import java.sql.Timestamp;

import com.electrishop.pedido.application.CreatePedidoUseCase;
import com.electrishop.pedido.domain.entity.Pedido;
import com.electrishop.pedido.domain.service.PedidoService;

public class PedidoController {
    private CreatePedidoUseCase createPedidoUseCase;
    private PedidoService pedidoService;

    public PedidoController(CreatePedidoUseCase createPedidoUseCase, PedidoService pedidoService) {
        this.createPedidoUseCase = createPedidoUseCase;
        this.pedidoService = pedidoService;
    }

    // Método principal para mostrar el menú de gestión de pedidos
    public void tabla_Pedido() {
        while (true) {
            String[] options = { "Añadir Pedido", "Editar Pedido", "Mostrar Pedido", "Eliminar Pedido", "Salir" };
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Pedido",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            // Opciones del menú
            switch (choice) {
                case 0:
                    addPedido(); // Añadir un nuevo pedido
                    break;
                case 1:
                    editaPedido(); // Editar un pedido existente
                    break;
                case 2:
                    searchPedido(); // Buscar un pedido
                    break;
                case 3:
                    deletePedido(); // Eliminar un pedido
                    break;
                case 4:
                    return; // Salir del menú
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    // Añadir un nuevo pedido
    private void addPedido() {
        try {
            int id_cliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del cliente:"));
            Timestamp fecha_pedido = Timestamp.valueOf(JOptionPane.showInputDialog("Ingrese la fecha del pedido (YYYY-MM-DD HH:MM:SS):"));
            String estado_pedido = JOptionPane.showInputDialog("Ingrese el estado del pedido:");

            // Validación de los datos
            if (fecha_pedido != null && !estado_pedido.trim().isEmpty()) {
                Pedido pedido = new Pedido(id_cliente, fecha_pedido, estado_pedido);
                createPedidoUseCase.execute(pedido); // Llamada al caso de uso para crear el pedido
                JOptionPane.showMessageDialog(null, "Pedido añadido exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Datos del pedido no válidos.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al añadir el pedido: " + e.getMessage());
        }
    }

    // Editar un pedido existente
    private void editaPedido() {
        try {
            String idString = JOptionPane.showInputDialog("Ingrese el ID del pedido que desea editar:");
            if (idString != null && !idString.trim().isEmpty()) {
                int id_pedido = Integer.parseInt(idString);
                Pedido pedido = pedidoService.FindPedidoById(id_pedido); // Buscar el pedido por ID

                if (pedido != null) {
                    // Actualizar los valores del pedido
                    int id_cliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ID del cliente:", pedido.getId_cliente()));
                    Timestamp fecha_pedido = Timestamp.valueOf(JOptionPane.showInputDialog("Ingrese la nueva fecha del pedido (YYYY-MM-DD HH:MM:SS):", pedido.getFecha_pedido()));
                    String estado_pedido = JOptionPane.showInputDialog("Ingrese el nuevo estado del pedido:", pedido.getEstado_pedido());

                    // Setear los nuevos valores
                    pedido.setId_cliente(id_cliente);
                    pedido.setFecha_pedido(fecha_pedido);
                    pedido.setEstado_pedido(estado_pedido);

                    pedidoService.UpdatePedido(pedido); // Actualizar el pedido
                    JOptionPane.showMessageDialog(null, "Pedido actualizado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Pedido no encontrado.");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al editar el pedido: " + e.getMessage());
        }
    }

    // Buscar un pedido por su ID
    private void searchPedido() {
        try {
            String idString = JOptionPane.showInputDialog("Ingrese el ID del pedido que desea buscar:");
            if (idString != null && !idString.trim().isEmpty()) {
                int id_pedido = Integer.parseInt(idString);
                Pedido pedido = pedidoService.FindPedidoById(id_pedido); // Buscar el pedido

                if (pedido != null) {
                    String mensaje = String.format("ID: %d\nID cliente: %d\nFecha del pedido: %s\nEstado: %s",
                            pedido.getId_pedido(),
                            pedido.getId_cliente(),
                            pedido.getFecha_pedido(),
                            pedido.getEstado_pedido());
                    JOptionPane.showMessageDialog(null, mensaje);
                } else {
                    JOptionPane.showMessageDialog(null, "Pedido no encontrado.");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el pedido: " + e.getMessage());
        }
    }

    // Eliminar un pedido
    private void deletePedido() {
        try {
            String idString = JOptionPane.showInputDialog("Ingrese el ID del pedido que desea eliminar:");
            if (idString != null && !idString.trim().isEmpty()) {
                int id_pedido = Integer.parseInt(idString);
                Pedido pedido = pedidoService.FindPedidoById(id_pedido); // Buscar el pedido

                if (pedido != null) {
                    pedidoService.DeletePedido(id_pedido); // Eliminar el pedido
                    JOptionPane.showMessageDialog(null, "Pedido eliminado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Pedido no encontrado.");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el pedido: " + e.getMessage());
        }
    }
}
