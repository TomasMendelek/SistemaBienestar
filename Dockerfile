# Paso 1: Usa una imagen base de Alpine Linux y descarga JDK 23 manualmente
FROM alpine:3.18 AS build

# Instalar dependencias necesarias para descargar y usar JDK y Maven
RUN apk add --no-cache curl bash tar gzip

# Descargar JDK 23 de OpenJDK
RUN curl -o /tmp/openjdk-23.tar.gz https://download.java.net/java/early_access/jdk23/28/GPL/openjdk-23-ea+28_linux-x64_bin.tar.gz

# Extraer el archivo
RUN tar -xzf /tmp/openjdk-23.tar.gz -C /opt/

# Establecer las variables de entorno para usar JDK 23
ENV JAVA_HOME=/opt/jdk-23
ENV PATH="$JAVA_HOME/bin:$PATH"

# Verifica que JDK 23 esté correctamente instalado
RUN java -version

# Paso 2: Instalar Maven manualmente
RUN apk add --no-cache maven

# Paso 3: Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo pom.xml y descargar las dependencias necesarias
COPY pom.xml /app/
COPY src /app/src

# Compila la aplicación usando Maven
RUN mvn clean package -DskipTests

# Paso 4: Usar una imagen ligera de Alpine para ejecutar la aplicación
FROM alpine:3.18

# Copiar el JDK 23 desde la fase de build
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
