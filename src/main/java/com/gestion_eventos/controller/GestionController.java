package com.gestion_eventos.controller;





import com.gestion_eventos.model.Evento;
import com.gestion_eventos.service.GestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventos")
public class GestionController  {
    private final GestionService gestionService;

    public GestionController (GestionService gestionService) {
        this.gestionService = gestionService;
    }

    @GetMapping
    public List<Evento> listarEventos() {
        return gestionService.obtenerEventos();
    }

    @GetMapping("/{id}")
    public Optional<Evento> obtenerEvento(@PathVariable int id) {
        return gestionService.obtenerEventoPorId(id);
    }
}