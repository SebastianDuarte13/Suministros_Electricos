package com.electrishop.ciudad.infrastructure.in;

import javax.swing.JOptionPane;

import com.electrishop.ciudad.application.CreateCiudadUseCase;
import com.electrishop.ciudad.domain.entity.Ciudad;
import com.electrishop.ciudad.domain.service.CiudadService;

public class CiudadController {
    private CreateCiudadUseCase createCiudadUseCase;
    private CiudadService ciudadService;
    public CiudadController(CreateCiudadUseCase createCiudadUseCase, CiudadService ciudadService) {
        this.createCiudadUseCase = createCiudadUseCase;
        this.ciudadService = ciudadService;
    }

    // el menu visual lo creamos

    public void tabla_Ciudad() {
        while (true) {
            String[] options = { "Añadir Ciudad", "Editar Ciudad", "Mostrar Ciudad", "Eliminar Ciudad",
                    "Salir al menú anterior" };
            int choice = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Gestión de Ciudad",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    addCiudad();
                    break;
                case 1:
                    editaCiudad();
                    break;
                case 2:
                    searchCiudad();
                    break;
                case 3:
                    deleteCiudad();
                    break;
                case 4:
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }


    // esto es lo que se le mostrara al usuario cuando desee agragar una ciudad, que sera preguntas y almacenacion de datos
    private void addCiudad() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la ciudad:");
        int id_pais = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del país:"));
    
        if (nombre != null && id_pais != 0) {
            Ciudad ciudad = new Ciudad(0, nombre, id_pais); // El ID de la ciudad será 0 (autoincrementado en la base de datos)
            createCiudadUseCase.execute(ciudad);
            JOptionPane.showMessageDialog(null, "Ciudad añadida exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Datos de la ciudad no válidos.");
        }
    }
    
    // esto es lo que se le mostrara al usuario cuando desee editar una ciudad, que sera preguntas y sobreescribir de datos
    private void editaCiudad() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID de la ciudad que desea editar:");
        if (idString != null && !idString.trim().isEmpty()) {
            int id_ciudad = Integer.parseInt(idString);
            Ciudad ciudad = ciudadService.FindCiudadById(id_ciudad);
    
            if (ciudad != null) {
                String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre de la ciudad:", ciudad.getNombre());
                int nuevoIdPais = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo ID del país:", ciudad.getId_pais()));
    
                if (nuevoNombre != null && nuevoIdPais != 0) {
                    ciudad.setNombre(nuevoNombre);
                    ciudad.setId_pais(nuevoIdPais);
                    ciudadService.UpdateCiudad(ciudad);
                    JOptionPane.showMessageDialog(null, "Ciudad editada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Datos de la ciudad no válidos.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ciudad no encontrada.");
            }
        }
    }
    
    
    // esto es lo que se le mostrara al usuario cuando desee buscar una ciudad, que sera preguntar cual es el id que desea y mostrara los datos
    private void searchCiudad() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID de la ciudad que desea buscar:");
        if (idString != null && !idString.trim().isEmpty()) {
            int id_ciudad = Integer.parseInt(idString);
            Ciudad ciudad = ciudadService.FindCiudadById(id_ciudad);
    
            if (ciudad != null) {
                String message = String.format("ID: %d\nNombre: %s\nID País: %d",
                    ciudad.getId_ciudad(), ciudad.getNombre(), ciudad.getId_pais());
                JOptionPane.showMessageDialog(null, message);
            } else {
                JOptionPane.showMessageDialog(null, "Ciudad no encontrada.");
            }
        }
    }
    
    // esto es lo que se le mostrara al usuario cuando desee eliminar una ciudad, que preguntara el id y prreviamente eliminara los datos

    private void deleteCiudad() {
        String idString = JOptionPane.showInputDialog("Ingrese el ID de la ciudad que desea eliminar:");
        if (idString != null && !idString.trim().isEmpty()) {
            int id_ciudad = Integer.parseInt(idString);
            Ciudad ciudad = ciudadService.FindCiudadById(id_ciudad);

            if (ciudad != null) {
                ciudadService.DeleteCiudad(id_ciudad);       
                JOptionPane.showMessageDialog(null, "productos eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "productos no encontrado.");
            }
        }
    }
}
