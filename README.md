
# Aplicacion android con consumo Api

ProyectoFinal1 es una aplicación móvil desarrollada en Kotlin para dispositivos Android, que permite registrar, consultar y almacenar información de estuduantes (ID, nombre, nombre del programa académico y nota final).
La app se conecta a una API desarrollada en C# con el modelo MVC y utiliza una base de datos SQL Server para persistencia remota.
Además, implementa Room para el almacenamiento local, lo que permite acceder a los datos sin conexión a internet y sincronizar automáticamente cuando se restablece la conectividad.

## Requisitos para ejecutar la API (C# + ASP.NET Core MVC)

#### Requisitos del sistema

Requisitos del sistema
Sistema operativo: Windows 10/11 o superior

RAM: Mínimo 4 GB

.NET SDK: .NET 6.0 o superior

SQL Server: SQL Server 2019 o superior (puede ser Express)

Visual Studio: Visual Studio 2022 con el paquete ASP.NET y desarrollo web

## Acceso a la documentación con Swagger

Esta API incluye Swagger incorporado, lo que permite visualizar y probar todos los endpoints desde una interfaz web amigable.

🔗 Swagger UI disponible en:
https://localhost:7096/swagger/index.html

Desde esta interfaz puedes:

Consultar todas las rutas disponibles (GET, POST, PUT, DELETE)

Ver los modelos utilizados (EstudianteDto, Nota)

Probar las solicitudes sin usar Postman

Ver ejemplos de respuestas en tiempo real

## Estructura de las Tablas
1. dbo.Admins
Esta tabla almacena la información del usuario administrador del sistema.

Columnas:

id (PK, int, Not Null): Identificador único del administrador. Es la clave primaria.

nombre (varchar(100), Not Null): Nombre completo del administrador.

correo (varchar(255), Not Null): Dirección de correo electrónico del administrador (probable campo de login/contacto).

contrasena (varchar(100), Not Null): Contraseña del administrador (se recomienda almacenar un hash de la contraseña, no el texto plano).

2. dbo.Estudiante
Esta tabla contiene la información básica de los estudiantes.

Descripción: Almacena los datos personales y académicos clave de cada estudiante.

Columnas:

id_estudiante (PK, int, Not Null): Identificador único del estudiante. Es la clave primaria.

nombre_estudiante (varchar(100), Not Null): Nombre completo del estudiante.

programa_estudiante (varchar(100), Not Null): Programa o carrera en la que está inscrito el estudiante.

3. dbo.Nota
Esta tabla registra las calificaciones obtenidas por los estudiantes.

Descripción: Guarda las notas finales asociadas a cada estudiante.

Columnas:

id_nota (PK, int, Not Null): Identificador único de la nota. Es la clave primaria.

id_estudiante (FK, int, Not Null): Identificador del estudiante al que pertenece esta nota. Es una clave foránea que referencia dbo.Estudiante.id_estudiante.

nota_final (decimal(18,0), Not Null): Calificación final obtenida.

Relaciones entre Tablas
dbo.Nota se relaciona con dbo.Estudiante: Existe una relación de uno a muchos donde un Estudiante puede tener múltiples Notas, pero cada Nota pertenece a un único Estudiante. La relación se establece a través de la clave foránea id_estudiante en la tabla dbo.Nota que referencia a id_estudiante en la tabla dbo.Estudiante.



