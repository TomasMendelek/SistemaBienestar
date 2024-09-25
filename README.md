# Plataforma de Bienestar Integral - Backend

Este proyecto es una plataforma digital para un centro de bienestar integral que ofrece servicios para la salud física y mental. La plataforma permite a los usuarios explorar y reservar servicios, gestionar perfiles, seguir su progreso, y recibir recomendaciones personalizadas.

## Objetivos del proyecto

- Aplicar principios de programación orientada a objetos en el diseño de sistemas complejos.
- Desarrollar una aplicación web robusta y escalable con **Spring Boot**.
- Implementar APIs RESTful conectadas a una base de datos **MongoDB**.
- Crear un sistema completo que permita la gestión de usuarios, actividades, reservas, instalaciones, suscripciones y recomendaciones personalizadas.


### Link BackEnd (api) (Produccion): https://bienestar-production.up.railway.app/

### Link FrontEnd (Produccion): https://sistema-bienestar-front-end.vercel.app


## Tecnologías utilizadas Back End
- **Java 17**
- **Spring Boot**
- **MongoDB** (para almacenamiento de datos)
- **Maven** (gestor de dependencias)
- **Postman** (para pruebas de la API)
- **Lombok** (para simplificar código)
- **Railway** (Deploy)

## Tecnologías utilizadas Front End
- **Next.js 14**
- **React 18**
- **Typescript** (para manejo de Datos)
- **React-rooter** (gestionar rutas)
- **Tailwind** (Libreria De estilos)
- **Fremer Motion** (Libreria de animaciones y transiciones)
- - **Vercel** (Deploy)

## Estructura del proyecto

El proyecto está dividido en varias capas para mantener la separación de responsabilidades:

- **models/**: Contiene las entidades principales del sistema (`Usuario`, `Actividad`, `Reserva`, `Instalacion`, `Suscripcion`).
- **repositories/**: Define los repositorios que interactúan con la base de datos MongoDB.
- **services/**: Implementa la lógica de negocio, encapsulando las operaciones sobre los datos.
- **controllers/**: Exponen los endpoints de la API RESTful para interactuar con el sistema.

## Entidades principales

### 1. Usuario
Representa a los miembros e instructores de la plataforma. Tiene los siguientes atributos:
- `id`: Identificador único.
- `nombre`: Nombre del usuario.
- `apellido`: Apellido del usuario.
- `email`: Correo electrónico del usuario.
- `tipo`: Tipo de usuario (miembro o instructor).
- `objetivos`: Metas que el usuario tiene (ej. "Perder peso").
- `progreso`: Nivel de progreso en sus actividades.

### 2. Actividad
Representa las actividades ofrecidas en el centro de bienestar:
- `id`: Identificador único.
- `nombre`: Nombre de la actividad (ej. "Meditación").
- `descripcion`: Descripción de la actividad.
- `duracion`: Duración de la actividad (en minutos).
- `instructorId`: Identificador del instructor responsable.
- `tipoActividad`: Tipo de actividad (ej. "Entrenamiento", "Nutrición").

### 3. Reserva
Representa las reservas que los miembros hacen para asistir a actividades:
- `id`: Identificador único.
- `miembroId`: Identificador del usuario que hace la reserva.
- `actividadId`: Identificador de la actividad reservada.
- `fechaHora`: Fecha y hora de la reserva.
- `estado`: Estado de la reserva (Confirmada, Cancelada).

### 4. Instalación
Representa las instalaciones donde se llevan a cabo las actividades:
- `id`: Identificador único.
- `nombre`: Nombre de la instalación (ej. "Gimnasio").
- `capacidad`: Capacidad máxima de la instalación.
- `equiposDisponibles`: Equipos disponibles en la instalación.

### 5. Suscripción
Representa las suscripciones de los miembros a los servicios:
- `id`: Identificador único.
- `miembroId`: Identificador del miembro.
- `tipo`: Tipo de suscripción (Mensual, Anual).
- `fechaInicio`: Fecha de inicio de la suscripción.
- `fechaFin`: Fecha de finalización.
- `estado`: Estado de la suscripción (Activa, Inactiva).

![image](https://github.com/user-attachments/assets/1988950a-bab9-4dc1-adba-225162b9473a)

## Funcionalidades principales

### 1. Gestión de Usuarios
Los usuarios pueden ser gestionados a través de la API, incluyendo la creación, eliminación y obtención de detalles de usuarios.

#### Endpoints:
- `GET /api/usuarios`: Obtiene todos los usuarios.
- `GET /api/usuarios/{id}`: Obtiene un usuario específico.
- `POST /api/usuarios`: Crea un nuevo usuario.
- `DELETE /api/usuarios/{id}`: Elimina un usuario específico.

### 2. Gestión de Actividades
Las actividades ofrecidas por el centro de bienestar se pueden gestionar a través de la API.

#### Endpoints:
- `GET /api/actividades`: Obtiene todas las actividades.
- `GET /api/actividades/{id}`: Obtiene una actividad específica.
- `POST /api/actividades`: Crea una nueva actividad.
- `DELETE /api/actividades/{id}`: Elimina una actividad específica.

### 3. Sistema de Reservas
Los usuarios pueden reservar actividades a través del sistema de reservas.

#### Endpoints:
- `GET /api/reservas`: Obtiene todas las reservas.
- `GET /api/reservas/{id}`: Obtiene una reserva específica.
- `POST /api/reservas`: Crea una nueva reserva.
- `DELETE /api/reservas/{id}`: Elimina una reserva específica.

### 4. Gestión de Instalaciones
Las instalaciones del centro de bienestar se pueden gestionar.

#### Endpoints:
- `GET /api/instalaciones`: Obtiene todas las instalaciones.
- `GET /api/instalaciones/{id}`: Obtiene una instalación específica.
- `POST /api/instalaciones`: Crea una nueva instalación.
- `DELETE /api/instalaciones/{id}`: Elimina una instalación específica.

### 5. Sistema de Suscripciones
Los usuarios pueden suscribirse a servicios ofrecidos por el centro.

#### Endpoints:
- `GET /api/suscripciones`: Obtiene todas las suscripciones.
- `GET /api/suscripciones/{id}`: Obtiene una suscripción específica.
- `POST /api/suscripciones`: Crea una nueva suscripción.
- `DELETE /api/suscripciones/{id}`: Elimina una suscripción específica.

### 6. Generación de Recomendaciones Personalizadas
El sistema genera recomendaciones de actividades para los usuarios basadas en sus objetivos y actividades previas.

#### Endpoint:
- `GET /api/usuarios/{id}/recomendaciones`: Genera una lista de actividades recomendadas para el usuario con el ID proporcionado.

