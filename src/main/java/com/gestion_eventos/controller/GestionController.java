package com.gestion_eventos.controller;



import com.gestion_eventos.model.Evento;
import com.gestion_eventos.service.GestionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.hateoas.CollectionModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventos")
@CrossOrigin(origins = "*")
public class GestionController {

    @Autowired
    private GestionService gestionService;

    public GestionController(GestionService gestionService) {
        this.gestionService = gestionService;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<Evento>>> getAllEventos() {
        List<Evento> eventos = gestionService.getAllEventos();

        List<EntityModel<Evento>> recursos = eventos.stream()
                .map(evento -> EntityModel.of(evento,
                        linkTo(methodOn(GestionController.class).getEventoById(evento.getId())).withSelfRel()))
                .toList();

        CollectionModel<EntityModel<Evento>> collectionModel = CollectionModel.of(
                recursos,
                linkTo(methodOn(GestionController.class).getAllEventos()).withSelfRel()
        );

        return ResponseEntity.ok(collectionModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Evento>> getEventoById(@PathVariable long id) {
        Optional<Evento> eventoOptional = gestionService.getEventoById(id);

        if (eventoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Evento evento = eventoOptional.get();

        EntityModel<Evento> recurso = EntityModel.of(evento,
                linkTo(methodOn(GestionController.class).getEventoById(id)).withSelfRel(),
                linkTo(methodOn(GestionController.class).getAllEventos()).withRel("todos-los-eventos")
        );

        return ResponseEntity.ok(recurso);
    }

    @PostMapping
    public ResponseEntity<EntityModel<Evento>> createEvento(@RequestBody Evento evento) {
        Evento creado = gestionService.createEvento(evento);

        EntityModel<Evento> recurso = EntityModel.of(creado,
                linkTo(methodOn(GestionController.class).getEventoById(creado.getId())).withSelfRel(),
                linkTo(methodOn(GestionController.class).getAllEventos()).withRel("todos-los-eventos")
        );

        return ResponseEntity
                .created(linkTo(methodOn(GestionController.class).getEventoById(creado.getId())).toUri())
                .body(recurso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<Evento>> updateEvento(@PathVariable Long id, @RequestBody Evento evento) {
        Evento actualizado = gestionService.updateEvento(id, evento);

        EntityModel<Evento> recurso = EntityModel.of(actualizado,
                linkTo(methodOn(GestionController.class).getEventoById(actualizado.getId())).withSelfRel(),
                linkTo(methodOn(GestionController.class).getAllEventos()).withRel("todos-los-eventos")
        );

        return ResponseEntity.ok(recurso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable Long id) {
        gestionService.deleteEvento(id);
        return ResponseEntity.noContent().build();
    }
}

