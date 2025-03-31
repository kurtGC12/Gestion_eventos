package com.gestion_eventos.repository;


import com.gestion_eventos.model.Evento;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class GestionRepository {
    private final List<Evento> eventos = new ArrayList<>();

    public GestionRepository() {
        eventos.add(new Evento(1, "CXVET 2025", "Santiago, Chile",
        "Primer Encuentro Latinoamericano de Cirugía Veterinaria para animales de compañía, exóticos y equinos.", "2025-04-3"));
        eventos.add(new Evento(2, "Feria de adopción 2025", "Parque Central",
         "Un evento gratuito para los amantes de los animales, con actividades para toda la familia.","2025-04-15"));
        eventos.add(new Evento(3, "Expo Mascotas & Animales 2025", "Espacio Riesco, Huechuraba, Santiago","", "2025-05-20"));
        eventos.add(new Evento(4, "Dog Race By Dog Chow 2025", "Por confirmar",
        "Una carrera diseñada para que los perros y sus dueños disfruten juntos. Habrá dos circuitos: 2,5 km para perros pequeños y 3 km para perros medianos y grandes. ", "Por confirmar"));
        eventos.add(new Evento(5, "Exposición Internacional Aniversario 90 Años Kennel Club de Chile","Por confirmar"
        ,"Evento organizado por el Kennel Club de Chile que celebra su 90º aniversario. Incluirá exposiciones de diversas razas caninas y actividades relacionadas.", "2025-04-13"));
        eventos.add(new Evento(6, "Mascota Fest 2026", "Malloco",
        "Evento familiar con diversas actividades dedicadas a las mascotas.", "2026-04-29"));
        
    }

    public List<Evento> obtenerTodosLosEventos() {
        return eventos;
    }

    public Optional<Evento> buscarPorId(int id) {
        return eventos.stream().filter(e -> e.getId() == id).findFirst();
    }
}