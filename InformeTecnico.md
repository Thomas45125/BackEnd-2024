# Informe Técnico: Problemas en el Desarrollo de la Plataforma Digital

## 1. Introducción

Este informe documenta los problemas técnicos encontrados durante el desarrollo de la plataforma digital para el centro de bienestar integral. Los problemas se relacionan principalmente con la versión de Java utilizada, cambios en el entorno de desarrollo y la estructura del proyecto.

## 2. Problemas Encontrados

### 2.1. Incompatibilidad de Versión de Java

- **Descripción**: La plataforma de desarrollo [start.spring.io](https://start.spring.io) actualizó su configuración a Java 23. Esto generó incompatibilidades con el proyecto en curso, que estaba diseñado para funcionar con Java 22.
- **Impacto**: Ninguno de los procesos del proyecto pudo iniciarse correctamente, lo que impidió avanzar en el desarrollo.
- **Solución Implementada**: Se evaluaron las opciones para actualizar el proyecto a Java 23. Esto incluyó la actualización de dependencias y la adaptación del código existente a las nuevas características y cambios de la versión.

### 2.2. Cambio de Editor de Código

- **Descripción**: Se realizó un cambio temporal de editor de código, probando diferentes opciones antes de decidirse nuevamente por Visual Studio Code.
- **Problemas**: Al regresar a Visual Studio Code, se encontró que el editor no reconocía la carpeta nombrada como `entity` dentro del proyecto.
- **Requerimiento**: Para que el editor funcionara correctamente, se tuvo que renombrar la carpeta a `Model`, lo que generó inconvenientes en la estructura del proyecto y la consistencia del código.

## 3. Recomendaciones

1. **Establecer Versiones de Java**: Asegurarse de documentar y fijar la versión de Java utilizada en el proyecto, preferiblemente mediante archivos de configuración como `pom.xml` para Maven para evitar futuros problemas de compatibilidad.
  
2. **Estandarizar Nombres de Carpetas**: Definir una convención clara para los nombres de las carpetas y clases dentro del proyecto. En este caso, se recomienda mantener la carpeta `Model` para evitar confusiones con herramientas de desarrollo.

## 4. Conclusiones

Los problemas técnicos encontrados han retrasado el desarrollo de la plataforma, pero las soluciones propuestas permitirán avanzar de manera más efectiva. Se recomienda implementar las recomendaciones mencionadas para evitar situaciones similares en el futuro.
