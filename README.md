# 🏛️ Sistema de Gestión Universitaria - ORM JPA

## 📋 Descripción
Sistema completo de gestión académica implementado con Jakarta Persistence API (JPA) que modela las entidades y relaciones de una universidad, cumpliendo con todos los requisitos de mapeo objeto-relacional.

## 📦 Entidades Implementadas

### 1. **Departamento**
- Gestión de áreas académicas
- Relación 1:N con Profesor

### 2. **Profesor**
- Personal docente especializado
- Relaciones N:1 con Departamento y 1:N con Curso

### 3. **Curso**
- Unidades del plan de estudios
- Relaciones N:1 con Profesor y 1:N con Matricula

### 4. **Estudiante**
- Beneficiarios del proceso educativo
- Relación 1:N con Matricula

### 5. **Matricula**
- Registro académico estudiante-curso
- Relaciones N:1 con Estudiante y Curso

## 🔗 Relaciones JPA

| Relación | Tipo | Entidades |
|----------|------|-----------|
| Departamento-Profesor | OneToMany/ManyToOne | 1:N |
| Profesor-Curso | OneToMany/ManyToOne | 1:N |
| Estudiante-Matricula | OneToMany/ManyToOne | 1:N |
| Curso-Matricula | OneToMany/ManyToOne | 1:N |
| Estudiante-Curso | ManyToMany (vía Matricula) | N:N |

## 💾 Consultas JPQL Implementadas

### 🔍 Consulta 1: Búsqueda con Filtro LIKE

"SELECT e FROM Estudiante e ORDER BY e.id DESC"
