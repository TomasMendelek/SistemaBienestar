# Usa una imagen base con OpenJDK
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo pom.xml y descarga las dependencias necesarias
COPY pom.xml /app/
COPY src /app/src

# Compila la aplicación usando Maven
RUN ./mvnw clean package -DskipTests

# Exponer el puerto en el que corre la aplicación
EXPOSE 8080

# Definir el comando para correr la aplicación
CMD ["java", "-jar", "target/tu-proyecto-springboot.jar"]
