package com.gestion_eventos.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.gestion_eventos.model.Evento;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class GestionRepositoryTest {

    @Autowired
    private GestionRepository gestionRepository;

    @Test
    public void guardarEventoTest() {
        Evento evento = new Evento();
        evento.setNombre("Exposición Canina Mundial de Italia 2026");
        evento.setUbicacion("Italian Kennel Club");
        evento.setDescripcion("Uno de los eventos caninos más prestigiosos a nivel mundial.");
        evento.setFecha("2026-06-04");

        Evento resultado = gestionRepository.save(evento);

        assertNotNull(resultado.getId()); 
        assertEquals("Exposición Canina Mundial de Italia 2026", resultado.getNombre());
        assertEquals("Italian Kennel Club", resultado.getUbicacion());
        assertEquals("Uno de los eventos caninos más prestigiosos a nivel mundial.", resultado.getDescripcion());
        assertEquals("2026-06-04", resultado.getFecha());
    }
}
