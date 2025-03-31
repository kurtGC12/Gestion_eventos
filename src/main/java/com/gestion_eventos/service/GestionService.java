package com.gestion_eventos.service;


import com.gestion_eventos.model.Evento;
import com.gestion_eventos.repository.GestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GestionService {
    private final GestionRepository gestionRepository;

    public GestionService(GestionRepository gestionRepository) {
        this.gestionRepository= gestionRepository;
    }

    public List<Evento> obtenerEventos() {
        return gestionRepository.obtenerTodosLosEventos();
    }

    public Optional<Evento> obtenerEventoPorId(int id) {
        return gestionRepository.buscarPorId(id);
    }
}