package com.electrishop.pais.infrastructure.in;

import javax.swing.JOptionPane;

import com.electrishop.pais.application.CreatePaisUseCase;
import com.electrishop.pais.domain.entity.Pais;

public class PaisController {
    // Este controlador inicializa los casos de uso y servicios necesarios. Luego,
    // en el método tabla_pais, muestra un menú con opciones para añadir
    // una categoría o regresar. Si el usuario elige añadir una categoría, llama al
    // método createPaisUseCase(), y si elige regresar, sale del bucle.
    private CreatePaisUseCase createPaisUseCase;

    public PaisController(CreatePaisUseCase createPaisUseCase) {
        this.createPaisUseCase = createPaisUseCase;
    }

    public void tabla_pais() {
        while (true) {
            String[] options = { "Añadir pais", "Regresar al menu anterior" };
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Usuarios",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    CrearPais();
                    break;

                case 1:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
        
    }
    // Este método pide al usuario ingresar el nombre de una categoría mediante un
    // cuadro de diálogo, crea una instancia de Categoria con el nombre ingresado y
    // luego utiliza el caso de uso createCategoriaUseCase para añadirla a la base
    // de datos. Si el nombre es inválido, muestra un mensaje de error.
    private void CrearPais() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del pais:");

        if (nombre != null && !nombre.trim().isEmpty()) {
            Pais pais = new Pais(nombre);
            createPaisUseCase.execute(pais); // Pasando el objeto Categoria
            JOptionPane.showMessageDialog(null, "pais añadida exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Datos del pais no válidos.");
        }
    }
}
