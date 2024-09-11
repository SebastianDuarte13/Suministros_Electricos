package com.electrishop.clientes.domain.entity;

public class Clientes {
    // agragamos las variables queexisten en la base de datos
    private int id_cliente;
    private String nombre_cliente;
    private String apellido_cliente;
    private String email_cliente;
    private String telefono_cliente;
    private int id_direccioncliente;

    // agregamos un constructor
    public Clientes(String nombre_cliente, String apellido_cliente, String email_cliente, String telefono_cliente,
            int id_direccioncliente) {
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.email_cliente = email_cliente;
        this.telefono_cliente = telefono_cliente;
        this.id_direccioncliente = id_direccioncliente;
    }

    // hacemos los metodos getter y setter
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApellido_cliente() {
        return apellido_cliente;
    }

    public void setApellido_cliente(String apellido_cliente) {
        this.apellido_cliente = apellido_cliente;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public String getTelefono_cliente() {
        return telefono_cliente;
    }

    public void setTelefono_cliente(String telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }

    public int getId_direccioncliente() {
        return id_direccioncliente;
    }

    public void setId_direccioncliente(int id_direccioncliente) {
        this.id_direccioncliente = id_direccioncliente;
    }

}
