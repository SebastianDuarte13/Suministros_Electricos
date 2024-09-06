package com.electrishop.proveedor.domain.entity;

public class Proveedores {
    private int id_proveedor;
    private String nombre_proveedor;
    private String apellido_proveedor;
    private String email_proveedor;
    private String telefono_proveedor;
    private String direccion_proveedor;

    public Proveedores(String nombre_proveedor, String apellido_proveedor, String email_proveedor,
            String telefono_proveedor, String direccion_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
        this.apellido_proveedor = apellido_proveedor;
        this.email_proveedor = email_proveedor;
        this.telefono_proveedor = telefono_proveedor;
        this.direccion_proveedor = direccion_proveedor;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getApellido_proveedor() {
        return apellido_proveedor;
    }

    public void setApellido_proveedor(String apellido_proveedor) {
        this.apellido_proveedor = apellido_proveedor;
    }

    public String getEmail_proveedor() {
        return email_proveedor;
    }

    public void setEmail_proveedor(String email_proveedor) {
        this.email_proveedor = email_proveedor;
    }

    public String getTelefono_proveedor() {
        return telefono_proveedor;
    }

    public void setTelefono_proveedor(String telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }

    public String getDireccion_proveedor() {
        return direccion_proveedor;
    }

    public void setDireccion_proveedor(String direccion_proveedor) {
        this.direccion_proveedor = direccion_proveedor;
    }

    

    

}
