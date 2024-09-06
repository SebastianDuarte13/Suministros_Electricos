package com.electrishop.proveedor.infrastructure.in;

import java.text.SimpleDateFormat;
import java.util.Locale.Category;

import javax.swing.JOptionPane;

import com.electrishop.proveedor.application.CreateProveedoresUseCase;
import com.electrishop.proveedor.domain.service.ProveedoresService;

public class ProveedoresController {
    private CreateProveedoresUseCase createProveedoresUseCase;
    private ProveedoresService proveedoresService;

    public ProveedoresController(CreateProveedoresUseCase createProveedoresUseCase,
            ProveedoresService proveedoresService) {
        this.createProveedoresUseCase = createProveedoresUseCase;
        this.proveedoresService = proveedoresService;
    }

    public void tabla_category() {
        while (true) {
            String[] options = { "Añadir categoría", "Editar categoría", "Mostrar categoría", "Eliminar categoría",
                    "Salir al menú anterior" };
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Categorías",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    //addCategory();
                    break;
                case 1:
                    //editCategory();
                    break;
                case 2:
                    //searchCategory();
                    break;
                case 3:
                    //deleteCategory();
                    break;
                case 4:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    
    
}
