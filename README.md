# Documentación de Endpoints API de Noticias

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
