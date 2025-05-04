package com.gestion_eventos.model;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.hateoas.RepresentationModel;

@Entity
@Table(name = "evento") // nombre de la tabla
public class Evento extends RepresentationModel<Evento>{
    @Id // clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // se genera automaticamente 
    @Column(name = "id")
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "ubicacion")
    private String ubicacion;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha")
    private String fecha;

    public Evento() {
     // Este constructor es necesario para JPA/Hibernate
 }


    public Evento(long id, String nombre, String ubicacion, String descripcion, String fecha) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public long getId() {
         return id;
    }
    public String getNombre() {
         return nombre; 
    }
    public String getUbicacion() {
         return ubicacion; 
    }
    public String getDescripcion() {
        return descripcion;
   }
    public String getFecha() {
         return fecha; 
    }

    public void setId(long id) {
     this.id = id;
    }

    public void setNombre(String nombre) {
     this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion) {
     this.ubicacion = ubicacion;
    }

    public void setDescripcion(String descripcion) {
     this.descripcion = descripcion;
    }

    public void setFecha(String fecha) {
     this.fecha = fecha;
    }

}
