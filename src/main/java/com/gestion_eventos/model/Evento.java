package com.gestion_eventos.model;




public class Evento {
    
    private int id;
    private String nombre;
    private String ubicacion;
    private String descripcion;
    private String fecha;

    public Evento(int id, String nombre, String ubicacion, String descripcion, String fecha) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public int getId() {
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
}
