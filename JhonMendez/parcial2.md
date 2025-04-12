# PARCIAL # 2: Sistema de Gestión de Calificaciones Escolares

## Descripción

Desarrollar una aplciación en java que permite resolver los siguiente requisitos:

- Registrar nombres de estudiantes.
- ingresar las calificaciones de cada estudiante en distintas materias.
- Calcular el promedio por estudiante y por materia.
- consultar quiénes aprobaron y reprobaron.
- Mostrar estadísticas generales (mayor calificación, menor, promedio general).

---

## Requisitos Técnicos

1. **Arreglos (Arrays)**  
   Para guardar los nombres de los estudiantes y materias.

2. **Matrices (Arrays bidimensionales)**  
   Para almacenar las calificaciones `[estudiantes][materias]`.

3. **Ciclos (`for`, `while`, etc.)**  
   Para recorrer los datos y realizar operaciones.

4. **Funciones (métodos)**  
   Para modularizar el código: ingresar datos, calcular promedios, mostrar resultados, etc.

---

## Recomendaciones

- Número de estudiantes: fijo (por ejemplo, 5).
- Número de materias: fijo (por ejemplo, 4).
- El usuario podrá:
  - Ingresar nombres de los estudiantes.
  - Ingresar calificaciones para cada materia.
  - Ver el promedio de cada estudiante.
  - Ver el promedio por materia.
  - Ver la lista de aprobados y reprobados (nota mínima: 6.0).
  - Ver estadísticas generales del grupo.

---

## Funciones sugeridas

```java
void ingresarNombres(String[] estudiantes)
void ingresarCalificaciones(double[][] calificaciones, String[] estudiantes, String[] materias)
double calcularPromedioEstudiante(double[] calificaciones)
double calcularPromedioMateria(double[][] calificaciones, int materiaIndex)
void mostrarEstadisticas(double[][] calificaciones, String[] estudiantes, String[] materias)

---
## Fecha de entrega: 22 de abril
## sustentar el trabajo realizado
