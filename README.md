# Wiki

# MicroTravels
A continuación se detallan la instrucciones de instalación y ejecución del servidor MicroTravels. Así mismo, se describe la forma en que se pueden consumir los servicios a través de un cliente postman.

## Servidor
### ¿Cómo instalar el servidor?
Para la instalación debe clonar el repositorio y, adicional a ello, tener los siguientes requisitos de software:
* Java 11 o superior
* Maven 3.8.2

### ¿Cómo ejecutar el servidor?
El servidor consta de 9 servicios los cuales se ejecutan por defecto en los siguientes puertos:

|       Servicio       | Puerto por defecto |
| :---------------------: | :--------------------: |
|         eureka          |          8761          |
|         gateway         |          9990          |
|      users-service      |          8880          |
|    providers-service    |          7770          |
|    tourists-service     |          6660          |
| tourism-services |          5550          |
|    purchases-service    |          4440          |
|    questions-service    |          3330          |
|     search-service      |          2220          |
|     external-service      |          1025          |

Los servicios del sistema (a excepción de eureka y gateway) pueden ser ejecutados en múltiples instancias, para ello, debe cambiar el puerto en que se ejecutan por defecto. Para cambiar los puertos utilice los siguientes comandos:


* Windows:
> SET SERVER_PORT=####
> 
> mvn spring-boot:run

### Pasos para ejecutar el servidor
De forma general, utilice el siguiente comando para correr cualquier servicio: 
> mvn clean install spring-boot:run
1. Ejecutar el eureka server
2. Ejecutar los demás servicios (al ser independientes, el orden es irrelevante)
3. Una vez todos los servicios estén en línea, ya puede consumirlos. En el apartado "Cliente" encuentra más información acerca del consumo por medio de un cliente Postman. 

### Consumo de servicios
A continuación se listan los servicios ofrecidos por el sistema. 

### Servicios usuarios
Provee todos los servicios requeridos para el control de sesión de los usuarios, es decir:
* Registrar turista
* Registrar proveedor
* Iniciar sesión
* Cerrar sesión
* Eliminar registro de turista
* Eliminar registro de proveedor

### Servicios turistas
Provee todos los servicios requeridos para la gestión de los turistas:
* Obtener todos los turistas registrados
* Buscar turista por id
* Actualizar información de un turista

### Servicios proveedores
Provee todos los servicios requeridos para la gestión de los proveedores:
* Obtener todos los proveedores registrados
* Buscar proveedor por id
* Actualizar información de un proveedor

### Servicios de los servicios de turismo
Provee todos los servicios requeridos para la gestión de los servicios de turismo. Se tienen cuatro tipos de servicios: Accomodation, EcoTrip, Transport y Food. Cada uno de los servicios anteriormente mencionados ofrece los siguientes servicios:
* Crear un servicio
* Obtener servicio por id
* Obtener todos los servicios
* Eliminar un servicio
* Actualizar información de un servicio

### Servicios de compra
Provee todos los servicios requeridos para el manejo del carrito de compras y la realización del pago
* Crear carrito de compra
* Obtener carrito de compra dado un nombre de usuario
* Añadir un servicio al carrito de compras
* Eliminar un servicio del carrito de compras
* Realizar pago

### Servicios de preguntas
Provee todos los servicios requeridos para la gestión de las preguntas de un servicio de turismo:
* Crear una pregunta para un servicio de turismo específico
* Obtener todas las preguntas de un servicio de turismo dado su id

### Servicios de búsqueda
Este es un servicio SOAP, para poder consumirlo, remitirse al apartado de cliente.

## Cliente
Como cliente, se presenta una colección de postman donde se exponen todos los puntos de acceso mostrados anteriormente. 

Pasos para utilizar el cliente:
1. Ubique y descargue la colección Postman en la ruta **"/MicroTravels/Cliente/MicroTravels REST API.postman_collection.json"**
2. Ubique y descargue las variables de entorno de Postman en la ruta **"/MicroTravels/Cliente/MicroSystem.postman_globals.json"** 
4. Importe la colección en Postman
5. Importe las variables de entorno en Postman
6. Ejecute las peticiones requeridas
7. En caso de ser necesario, cambie el body de las peticiones o los parámetros de las Uris

## Comentarios adicionales
1) Servicio SOAP: Para abrir el WSDL se debe ejecutar el comando 'mvn clean install spring-boot:run' en la carpeta 'SearchService' y por defecto el WSDL se econtrará en la ruta http://localhost:2220/ws/tourismServices.wsdl
2) Bases de datos: Para esta entrega se utilizó una única base de datos que está en la nube, con el objetivo de simular la separación de datos, cada microservicio se conecta a un esquema distinto, cada esquema tiene sus propias tablas independientes, el cual se puede ver en el archivo application.properties de cada servicio respectivo. Cuando se suban los servicios a contenedores la arquitectura se asemejará más al diagrama de despliegue adjunto.
3) Autenticación: Para la autenticación se utilizó JWT (Json Web Tokens) dado que es una herramienta que no tiene estado, la operación de cerrar sesión se implementa del lado del cliente, es decir el cliente debe limpiar su propio token de autenticación y adicionalmente el JWT quedará inválido una vez alcance la fecha de expiración (10 horas).
