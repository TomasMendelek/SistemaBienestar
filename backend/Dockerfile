# Usa una imagen base de Ubuntu para descargar e instalar JDK 23
FROM ubuntu:latest AS build

# Actualiza el contenedor e instala las dependencias necesarias
RUN apt-get update && apt-get install -y \
    curl \
    tar \
    maven \
    bash

# Descargar JDK 23 de OpenJDK Early Access
RUN curl -o /tmp/openjdk-23.tar.gz https://download.java.net/java/early_access/jdk23/28/GPL/openjdk-23-ea+28_linux-x64_bin.tar.gz

# Extraer el archivo JDK en /opt/jdk-23
RUN mkdir /opt/jdk-23 && tar -xzf /tmp/openjdk-23.tar.gz -C /opt/jdk-23 --strip-components=1

# Establecer las variables de entorno para usar JDK 23
ENV JAVA_HOME=/opt/jdk-23
ENV PATH="$JAVA_HOME/bin:$PATH"

# Verifica que JDK 23 esté correctamente instalado
RUN java -version

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo pom.xml y descargar las dependencias necesarias
COPY pom.xml /app/
COPY src /app/src

# Compila la aplicación usando Maven
RUN mvn clean package -DskipTests

# Fase final: usar una imagen ligera para ejecutar la aplicación
FROM ubuntu:latest

# Copiar el JDK 23 desde la fase de construcción
COPY --from=build /opt/jdk-23 /opt/jdk-23

# Establecer las variables de entorno para usar JDK 23
ENV JAVA_HOME=/opt/jdk-23
ENV PATH="$JAVA_HOME/bin:$PATH"

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo .jar generado al contenedor final
COPY --from=build /app/target/*.jar /app/app.jar

# Exponer el puerto en el que corre la aplicación
EXPOSE 8080

# Ejecutar la aplicación
CMD ["java", "-jar", "/app/app.jar"]
