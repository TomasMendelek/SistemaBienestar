# Usa una imagen base con Maven y OpenJDK 17
FROM maven:3.8.6-openjdk-17 AS build

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo pom.xml y descarga las dependencias necesarias
COPY pom.xml /app/
COPY src /app/src

# Compila la aplicación usando Maven
RUN mvn clean package -DskipTests

# Usa una imagen ligera de OpenJDK para correr la aplicación
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo .jar generado al contenedor final
COPY --from=build /app/target/*.jar /app/app.jar

# Exponer el puerto en el que corre la aplicación
EXPOSE 8080

# Definir el comando para correr la aplicación
CMD ["java", "-jar", "/app/app.jar"]
