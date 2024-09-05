package com.electrishop;

import com.electrishop.menu_principal.infrastructure.out.MenuRepository;

public class Main {
    public static void main(String[] args) {

        // Crear una instancia de la clase Login
        MenuRepository menuRepository = new MenuRepository();
        // Mostrar la ventana del menu principal
        menuRepository.setVisible(true);

        // Ya una vez terminado el programa manda un mensajito
        System.out.println("Programa terminado.");
    }
}