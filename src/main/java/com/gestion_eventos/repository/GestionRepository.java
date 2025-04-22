package com.gestion_eventos.repository;


import com.gestion_eventos.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


   //extiende todas las librerias de jpa y ya no es necesario crear la tabla en el repositorio
    public interface GestionRepository extends JpaRepository<Evento, Long>{
    
}