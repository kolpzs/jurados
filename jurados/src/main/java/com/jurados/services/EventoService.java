package com.jurados.services;

import com.jurados.entities.EventoEntity;
import com.jurados.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public EventoEntity save(EventoEntity evento) {
        return eventoRepository.save(evento);
    }

    public List<EventoEntity> findAll() {
        return eventoRepository.findAll();
    }

    public EventoEntity findById(Long id) {
        return eventoRepository.findById(id).orElseThrow();
    }

    public String delete(Long id) {
        EventoEntity evento = findById(id);
        String nome = evento.getNome();
        eventoRepository.delete(evento);
        return "Evento " + nome + "deletado com sucesso!";
    }

    public EventoEntity update(EventoEntity evento) {
        return eventoRepository.save(evento);
    }
}
