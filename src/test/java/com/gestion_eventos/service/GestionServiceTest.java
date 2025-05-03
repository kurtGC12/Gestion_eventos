package com.gestion_eventos.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gestion_eventos.model.Evento;
import com.gestion_eventos.repository.GestionRepository;

@ExtendWith(MockitoExtension.class)
public class GestionServiceTest {

    @InjectMocks
    private GestionServiceimpl eventoService;

    @Mock
    private GestionRepository eventoRepository;

    @Test
    public void guardarEventoCaninoTest() {
        Evento evento = new Evento();
        evento.setNombre("Exposición Canina Mundial de Italia 2026");
        evento.setUbicacion("Italian Kennel Club");
        evento.setDescripcion("Uno de los eventos caninos más prestigiosos a nivel mundial.");
        evento.setFecha("2026-06-04");

        when(eventoRepository.save(any(Evento.class))).thenReturn(evento);

        Evento resultado = eventoService.createEvento(evento);

        assertEquals("Exposición Canina Mundial de Italia 2026", resultado.getNombre());
        assertEquals("Italian Kennel Club", resultado.getUbicacion());
        assertEquals("Uno de los eventos caninos más prestigiosos a nivel mundial.", resultado.getDescripcion());
        assertEquals("2026-06-04", resultado.getFecha());
    }
}
