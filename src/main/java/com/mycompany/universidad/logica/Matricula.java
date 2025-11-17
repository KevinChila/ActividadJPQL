package com.mycompany.universidad.logica;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "matriculas")
public class Matricula implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Temporal(TemporalType.DATE)
    private Date fechaMatricula;
    private Double calificacion;
    private String estado; // ACTIVA, COMPLETADA, CANCELADA
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Matricula() {
    }

    public Matricula(Estudiante estudiante, Curso curso) {
        this.estudiante = estudiante;
        this.curso = curso;
        this.fechaMatricula = new Date();
        this.estado = "ACTIVA";
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Date getFechaMatricula() { return fechaMatricula; }
    public void setFechaMatricula(Date fechaMatricula) { this.fechaMatricula = fechaMatricula; }
    public Double getCalificacion() { return calificacion; }
    public void setCalificacion(Double calificacion) { this.calificacion = calificacion; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public Estudiante getEstudiante() { return estudiante; }
    public void setEstudiante(Estudiante estudiante) { this.estudiante = estudiante; }
    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = curso; }

    @Override
    public String toString() {
        return "Matricula{" + "id=" + id + ", estudiante=" + (estudiante != null ? estudiante.getNombre() : "null") + ", curso=" + (curso != null ? curso.getNombre() : "null") + ", estado=" + estado + '}';
    }
}