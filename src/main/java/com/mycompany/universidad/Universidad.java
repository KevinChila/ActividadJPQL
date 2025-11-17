package com.mycompany.universidad;

import com.mycompany.universidad.logica.*;
import java.util.ArrayList;

public class Universidad {

    public static void main(String[] args) {
        
        Controladora control = new Controladora();
        
        System.out.println("=== SISTEMA DE GESTIÓN UNIVERSITARIA ===");
        
        // Crear departamentos
        Departamento deptoInformatica = new Departamento("INF", "Informática");
        Departamento deptoMatematicas = new Departamento("MAT", "Matemáticas");
        
        control.crearDepartamento(deptoInformatica);
        control.crearDepartamento(deptoMatematicas);
        
        // Crear profesores
        Profesor prof1 = new Profesor("P001", "Ana", "García", "Programación");
        Profesor prof2 = new Profesor("P002", "Carlos", "López", "Cálculo");
        
        control.crearProfesor(prof1);
        control.crearProfesor(prof2);
        
        // Crear cursos
        Curso curso1 = new Curso("CS101", "Programación I", 4);
        Curso curso2 = new Curso("MATH201", "Cálculo I", 5);
        Curso curso3 = new Curso("CS102", "Base de Datos", 4);
        
        control.crearCurso(curso1);
        control.crearCurso(curso2);
        control.crearCurso(curso3);
        
        // Crear estudiantes
        Estudiante est1 = new Estudiante("E001", "María", "Rodríguez", "maria@universidad.edu");
        Estudiante est2 = new Estudiante("E002", "Juan", "Pérez", "juan@universidad.edu");
        Estudiante est3 = new Estudiante("E003", "Ana", "Martínez", "ana@universidad.edu");
        Estudiante est4 = new Estudiante("E004", "Carlos", "Gómez", "carlos@universidad.edu");
        
        control.crearEstudiante(est1);
        control.crearEstudiante(est2);
        control.crearEstudiante(est3);
        control.crearEstudiante(est4);
        
        // Crear matrículas
        Matricula mat1 = new Matricula(est1, curso1);
        Matricula mat2 = new Matricula(est2, curso1);
        Matricula mat3 = new Matricula(est3, curso2);
        Matricula mat4 = new Matricula(est4, curso3);
        
        control.crearMatricula(mat1);
        control.crearMatricula(mat2);
        control.crearMatricula(mat3);
        control.crearMatricula(mat4);
        
        // ========== EJECUTAR CONSULTAS JPQL ==========
        
        System.out.println("\n=== CONSULTA 1: Estudiantes por nombre (filtro LIKE) ===");
        ArrayList<Estudiante> estudiantesNombre = control.traerEstudiantesPorNombre("an");
        for(Estudiante est : estudiantesNombre) {
            System.out.println("Estudiante: " + est.toString());
        }
        
        System.out.println("\n=== CONSULTA 2: Estudiantes con paginación ===");
        ArrayList<Estudiante> estudiantesPaginados = control.traerEstudiantesPaginados(2, 0);
        for(Estudiante est : estudiantesPaginados) {
            System.out.println("Estudiante página 1: " + est.toString());
        }
        
        System.out.println("\n=== CONSULTA 3: Estudiantes con matrículas activas ===");
        ArrayList<Estudiante> estudiantesActivos = control.traerEstudiantesConMatriculasActivas();
        for(Estudiante est : estudiantesActivos) {
            System.out.println("Estudiante activo: " + est.toString());
        }
        
        System.out.println("\n=== TODOS LOS ESTUDIANTES ===");
        ArrayList<Estudiante> todosEstudiantes = control.traerTodosEstudiantes();
        for(Estudiante est : todosEstudiantes) {
            System.out.println("Estudiante: " + est.toString());
        }
        
        System.out.println("\n=== SISTEMA CONFIGURADO EXITOSAMENTE ===");
    }
}