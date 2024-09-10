-- Elimina la base de datos si existe
DROP DATABASE IF EXISTS electrishop;

-- Crea la base de datos
CREATE DATABASE electrishop;

-- Usa la base de datos
USE electrishop;

--          TABLAS PRIMARIAS          --

-- Crear tabla categorias
CREATE TABLE categorias (
  id_categoria INT PRIMARY KEY AUTO_INCREMENT,
  nombre_categoria VARCHAR(50)
);

-- Crear tabla pais
CREATE TABLE pais (
  id_pais INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(50)
);

-- Crear tabla direccioncliente
CREATE TABLE direccioncliente (
  id_direccion INT PRIMARY KEY AUTO_INCREMENT,
  direccion VARCHAR(50)
);

-- Crear tabla proveedores
CREATE TABLE proveedores (
  id_proveedor INT PRIMARY KEY AUTO_INCREMENT,
  nombre_proveedor VARCHAR(60),
  apellido_proveedor VARCHAR(60),
  email_proveedor VARCHAR(100),
  telefono_proveedor VARCHAR(15),
  direccion_proveedor TEXT
);

--          TABLAS SECUNDARIAS          --

-- Crear tabla clientes
CREATE TABLE clientes (
  id_cliente INT PRIMARY KEY AUTO_INCREMENT,
  nombre_cliente VARCHAR(60),
  apellido_cliente VARCHAR(60),
  email_cliente VARCHAR(100),
  telefono_cliente VARCHAR(15),
  id_direccioncliente INT,
  FOREIGN KEY (id_direccioncliente) REFERENCES direccioncliente(id_direccion)
);

-- Crear tabla productos
CREATE TABLE productos (
  id_producto INT PRIMARY KEY AUTO_INCREMENT,
  nombre_producto VARCHAR(100),
  descripcion_producto TEXT,
  precio_producto DECIMAL(10, 2),
  id_categoria INT,
  FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria)
);

-- Crear tabla ciudad
CREATE TABLE ciudad (
  id_ciudad INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(50),
  id_pais INT,
  FOREIGN KEY (id_pais) REFERENCES pais(id_pais)
);

-- Crear tabla compra
CREATE TABLE compra (
  id_compra INT PRIMARY KEY AUTO_INCREMENT,
  id_proveedor INT,
  fecha_compra DATE,
  precio_compra INT,
  FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor)
);

-- Crear tabla detalles_compra
CREATE TABLE detalles_compra (
  id_detalles_compra INT PRIMARY KEY AUTO_INCREMENT,
  id_compra INT,
  id_producto INT,
  nombre_compra VARCHAR(50),
  detalles VARCHAR(100),
  cantidad INT,
  precio_unidad INT,
  FOREIGN KEY (id_compra) REFERENCES compra(id_compra),
  FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

-- Crear tabla inventario
CREATE TABLE inventario (
  id_inventario INT PRIMARY KEY AUTO_INCREMENT,
  id_producto INT,
  cantidad_inventario INT,
  fecha_ingreso DATETIME,
  fecha_actualizacion DATETIME,
  FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

-- Crear tabla ventas
CREATE TABLE ventas (
  id_venta INT PRIMARY KEY AUTO_INCREMENT,
  id_cliente INT,
  fecha_venta DATETIME,
  FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

-- Crear tabla detalles_ventas
CREATE TABLE detalles_ventas (
  id_detalle_venta INT PRIMARY KEY AUTO_INCREMENT,
  id_venta INT,
  id_producto INT,
  cantidad_productos INT,
  subprecio DECIMAL(10, 2),
  descuento INT,
  total DECIMAL(10, 2),
  FOREIGN KEY (id_venta) REFERENCES ventas(id_venta),
  FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

-- Crear tabla pedidos
CREATE TABLE pedidos (
  id_pedido INT PRIMARY KEY AUTO_INCREMENT,
  id_cliente INT,
  fecha_pedido DATETIME,
  estado_pedido VARCHAR(20),
  FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente)
);

-- Crear tabla detalles_pedidos
CREATE TABLE detalles_pedidos (
  id_detalle_pedido INT PRIMARY KEY AUTO_INCREMENT,
  id_pedido INT,
  id_producto INT,
  cantidad_detalle_pedido INT,
  descuento INT,
  precio_detalle_pedido DECIMAL(10, 2),
  FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido),
  FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

-- Crear tabla bodega
CREATE TABLE bodega (
  id_bodega INT PRIMARY KEY AUTO_INCREMENT,
  id_inventario INT,
  FOREIGN KEY (id_inventario) REFERENCES inventario(id_inventario)
);

-- Crear tabla sucursal
CREATE TABLE sucursal (
  id_sucursal INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(50),
  direccion VARCHAR(30),
  telefono VARCHAR(20),
  id_ciudad INT,
  id_producto INT,
  FOREIGN KEY (id_ciudad) REFERENCES ciudad(id_ciudad),
  FOREIGN KEY (id_producto) REFERENCES productos(id_producto)
);

-- Crear tabla productoproveedor
CREATE TABLE productoproveedor (
  id_producto INT,
  id_proveedor INT,
  PRIMARY KEY (id_producto, id_proveedor),
  FOREIGN KEY (id_producto) REFERENCES productos(id_producto),
  FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor)
);
