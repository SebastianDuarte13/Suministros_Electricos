package com.electrishop.direccioncliente.infrastructure.in;


import javax.swing.JOptionPane;

import com.electrishop.direccioncliente.application.CreateDireccionUseCase;
import com.electrishop.direccioncliente.domain.entity.Direccion;

public class DireccionController {
    // Este controlador inicializa los casos de uso y servicios necesarios. Luego,
    // en el método tabla_direccioncliente, muestra un menú con opciones para añadir
    // una categoría o regresar. Si el usuario elige añadir una categoría, llama al
    // método createDireccionUseCase(), y si elige regresar, sale del bucle.
    private CreateDireccionUseCase createDireccionUseCase;

    public DireccionController(CreateDireccionUseCase createDireccionUseCase) {
        this.createDireccionUseCase = createDireccionUseCase;
    }

    public void tabla_direccioncliente() {
        while (true) {
            String[] options = { "Añadir tabla_direccioncliente", "Regresar al menu anterior" };
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Usuarios",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    CrearDireccioncliente();
                    break;

                case 1:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }
    // Este método pide al usuario ingresar la direccion de una categoría mediante un
    // cuadro de diálogo, crea una instancia de direccion con la direccion ingresado y
    // luego utiliza el caso de uso createDireccionUseCase para añadirla a la base
    // de datos. Si la direccion es inválido, muestra un mensaje de error.
    private void CrearDireccioncliente() {
        String direccin = JOptionPane.showInputDialog("Ingrese el nombre de la categoria:");

        if (direccin != null && !direccin.trim().isEmpty()) {
            Direccion direccion = new Direccion(direccin);
            createDireccionUseCase.execute(direccion); // Pasando el objeto Categoria
            JOptionPane.showMessageDialog(null, "Categoría añadida exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Datos de la categoría no válidos.");
        }
    }
}
