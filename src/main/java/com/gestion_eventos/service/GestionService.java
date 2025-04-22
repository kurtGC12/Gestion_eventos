package com.gestion_eventos.service;


import com.gestion_eventos.model.Evento;
import java.util.List;
import java.util.Optional;


public interface GestionService {
    //metodos de cada parametro
    List<Evento> getAllEventos(); 
    Optional<Evento> getEventoById(Long id);
    Evento createEvento(Evento evento);
    Evento updateEvento(Long id, Evento factura);
    void deleteEvento(Long id);
}