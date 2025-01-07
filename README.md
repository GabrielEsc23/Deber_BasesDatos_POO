# Proyecto: Sistema de Visualización de Base de Datos de Estudiantes y Personal Administrativo

Este proyecto es una aplicación de escritorio desarrollada en Java que permite a los usuarios visualizar y gestionar una base de datos que contiene información de estudiantes y personal administrativo. El sistema incluye una interfaz de login para la autenticación de usuarios y una ventana principal donde se muestran los datos almacenados en la base de datos.

## Características Principales
- **Login Seguro**: Permite a los usuarios autenticarse utilizando un nombre de usuario y contraseña.
- **Visualización de Datos**: Muestra los registros de la base de datos en una tabla con columnas para ID, nombre, grupo, usuario y contraseña.
- **Conexión a Base de Datos**: Utiliza JDBC para conectarse a una base de datos MySQL.
- **Interfaz Intuitiva**: Diseñada para ser fácil de usar y comprender.

## Tecnologías Utilizadas
- **Lenguaje**: Java 
- **Bibliotecas**:
  - `Swing` para la interfaz gráfica.
  .
- **Base de Datos**: MySQL

## Requisitos Previos
1. Tener instalado Java.
2. MySQL instalado y configurado.
3. Una base de datos llamada `bd_ins` con la siguiente estructura:
4. ![Captura de Login](https://raw.githubusercontent.com/GabrielEsc23/Deber_BasesDatos_POO/master/capturaLogin.png)


```

## Capturas de Pantalla

## Pantalla de Login
**Descripción:** Permite a los usuarios ingresar sus credenciales.
![Captura de Login](https://raw.githubusercontent.com/GabrielEsc23/Deber_BasesDatos_POO/master/capturaLogin.png)



### Pantalla Principal
**Descripción:** Muestra los registros almacenados en la base de datos.
![Captura Estudiantes](https://raw.githubusercontent.com/usuario/repositorio/main/capturaEstudiantes.png)

## Instalación y Ejecución

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu-usuario/tu-repositorio.git
   ```

2. Importa el proyecto en tu IDE (Eclipse, IntelliJ, etc.).

3. Configura la conexión a la base de datos en las clases `login` y `Ventana`:
   ```java
   Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_ins", "root", "");
   ```

4. Ejecuta la clase `Main` para iniciar la aplicación.

## Estructura del Proyecto
- **Main.java**: Punto de entrada de la aplicación.
- **login.java**: Maneja la autenticación del usuario.
- **Ventana.java**: Muestra los datos de la base de datos.

## Futuros Mejoras
- Agregar funcionalidades para insertar, editar y eliminar registros.
- Implementar diferentes niveles de acceso para estudiantes y administradores.
- Mejorar el diseño de la interfaz.

## Licencia
Este proyecto está licenciado bajo la [MIT License](https://opensource.org/licenses/MIT).

