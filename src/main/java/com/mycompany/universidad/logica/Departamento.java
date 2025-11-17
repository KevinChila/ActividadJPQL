package com.mycompany.universidad.logica;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "departamentos")
public class Departamento implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String codigoDepartamento;
    private String nombre;
    private String descripcion;
    
    // RELACIÓN UNO A MUCHOS con Profesor
    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Profesor> profesores = new ArrayList<>();

    public Departamento() {
    }

    public Departamento(String codigoDepartamento, String nombre) {
        this.codigoDepartamento = codigoDepartamento;
        this.nombre = nombre;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getCodigoDepartamento() { return codigoDepartamento; }
    public void setCodigoDepartamento(String codigoDepartamento) { this.codigoDepartamento = codigoDepartamento; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public List<Profesor> getProfesores() { return profesores; }
    public void setProfesores(List<Profesor> profesores) { this.profesores = profesores; }

    @Override
    public String toString() {
        return "Departamento{" + "id=" + id + ", codigo=" + codigoDepartamento + ", nombre=" + nombre + '}';
    }
}