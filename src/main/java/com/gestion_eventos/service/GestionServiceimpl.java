package com.gestion_eventos.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestion_eventos.model.Evento;
import com.gestion_eventos.repository.GestionRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


// aqui estan los metodos que retornan al repositorio
@Service
@Transactional

public class GestionServiceimpl implements GestionService {
    @Autowired
    private GestionRepository gestionRepository;

    @Override
    public List<Evento> getAllEventos() {
        return gestionRepository.findAll();
    }

    @Override
    public Optional<Evento> getEventoById(Long id) {
        return gestionRepository.findById(id);
    }

    @Override
    public Evento createEvento(Evento evento) {
        return gestionRepository.save(evento);
    }

    @Override
    public Evento updateEvento(Long id, Evento evento) {
        if (gestionRepository.existsById(id)) {
            evento.setId(id);
            return gestionRepository.save(evento);
        } else {
            return null;
        }
    }
    
    @Override
    public void deleteEvento(Long id) {
        if (gestionRepository.existsById(id)) {
            gestionRepository.deleteById(id);
        }
    }
    
}