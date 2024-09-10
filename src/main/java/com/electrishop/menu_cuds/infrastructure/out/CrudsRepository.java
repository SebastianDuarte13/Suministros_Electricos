/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.electrishop.menu_cuds.infrastructure.out;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

// importaciones de tabla categoria
import com.electrishop.categorias.application.CreateCategoriaUseCase;
import com.electrishop.categorias.domain.service.CategoriaService;
import com.electrishop.categorias.infrastructure.out.CategoriaRepository;
import com.electrishop.categorias.infrastructure.in.CategoriaController;

//importaciones tabla paises
import com.electrishop.pais.application.CreatePaisUseCase;
import com.electrishop.pais.domain.service.PaisService;
import com.electrishop.pais.infrastructure.out.PaisRepository;
import com.electrishop.pais.infrastructure.in.PaisController;

//importaciones tabla direccion clientes
import com.electrishop.direccioncliente.application.CreateDireccionUseCase;
import com.electrishop.direccioncliente.domain.service.DireccionService;
import com.electrishop.direccioncliente.infrastructure.out.DireccionRepository;
import com.electrishop.direccioncliente.infrastructure.in.DireccionController;

// importaciones tabla proveedores
import com.electrishop.proveedor.application.CreateProveedoresUseCase;
import com.electrishop.proveedor.domain.service.ProveedoresService;
import com.electrishop.proveedor.infrastructure.in.ProveedoresController;
import com.electrishop.proveedor.infrastructure.out.ProveedoresRepository;

//importaciones tabla clientes
import com.electrishop.clientes.application.CreateClientesUseCase;
import com.electrishop.clientes.domain.service.ClientesService;
import com.electrishop.clientes.infrastructure.in.ClientesController;
import com.electrishop.clientes.infrastructure.out.ClientesRepository;

//importaciones tabla Productos
import com.electrishop.productos.application.CreateProductosUseCase;
import com.electrishop.productos.domain.service.ProductosService;
import com.electrishop.productos.infrastructure.in.ProductosController;
import com.electrishop.productos.infrastructure.out.ProductosRepository;

//importaciones tabla Productos
import com.electrishop.ciudad.application.CreateCiudadUseCase;
import com.electrishop.ciudad.domain.service.CiudadService;
import com.electrishop.ciudad.infrastructure.in.CiudadController;
import com.electrishop.ciudad.infrastructure.out.CiudadRepository;

//importaciones tabla compra 
import com.electrishop.compra.application.CreateCompraUseCase;
import com.electrishop.compra.domain.service.CompraService;
import com.electrishop.compra.infrastructure.in.CompraController;
import com.electrishop.compra.infrastructure.out.CompraRepository;

//importaciones tabla Detalles compra
import com.electrishop.detallescompra.application.CreateDetallesCompraUseCase;
import com.electrishop.detallescompra.domain.service.DetallesCompraService;
import com.electrishop.detallescompra.infrastructure.in.DetallesCompraController;
import com.electrishop.detallescompra.infrastructure.out.DetallesCompraRepository;

// importaciones tabla pedidos
import com.electrishop.pedido.application.CreatePedidoUseCase;
import com.electrishop.pedido.domain.service.PedidoService;
import com.electrishop.pedido.infrastructure.out.PedidoRepository;
import com.electrishop.pedido.infrastructure.in.PedidoController;

//importaciones tabla inventario

import com.electrishop.inventario.application.CreateInventarioUseCase;
import com.electrishop.inventario.domain.service.InventarioService;
import com.electrishop.inventario.infrastructure.in.InventarioController;
import com.electrishop.inventario.infrastructure.out.InventarioRepository;

// imporaciones tabla bodega
import com.electrishop.bodega.application.CreateBodegaUseCase;
import com.electrishop.bodega.domain.service.BodegaService;
import com.electrishop.bodega.infrastructure.in.BodegaController;
import com.electrishop.bodega.infrastructure.out.BodegaRepository;

// importaciones tabla ventas

import com.electrishop.ventas.application.CreateVentaUseCase;
import com.electrishop.ventas.infrastructure.in.VentaController;
import com.electrishop.ventas.infrastructure.out.VentaRepository;

// importaciones tabla detalles ventas
import com.electrishop.detallesventas.application.CreateDetallesVentasUseCase;
import com.electrishop.detallesventas.domain.service.DetallesVentasService;
import com.electrishop.detallesventas.infrastructure.in.DetallesVentasController;
import com.electrishop.detallesventas.infrastructure.out.DetallesVentasRepository;

// importaciones tabla detalles pedidos 
import com.electrishop.detallespedidos.domain.service.DetallesPedidosService;
import com.electrishop.detallespedidos.infrastructure.out.DetallesPedidosRepository;
import com.electrishop.detallespedidos.application.CreateDetallesPedidosUseCase;
import com.electrishop.detallespedidos.infrastructure.in.DetallesPedidosController;

// importaciones tabla sucursal 
import com.electrishop.sucursal.application.CreateSucursalUseCase;
import com.electrishop.sucursal.domain.service.SucursalService;
import com.electrishop.sucursal.infrastructure.out.SucursalRepository;
import com.electrishop.sucursal.infrastructure.in.SucursalController;

// importaciones tabla producto proveedor
import com.electrishop.productoproveedor.application.CreateProductoProveedorUseCase;
import com.electrishop.productoproveedor.domain.service.ProductoProveedorService;
import com.electrishop.productoproveedor.infrastructure.out.ProductoProveedorRepository;
import com.electrishop.productoproveedor.infrastructure.in.ProductoProveedorController;

/**
 *
 * @author Sebastian Duarte
 */
public class CrudsRepository extends javax.swing.JPanel {

    /**
     * Creates new form CrudsRepository
     */
    public CrudsRepository() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("")
    // unchecked
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();

        setBackground(new java.awt.Color(205, 234, 234));

        jLabel1.setFont(new java.awt.Font("Algerian", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Modo CRUD");

        jButton1.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Categorias");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("paises");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        jButton3.setText("direccion cliente");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        jButton4.setText("proveedores");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        jButton5.setText("clientes");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        jButton6.setText("Productos");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        jButton7.setText("Ciudad");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        jButton8.setText("Compra");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        jButton9.setText("Detalles Compra");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        jButton10.setText("Pedidos");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        jButton11.setText("inventario");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(255, 0, 0));
        jButton12.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Regresar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        jButton13.setText("Ventas");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        jButton14.setText("Detalles Ventas");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        jButton15.setText("bodega");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        jButton16.setText("detalles pedidos");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        jButton17.setText("sucursal");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setFont(new java.awt.Font("Yu Gothic UI", 3, 14)); // NOI18N
        jButton18.setText("roduct proveedo");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(60, 60, 60))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButton12)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton13ActionPerformed
        VentaRepository ventaRepository = new VentaRepository();
        CreateVentaUseCase createVentaUseCase = new CreateVentaUseCase(ventaRepository);
        VentaController ventaController = new VentaController(createVentaUseCase, ventaRepository);

        ventaController.tabla_Ventas();
        // ventas
    }// GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton14ActionPerformed
        // Crear instancias del repositorio y servicio
        DetallesVentasRepository detallesVentasRepository = new DetallesVentasRepository();
        DetallesVentasService detallesVentasService = detallesVentasRepository;

        // Crear caso de uso
        CreateDetallesVentasUseCase createDetallesVentasUseCase = new CreateDetallesVentasUseCase(
                detallesVentasService);

        // Crear controlador
        DetallesVentasController detallesVentasController = new DetallesVentasController(createDetallesVentasUseCase,
                detallesVentasService);

        // Mostrar menú
        detallesVentasController.tabla_DetallesVentas();
        // detalles venta
    }// GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton15ActionPerformed
        // bodega
        // Instancia del repositorio
        BodegaService bodegaService = new BodegaRepository();

        // Caso de uso para crear bodegas
        CreateBodegaUseCase createBodegaUseCase = new CreateBodegaUseCase(bodegaService);

        // Controlador que maneja las interacciones
        BodegaController bodegaController = new BodegaController(createBodegaUseCase, bodegaService);

        // Mostrar menú de gestión de bodegas
        bodegaController.tabla_Bodega();
    }// GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton16ActionPerformed
        // detalles pedidos
        // Inicialización del repositorio
        DetallesPedidosService detallesPedidosRepository = new DetallesPedidosRepository();

        // Inicialización del caso de uso
        CreateDetallesPedidosUseCase createDetallesPedidosUseCase = new CreateDetallesPedidosUseCase(
                detallesPedidosRepository);

        // Inicialización del controlador
        DetallesPedidosController detallesPedidosController = new DetallesPedidosController(
                createDetallesPedidosUseCase, detallesPedidosRepository);

        // Mostrar el menú para gestionar detalles de pedidos
        detallesPedidosController.tabla_DetallesPedidos();
    }// GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton17ActionPerformed
        // sucursal
        SucursalService sucursalService = new SucursalRepository();
        CreateSucursalUseCase createSucursalUseCase = new CreateSucursalUseCase(sucursalService);
        SucursalController sucursalController = new SucursalController(createSucursalUseCase, sucursalService);

        sucursalController.tabla_Sucursal();
    }// GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton18ActionPerformed
        // productoproveedor
        ProductoProveedorService productoProveedorService = new ProductoProveedorRepository();
        CreateProductoProveedorUseCase createProductoProveedorUseCase = new CreateProductoProveedorUseCase(productoProveedorService);
        ProductoProveedorController productoProveedorController = new ProductoProveedorController(createProductoProveedorUseCase, productoProveedorService);

        productoProveedorController.tabla_ProductoProveedor();
    }// GEN-LAST:event_jButton18ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        // categorias
        // Crear las dependencias necesarias
        CategoriaService categoriaService = new CategoriaRepository(); // Repositorio que implementa el servicio
        CreateCategoriaUseCase createCategoriaUseCase = new CreateCategoriaUseCase(categoriaService);

        // Crear el controlador y pasarle el caso de uso
        CategoriaController categoriaController = new CategoriaController(createCategoriaUseCase, categoriaService);

        // Iniciar la interacción con el usuario
        categoriaController.tabla_RespondeQuestion();
    }// GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton6ActionPerformed
        // detalles_compra
        // Crear las dependencias necesarias
        ProductosService productosService = new ProductosRepository(); // Repositorio que implementa el servicio
        CreateProductosUseCase createProductosUseCase = new CreateProductosUseCase(productosService);

        // Crear el controlador y pasarle el caso de uso
        ProductosController productosController = new ProductosController(createProductosUseCase, productosService);

        // Iniciar la interacción con el usuario
        productosController.tabla_Productos();
    }// GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        // boton tabla paises

        // // Crear las dependencias necesarias
        PaisService paisService = new PaisRepository(); // Repositorio que implementa el servicio
        CreatePaisUseCase createPaisUseCase = new CreatePaisUseCase(paisService);

        // Crear el controlador y pasarle el caso de uso
        PaisController paisController = new PaisController(createPaisUseCase);

        // Iniciar la interacción con el usuario
        paisController.tabla_pais();
    }// GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
        // direccion cliente
        // // Crear las dependencias necesarias
        DireccionService direccionService = new DireccionRepository(); // Repositorio que implementa el servicio
        CreateDireccionUseCase createDireccionUseCase = new CreateDireccionUseCase(direccionService);

        // Crear el controlador y pasarle el caso de uso
        DireccionController direccionController = new DireccionController(createDireccionUseCase);

        // Iniciar la interacción con el usuario
        direccionController.tabla_direccioncliente();
    }// GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
        // Crear la instancia del repositorio que maneja la base de datos
        ProveedoresService proveedoresService = new ProveedoresRepository();

        // Crear el caso de uso para crear proveedores
        CreateProveedoresUseCase createProveedoresUseCase = new CreateProveedoresUseCase(proveedoresService);

        // Crear el controlador que maneja la lógica de interacción con el usuario
        ProveedoresController proveedoresController = new ProveedoresController(createProveedoresUseCase,
                proveedoresService);

        // Iniciar el controlador
        proveedoresController.tabla_proveedor();
        // productos
    }// GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton5ActionPerformed
        // Crear la instancia del repositorio que maneja la base de datos
        ClientesService clientesService = new ClientesRepository();

        // Crear el caso de uso para crear proveedores
        CreateClientesUseCase createClientesUseCase = new CreateClientesUseCase(clientesService);

        // Crear el controlador que maneja la lógica de interacción con el usuario
        ClientesController clientesController = new ClientesController(createClientesUseCase, clientesService);

        // Iniciar el controlador
        clientesController.tabla_Clientes();
        // clientes
    }// GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton7ActionPerformed
        // ciudad
        // Crear las dependencias necesarias
        CiudadService ciudadService = new CiudadRepository(); // Repositorio que implementa el servicio
        CreateCiudadUseCase createCiudadUseCase = new CreateCiudadUseCase(ciudadService);

        // Crear el controlador y pasarle el caso de uso
        CiudadController ciudadController = new CiudadController(createCiudadUseCase, ciudadService);

        // Iniciar la interacción con el usuario
        ciudadController.tabla_Ciudad();
    }// GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton8ActionPerformed
        // compra
        CompraService compraService = new CompraRepository(); // Implementación del repositorio
        CreateCompraUseCase createCompraUseCase = new CreateCompraUseCase(compraService); // Caso de uso

        // Crear el controlador de compra
        CompraController compraController = new CompraController(createCompraUseCase, compraService);

        // Mostrar el menú de gestión de compras
        compraController.tabla_Compra(); // Inicia el menú
    }// GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton9ActionPerformed
        // detalles_compra
        // Crear las instancias necesarias para el flujo de la aplicación
        DetallesCompraService detallesCompraService = new DetallesCompraRepository(); // Implementación del repositorio
        CreateDetallesCompraUseCase createDetallesCompraUseCase = new CreateDetallesCompraUseCase(
                detallesCompraService); // Caso de uso

        // Crear el controlador de detalles de compra
        DetallesCompraController detallesCompraController = new DetallesCompraController(createDetallesCompraUseCase,
                detallesCompraService);

        // Mostrar el menú de gestión de detalles de compra
        detallesCompraController.tabla_DetallesCompra(); // Inicia el menú
    }// GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton10ActionPerformed
        // pedidos
        // Crear instancia del repositorio que maneja la persistencia
        PedidoService pedidoService = new PedidoRepository();

        // Crear el caso de uso que utiliza el servicio para operaciones CRUD
        CreatePedidoUseCase createPedidoUseCase = new CreatePedidoUseCase(pedidoService);

        // Crear el controlador que interactúa con el usuario
        PedidoController pedidoController = new PedidoController(createPedidoUseCase, pedidoService);

        // Mostrar el menú de gestión de pedidos
        pedidoController.tabla_Pedido();
    }// GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton11ActionPerformed
        // inventario
        // Crear instancias de los componentes necesarios
        InventarioService inventarioService = new InventarioRepository();
        CreateInventarioUseCase createInventarioUseCase = new CreateInventarioUseCase(inventarioService);

        // Crear el controlador de inventario
        InventarioController inventarioController = new InventarioController(createInventarioUseCase,
                inventarioService);

        // Mostrar el menú de gestión de inventario
        inventarioController.tabla_Inventario();
    }// GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton12ActionPerformed
        // Get the parent frame or dialog
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        // Close the frame or dialog
        frame.dispose();
    }// GEN-LAST:event_jButton12ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
