# Proyecto Control de clientes

El proyecto es un administrador que nos permite visualizar, crear, modificar y eliminar los datos de clientes almacenados en una base de datos
MySQL.

# Dependencias

- JavaEE (Servlet, JSP y EL)
- Stadard TagLib (JSTL)
- JDBC
- MySQL JConnector
- Commons dbcp2 (Pool de conexiones)

# Servidor

Para desarrollar esta aplicación se utilizó el servidor Tomcat 9.0 con la librería de Jconnector de MySQL

# Base de datos

La base de datos es sencilla, consta de una sola tabla Clientes

| CAMPO                | TIPO         | DEFAULT  |
| -------------------- | ------------ | -------- |
| id_cliente (PK, AI)  | INT          | NOT NULL |
| nombre               | VARCHAR(45)  | NULL     |
| apellido             | VARCHAR(45)  | NULL     |
| email                | VARCHAR(45)  | NULL     |
| telefono             | VARCHAR(45)  | NULL     |
| saldo                | DOUBLE       | NULL     |

# Arquitectura

- Acceso a Datos
    - Conexion
    - DAO
        - Interface
        - Implementación
    - Entidad Cliente
- Controlador (Servlet)
    - Servlet
- Vista
    - Páginas JSP
    - Estilo CSS
    - Script JavaScript