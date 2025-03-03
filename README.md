# Documentación de Endpoints API de Noticias

# Recomendaciones
    - Utilizar Postman para probar
    - Utilizar MySQL WampServer
    - Importar la base de datos llamada bdnoticia.sql que se ubica en la raiz del proyecto

# Notas sobre seguridad:=
    Todos los endpoints excepto los de autenticación (/api/auth/*) requieren un token JWT válido.
    El token JWT tiene una duración de 24 horas (86400000 ms).
    Asegúrate de incluir el token en el formato correcto: Authorization: Bearer {token}

## Configuración de Base de Datos
```properties
spring.application.name=backend

# Configuración para la base de datos
spring.datasource.url=jdbc:mysql://localhost:3306/bdnoticia?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# JWT
jwt.secret.key=CHp8B3ztA0aKkz2qbNqi90WNFOOJwcINjNqY+RfkQNE=
jwt.expiration=86400000
```

# Endpoints de Autenticación
## Registro de Usuario
### URL: /api/auth/register
### Método: POST
### Autenticación: No requerida
### Cuerpo de la solicitud:

```json
{
    "username": "admin",
    "password": "admin"
}
```
### Respuesta:
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0IiwiaWF0IjoxNzQxMDE2MDU1LCJleHAiOjE3NDExMDI0NTV9.8037jbvL1-MCdqToZ_qXiVamMdZ-izUxZyA4a9zH0pM"
}
```

# Autenticación de Usuario
## URL: /api/auth/authenticate
### Método: POST
### Autenticación: No requerida
### Cuerpo de la solicitud:
```json
{
    "username": "admin",
    "password": "admin"
}
```
### Respuesta:
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0IiwiaWF0IjoxNzQxMDE2MDU1LCJleHAiOjE3NDExMDI0NTV9.8037jbvL1-MCdqToZ_qXiVamMdZ-izUxZyA4a9zH0pM"
}
```
# Endpoints de Noticias
## URL: /api/news/latest
### Obtener las últimas noticias
### Método: GET
### Autenticación: JWT requerido en el encabezado Authorization: Bearer {token}
### Descripción: Devuelve las 5 noticias más recientes para la pantalla principal.
### Respuesta exitosa:
```json
[
  {
    "id": 7,
    "title": "TEST IA MORE",
    "description": "IA TEST",
    "imageUrl": "https://img.computing.es/wp-content/uploads/2024/03/22155324/IA-2.jpg",
    "publishDate": "2025-03-02T16:43:21",
    "categoryName": "Tecnología"
  },
  {
    "id": 3,
    "title": "Sorpresa en el mundial de fútbol",
    "description": "Equipo no favorito avanza a semifinales tras una histórica victoria",
    "imageUrl": "https://www.prensalibre.com/wp-content/uploads/2018/12/ccbc74c6-7149-42c4-aa43-a9c30641fff3.jpg?quality=52",
    "publishDate": "2025-03-01T16:03:12",
    "categoryName": "Deportes"
  }
]
```


# Obtener todas las noticias

## URL: /api/news/all
### Método: GET
### Autenticación: JWT requerido en el encabezado Authorization: Bearer {token}
### Descripción: Devuelve todas las noticias ordenadas por fecha de publicación.
### Respuesta exitosa: Array con todas las noticias en formato similar al endpoint /api/news/latest


# Obtener detalles de una noticia

## URL: /api/news/{id}
### Método: GET
### Autenticación: JWT requerido en el encabezado Authorization: Bearer {token}
### Parámetros de ruta:
### id: ID de la noticia que se desea consultar
### Descripción: Devuelve los detalles completos de una noticia específica.
### Respuesta exitosa:

```json
{
"id": 1,
"title": "Avances en Inteligencia Artificial transforman la industria",
"description": "Nuevos desarrollos en IA están revolucionando múltiples sectores económicos",
"content": null,
"imageUrl": "https://mediatek-marketing.transforms.svdcdn.com/production/posts/MediaTek-IA-2023.jpg?w=2048&h=1075&q=80&auto=format&fit=crop&dm=1688130337&s=3b56535c28f441a34db9455d64444cb7",
"publishDate": "2025-02-28T16:03:12",
"categoryName": "Tecnología",
"tags": [
"Inteligencia Artificial",
"Innovación"
]
}
```


# Obtener noticias recomendadas
## URL: /api/news/{id}/recommended
### Método: GET
### Autenticación: JWT requerido en el encabezado Authorization: Bearer {token}
### Parámetros de ruta:
### id: ID de la noticia para la cual se desean recomendaciones
### Descripción: Devuelve 3 noticias recomendadas basadas en la noticia especificada.
### Respuesta exitosa:

```json
[
  {
    "id": 5,
    "title": "Nuevo tratamiento promete combatir enfermedades crónicas",
    "description": "Científicos desarrollan terapia innovadora para múltiples condiciones",
    "imageUrl": "https://cdn.who.int/media/images/default-source/mca/mca-covid-19/coronavirus-2.tmb-479v.jpg?sfvrsn=4dba955c_19%20479w",
    "publishDate": "2025-02-26T16:03:12",
    "categoryName": "Salud"
  }
]
```


# Endpoints de Categorías
## Obtener todas las categorías
## URL: /api/categories
### Método: GET
### Autenticación: JWT requerido en el encabezado Authorization: Bearer {token}
### Descripción: Devuelve todas las categorías disponibles.
### Respuesta exitosa:

```json
[
  {
    "id": 1,
    "name": "Tecnología",
    "description": "Noticias sobre avances tecnológicos"
  },
  {
    "id": 2,
    "name": "Deportes",
    "description": "Noticias deportivas de todo el mundo"
  }
]
```

# Uso de los Endpoints
## Flujo típico de uso:

### Registro o autenticación de usuario para obtener un token JWT
    POST a /api/auth/register o /api/auth/authenticate

### Agregar el token JWT a todas las solicitudes subsiguientes en el encabezado Authorization
    Formato: Authorization: Bearer {token}

### Obtener las últimas noticias para la pantalla principal
    GET a /api/news/latest

### Ver detalles de una noticia específica
    GET a /api/news/{id}

### Ver noticias recomendadas basadas en la noticia actual
    GET a /api/news/{id}/recommended

### Explorar categorías (opcional)
    GET a /api/categories


