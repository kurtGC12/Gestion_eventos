package com.gestion_eventos.controller;



import com.gestion_eventos.model.Evento;
import com.gestion_eventos.service.GestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventos")
@CrossOrigin(origins = "*")
public class GestionController  {

    public GestionController (GestionService gestionService) {
        this.gestionService = gestionService;
    }
    @Autowired
    private GestionService gestionService;

    @GetMapping
    public List<Evento> getAllEventos() {
        return gestionService.getAllEventos();
    }

    
    @GetMapping("/{id}")
    public Optional<Evento> getEventoById (@PathVariable long id) {
        return gestionService.getEventoById(id);
    }
    
    @PostMapping
public ResponseEntity<Evento> createEvento(@RequestBody Evento evento) {
    Evento creado = gestionService.createEvento(evento);
    return ResponseEntity.status(HttpStatus.CREATED).body(creado);
 }

    @PutMapping("/{id}")
    public Evento updateEvento(@PathVariable Long id, @RequestBody Evento evento) {
        return gestionService.updateEvento(id, evento);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable Long id) {
    gestionService.deleteEvento(id);
    return ResponseEntity.noContent().build();  
}

} 