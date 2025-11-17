package com.mycompany.universidad.persistencia;

import com.mycompany.universidad.logica.*;
import com.mycompany.universidad.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;

public class ControladoraPersistencia {
    
    // Controladoras para las 5 entidades
    EstudianteJpaController estJpa = new EstudianteJpaController();
    ProfesorJpaController profJpa = new ProfesorJpaController();
    CursoJpaController cursoJpa = new CursoJpaController();
    DepartamentoJpaController deptoJpa = new DepartamentoJpaController();
    MatriculaJpaController matJpa = new MatriculaJpaController();

    // Métodos para Estudiante
    public void crearEstudiante(Estudiante est) {
        estJpa.create(est);
    }
    
    public ArrayList<Estudiante> traerEstudiantesPorNombre(String nombre) {
        List<Estudiante> lista = estJpa.findEstudiantesPorNombre(nombre);
        return new ArrayList<>(lista);
    }
    
    public ArrayList<Estudiante> traerEstudiantesPaginados(int cantidad, int inicio) {
        List<Estudiante> lista = estJpa.findEstudiantesPaginados(cantidad, inicio);
        return new ArrayList<>(lista);
    }
    
    public ArrayList<Estudiante> traerEstudiantesConMatriculasActivas() {
        List<Estudiante> lista = estJpa.findEstudiantesConMatriculasActivas();
        return new ArrayList<>(lista);
    }
    
    // Métodos para las otras entidades (similar estructura)
    public void crearProfesor(Profesor prof) {
        profJpa.create(prof);
    }
    
    public void crearCurso(Curso curso) {
        cursoJpa.create(curso);
    }
    
    public void crearDepartamento(Departamento depto) {
        deptoJpa.create(depto);
    }
    
    public void crearMatricula(Matricula mat) {
        matJpa.create(mat);
    }
    
    public ArrayList<Estudiante> traerTodosEstudiantes() {
        List<Estudiante> lista = estJpa.findEstudianteEntities();
        return new ArrayList<>(lista);
    }
}