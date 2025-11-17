package com.mycompany.universidad.logica;

import com.mycompany.universidad.persistencia.ControladoraPersistencia;
import java.util.ArrayList;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    // Métodos para crear entidades
    public void crearEstudiante(Estudiante est) {
        controlPersis.crearEstudiante(est);
    }
    
    public void crearProfesor(Profesor prof) {
        controlPersis.crearProfesor(prof);
    }
    
    public void crearCurso(Curso curso) {
        controlPersis.crearCurso(curso);
    }
    
    public void crearDepartamento(Departamento depto) {
        controlPersis.crearDepartamento(depto);
    }
    
    public void crearMatricula(Matricula mat) {
        controlPersis.crearMatricula(mat);
    }
    
    // CONSULTAS JPQL
    public ArrayList<Estudiante> traerEstudiantesPorNombre(String nombre) {
        return controlPersis.traerEstudiantesPorNombre(nombre);
    }
    
    public ArrayList<Estudiante> traerEstudiantesPaginados(int cantidad, int inicio) {
        return controlPersis.traerEstudiantesPaginados(cantidad, inicio);
    }
    
    public ArrayList<Estudiante> traerEstudiantesConMatriculasActivas() {
        return controlPersis.traerEstudiantesConMatriculasActivas();
    }
    
    public ArrayList<Estudiante> traerTodosEstudiantes() {
        return controlPersis.traerTodosEstudiantes();
    }
}