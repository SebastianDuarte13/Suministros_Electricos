package com.electrishop.reportes.domain.entity;

import java.math.BigDecimal;
import java.sql.Date;

public class Reportes {
    // agragamos las variables queexisten en la base de datos
    // Clientes
    private int id_cliente;
    private String nombre_cliente;
    private String apellido_cliente;
    private String email_cliente;
    private String telefono_cliente;
    private int id_direccioncliente;

    // Ventas
    private int id_venta;
    private Date fecha_venta;

    // Productos
    private int id_producto;
    private String nombre_producto;
    private String descripcion_producto;
    private BigDecimal precio_producto;
    private int id_categoria;

    // agregamos un constructor
    public Reportes(int id_cliente, String nombre_cliente, String apellido_cliente, String email_cliente,
            String telefono_cliente, int id_direccioncliente, int id_venta, Date fecha_venta, int id_producto,
            String nombre_producto, String descripcion_producto, BigDecimal precio_producto, int id_categoria) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
        this.email_cliente = email_cliente;
        this.telefono_cliente = telefono_cliente;
        this.id_direccioncliente = id_direccioncliente;
        this.id_venta = id_venta;
        this.fecha_venta = fecha_venta;
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.descripcion_producto = descripcion_producto;
        this.precio_producto = precio_producto;
        this.id_categoria = id_categoria;
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

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public BigDecimal getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(BigDecimal precio_producto) {
        this.precio_producto = precio_producto;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
}
