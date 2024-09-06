package com.electrishop.categorias.infrastructure.in;

import javax.swing.JOptionPane;
import com.electrishop.categorias.application.CreateCategoriaUseCase;
import com.electrishop.categorias.domain.entity.Categoria;
import com.electrishop.categorias.domain.service.CategoriaService;

public class CategoriaController {
    // Este controlador inicializa los casos de uso y servicios necesarios. Luego,
    // en el método tabla_RespondeQuestion, muestra un menú con opciones para añadir
    // una categoría o regresar. Si el usuario elige añadir una categoría, llama al
    // método CrearCategoria(), y si elige regresar, sale del bucle.
    private CreateCategoriaUseCase createCategoriaUseCase;

    public CategoriaController(CreateCategoriaUseCase createCategoriaUseCase, CategoriaService categoriaService) {
        this.createCategoriaUseCase = createCategoriaUseCase;
    }

    public void tabla_RespondeQuestion() {
        while (true) {
            String[] options = { "Añadir Categoria", "Regresar al menu anterior" };
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Usuarios",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    CrearCategoria();
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
    private void CrearCategoria() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la categoria:");

        if (nombre != null && !nombre.trim().isEmpty()) {
            Categoria categoria = new Categoria(nombre);
            createCategoriaUseCase.execute(categoria); // Pasando el objeto Categoria
            JOptionPane.showMessageDialog(null, "Categoría añadida exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Datos de la categoría no válidos.");
        }
    }

}
