# MicroTravels

A continuación se detallan la instrucciones de instalación y ejecución del servidor MicroTravels. Así mismo, se describe la forma en que se pueden consumir los servicios a través de un cliente postman.


## Servidor
El servidor consta de 9 servicios los cuales se ejecutan por defecto en los siguientes puertos:

|       Servicio       | Puerto por defecto |
| :---------------------: | :--------------------: |
|         eureka          |          8761          |
|         gateway         |          9990          |
|      users-service      |          8880          |
|    providers-service    |          7770          |
|    tourists-service     |          6660          |
| tourismservices-service |          5550          |
|    purchases-service    |          4440          |
|    questions-service    |          3330          |
|     search-service      |          2220          |

### ¿Cómo instalar el servidor?
Para la instalación debe clonar el repositorio y, adicional a ello, tener los siguientes requisitos de software:
* Java 11 o superior
* Maven 3.8.2

## ¿Cómo ejecutar el servidor?
De forma general, utilice el siguiente comando para correr cualquier servicio: 
> mvn clean install spring-boot:run
1. Ejecutar el eureka server
2. Ejecutar los demás servicios (al ser independientes, el orden es irrelevante)
3. Consumir el servicio requerido. 

### Consumo de servicios
El consumo de los servicios se resume en las siguientes tablas:

#### Servicios sesión de usuario
| Operación | HTTP Request | URL |
|:--------|:-----------|:-----------|
| Crear turista | POST | http://localhost:9990/users/tourists |
| Crear proveedor | POST | http://localhost:9990/users/providers |
| Iniciar sesión | POST | http://localhost:9990/login |

#### Servicios turistas
| Operación | HTTP Request | URL |
|:--------|:-----------|:-----------|
| Obtener todos los turistas | GET |  http://localhost:9990/tourists |
| Obtener turista | GET |  http://localhost:9990/tourists/{id} |
| Eliminar turista | DELETE |  http://localhost:9990/tourists/{id} |
| Actualizar turista | UPDATE |  http://localhost:9990/tourists/{id} |

#### Servicios proveedores
| Operación | HTTP Request | URL |
|:--------|:-----------|:-----------|
| Obtener todos los proveedores | GET |  http://localhost:9990/providers |

#### Servicios de los servicios de turismo
| Operación | HTTP Request | URL |
|:--------|:-----------|:-----------|
| Crear servicio | POST | http://localhost:9990/services |
| Obtener todos los servicios | GET |  http://localhost:9990/services |
| Obtener servicio | GET |  http://localhost:9990/services/{id} |
| Eliminar turista | DELETE |  http://localhost:9990/services/{id} |
| Actualizar turista | UPDATE |  http://localhost:9990/services/{id} |

#### Servicios de compra
| Operación | HTTP Request | URL |
|:--------|:-----------|:-----------|
| Crear carrito de compras | POST | http://localhost:9990/shopping-cart |
| Obtener carrito de compras | GET |  http://localhost:9990/shopping-cart/{id} |
| Añadir servicio al carrito de compras | POST | http://localhost:9990/shopping-cart/{id}/services |
| Eliminar servicio del carrito de compras | DELETE |  http://localhost:9990/shopping-cart/{id}/services |
| Realizar pago | POST |  http://localhost:9990/shopping-cart/{id}/payment |

#### Servicios de preguntas
| Operación | HTTP Request | URL |
|:--------|:-----------|:-----------|
| Crear pregunta | POST | http://localhost:9990/questions |
| Obtener preguntas de un servicio  | GET |  http://localhost:9990/questions?serviceID={id} |

#### Servicios de búsqueda
| Operación | HTTP Request | URL |
|:--------|:-----------|:-----------|

## Cliente
Como cliente, se presenta una colección de postman donde se exponen todos los puntos de acceso mostrados anteriormente. 
1. Ubique la colección postman en la ruta **"/MicroTravels/MicroTravels REST API.postman_collection.json"**
2. Descargue la colección
3. Importe la colección en postman
4. Ejecute las peticiones requeridas
5. En caso de ser necesario, cambie el body de las peticiones o los parámetros de las Uris
