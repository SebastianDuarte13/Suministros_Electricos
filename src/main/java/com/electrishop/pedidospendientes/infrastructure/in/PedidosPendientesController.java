package com.electrishop.pedidospendientes.infrastructure.in;

import java.util.List;
import javax.swing.JOptionPane;
import com.electrishop.pedidospendientes.domain.service.PedidosPendientesService;
import com.electrishop.pedidospendientes.domain.entity.PedidosPendientes;

public class PedidosPendientesController {
    private PedidosPendientesService pedidosPendientesService;

    public PedidosPendientesController(PedidosPendientesService pedidosPendientesService) {
        this.pedidosPendientesService = pedidosPendientesService;
    }

    public void tabla_PedidosPendientes() {
        while (true) {
            String[] options = { "Pedidos Pendientes", "Salir al menú anterior" };
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Pedidos Pendientes",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    mostrarPedidosPendientes();
                    break;
                case 1:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private void mostrarPedidosPendientes() {
        List<PedidosPendientes> pedidosPendientesList = pedidosPendientesService.findAllPedidosPendientes();
        StringBuilder message = new StringBuilder();

        for (PedidosPendientes pedido : pedidosPendientesList) {
            message.append(String.format("Id Pedido: %d\nFecha Pedido: %s\nNombre Cliente: %s\nApellido Cliente: %s\nFecha Pedido: %s\n\n",
                pedido.getId_pedido(),
                pedido.getFecha_pedido(),
                pedido.getNombre_cliente(),
                pedido.getApellido_cliente(),
                pedido.getEstado_pedido()));
        }

        if (message.length() > 0) {
            JOptionPane.showMessageDialog(null, message.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No hay registros para mostrar.");
        }
    }
}
