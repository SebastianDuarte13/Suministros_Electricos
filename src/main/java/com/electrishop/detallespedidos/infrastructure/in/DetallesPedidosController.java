package com.electrishop.detallespedidos.infrastructure.in;

import javax.swing.JOptionPane;
import com.electrishop.detallespedidos.application.CreateDetallesPedidosUseCase;
import com.electrishop.detallespedidos.domain.entity.DetallesPedidos;
import com.electrishop.detallespedidos.domain.service.DetallesPedidosService;

public class DetallesPedidosController {
    private CreateDetallesPedidosUseCase createDetallesPedidosUseCase;
    private DetallesPedidosService detallesPedidosService;

    public DetallesPedidosController(CreateDetallesPedidosUseCase createDetallesPedidosUseCase, DetallesPedidosService detallesPedidosService) {
        this.createDetallesPedidosUseCase = createDetallesPedidosUseCase;
        this.detallesPedidosService = detallesPedidosService;
    }

    public void tabla_DetallesPedidos() {
        while (true) {
            String[] options = { "Añadir Detalles de Pedido", "Editar Detalles de Pedido", "Mostrar Detalles de Pedido", "Eliminar Detalles de Pedido", "Salir al menú anterior" };
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Detalles de Pedido", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addDetallesPedidos();
                    break;
                case 1:
                    editaDetallesPedidos();
                    break;
                case 2:
                    searchDetallesPedidos();
                    break;
                case 3:
                    deleteDetallesPedidos();
                    break;
                case 4:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private void addDetallesPedidos() {
        int id_pedido = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del pedido:"));
        int id_producto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del producto:"));
        int cantidad_detalle_pedido = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de detalles del pedido:"));
        int descuento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el descuento:"));
        double precio_detalle_pedido = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del detalle del pedido:"));

        DetallesPedidos detallesPedidos = new DetallesPedidos(id_pedido, id_producto, cantidad_detalle_pedido, descuento, precio_detalle_pedido);
        createDetallesPedidosUseCase.execute(detallesPedidos);
        JOptionPane.showMessageDialog(null, "Detalles de pedido añadidos exitosamente.");
    }

    private void editaDetallesPedidos() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID del detalle de pedido a editar:");
        int id_detalle_pedido = Integer.parseInt(idString);
        DetallesPedidos detallesPedidos = detallesPedidosService.findDetallesPedidosById(id_detalle_pedido);

        if (detallesPedidos != null) {
            int id_pedido = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ID del pedido:", detallesPedidos.getId_pedido()));
            int id_producto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ID del producto:", detallesPedidos.getId_producto()));
            int cantidad_detalle_pedido = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad de detalles del pedido:", detallesPedidos.getCantidad_detalle_pedido()));
            int descuento = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo descuento:", detallesPedidos.getDescuento()));
            double precio_detalle_pedido = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio del detalle del pedido:", detallesPedidos.getPrecio_detalle_pedido()));

            detallesPedidos.setId_pedido(id_pedido);
            detallesPedidos.setId_producto(id_producto);
            detallesPedidos.setCantidad_detalle_pedido(cantidad_detalle_pedido);
            detallesPedidos.setDescuento(descuento);
            detallesPedidos.setPrecio_detalle_pedido(precio_detalle_pedido);

            detallesPedidosService.updateDetallesPedidos(detallesPedidos);
            JOptionPane.showMessageDialog(null, "Detalles de pedido actualizados exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Detalle de pedido no encontrado.");
        }
    }

    private void searchDetallesPedidos() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID del detalle de pedido a buscar:");
        int id_detalle_pedido = Integer.parseInt(idString);
        DetallesPedidos detallesPedidos = detallesPedidosService.findDetallesPedidosById(id_detalle_pedido);

        if (detallesPedidos != null) {
            JOptionPane.showMessageDialog(null, "Detalles del pedido encontrado:\n" +
                "ID Detalle Pedido: " + detallesPedidos.getId_detalle_pedido() + "\n" +
                "ID Pedido: " + detallesPedidos.getId_pedido() + "\n" +
                "ID Producto: " + detallesPedidos.getId_producto() + "\n" +
                "Cantidad: " + detallesPedidos.getCantidad_detalle_pedido() + "\n" +
                "Descuento: " + detallesPedidos.getDescuento() + "\n" +
                "Precio: " + detallesPedidos.getPrecio_detalle_pedido());
        } else {
            JOptionPane.showMessageDialog(null, "Detalle de pedido no encontrado.");
        }
    }

    private void deleteDetallesPedidos() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID del detalle de pedido a eliminar:");
        int id_detalle_pedido = Integer.parseInt(idString);
        detallesPedidosService.deleteDetallesPedidos(id_detalle_pedido);
        JOptionPane.showMessageDialog(null, "Detalles de pedido eliminados exitosamente.");
    }
}
