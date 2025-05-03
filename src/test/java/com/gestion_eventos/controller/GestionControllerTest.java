package com.gestion_eventos.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.gestion_eventos.model.Evento;
import com.gestion_eventos.service.GestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(GestionController.class)  // Prueba de un controlador específico
public class GestionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GestionService gestionServiceMock;

    @InjectMocks
    private GestionController gestionController;  // Inyectar el controlador con el servicio

    @Test
    public void obtenerTodosLosEventosTest() throws Exception {
        Evento evento1 = new Evento();
        evento1.setId(1L);
        evento1.setNombre("Exposición Canina Mundial de Italia 2026");
        evento1.setUbicacion("Italian Kennel Club");
        evento1.setDescripcion("Uno de los eventos caninos más prestigiosos a nivel mundial.");
        evento1.setFecha("2026-06-04");

        Evento evento2 = new Evento();
        evento2.setId(2L);
        evento2.setNombre("Exposición Canina del Westminster Kennel Club");
        evento2.setUbicacion("Madison Square Garden");
        evento2.setDescripcion("Los perros compiten en diferentes grupos (Deportivo, Sabueso, Perro de Trabajo, etc.)");
        evento2.setFecha("2026-02-20");

        when(gestionServiceMock.getAllEventos()).thenReturn(List.of(evento1, evento2));

        mockMvc.perform(get("/eventos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nombre").value("Exposición Canina Mundial de Italia 2026"))
                .andExpect(jsonPath("$[1].nombre").value("Exposición Canina del Westminster Kennel Club"));
    }

    @Test
    public void obtenerEventoPorIdTest() throws Exception {
        Evento evento = new Evento();
        evento.setId(1L);
        evento.setNombre("Exposición Canina Mundial de Italia 2026");
        evento.setUbicacion("Italian Kennel Club");
        evento.setDescripcion("Uno de los eventos caninos más prestigiosos a nivel mundial.");
        evento.setFecha("2026-06-04");

        when(gestionServiceMock.getEventoById(1L)).thenReturn(Optional.of(evento));

        mockMvc.perform(get("/eventos/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Exposición Canina Mundial de Italia 2026"))
                .andExpect(jsonPath("$.ubicacion").value("Italian Kennel Club"));
    }

    @Test
    public void crearEventoTest() throws Exception {
        Evento evento = new Evento();
        evento.setNombre("Exposición Canina Mundial de Italia 2026");
        evento.setUbicacion("Italian Kennel Club");
        evento.setDescripcion("Uno de los eventos caninos más prestigiosos a nivel mundial.");
        evento.setFecha("2026-06-04");

        when(gestionServiceMock.createEvento(any(Evento.class))).thenReturn(evento);

        mockMvc.perform(post("/eventos")
                .contentType("application/json")
                .content("{\"nombre\": \"Exposición Canina Mundial de Italia 2026\", \"ubicacion\": \"Italian Kennel Club\", \"descripcion\": \"Uno de los eventos caninos más prestigiosos a nivel mundial.\", \"fecha\": \"2026-06-04\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nombre").value("Exposición Canina Mundial de Italia 2026"))
                .andExpect(jsonPath("$.descripcion").value("Uno de los eventos caninos más prestigiosos a nivel mundial."));
    }

    @Test
    public void actualizarEventoTest() throws Exception {
        Evento evento = new Evento();
        evento.setId(1L);
        evento.setNombre("Exposición Canina Mundial de Italia 2026");
        evento.setUbicacion("Italian Kennel Club");
        evento.setDescripcion("Uno de los eventos caninos más prestigiosos a nivel mundial.");
        evento.setFecha("2026-06-04");

        when(gestionServiceMock.updateEvento(eq(1L), any(Evento.class))).thenReturn(evento);

        mockMvc.perform(put("/eventos/1")
                .contentType("application/json")
                .content("{\"nombre\": \"Exposición Canina Mundial de Italia 2026\", \"ubicacion\": \"Italian Kennel Club\", \"descripcion\": \"Uno de los eventos caninos más prestigiosos a nivel mundial.\", \"fecha\": \"2026-06-04\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Exposición Canina Mundial de Italia 2026"))
                .andExpect(jsonPath("$.descripcion").value("Uno de los eventos caninos más prestigiosos a nivel mundial."));
    }

    @Test
    public void eliminarEventoTest() throws Exception {
        mockMvc.perform(delete("/eventos/1"))
                .andExpect(status().isNoContent());  
    }
}