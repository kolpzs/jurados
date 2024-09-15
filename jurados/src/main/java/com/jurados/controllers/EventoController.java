package com.jurados.controllers;

import com.jurados.entities.EventoEntity;
import com.jurados.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController {
    
    @Autowired
    private EventoService eventoService;
    
    @PostMapping("/save")
    public ResponseEntity<EventoEntity> save(@RequestBody EventoEntity evento) {
        return ResponseEntity.ok(eventoService.save(evento));
    }
    
    @GetMapping("/findById")
    public ResponseEntity<EventoEntity> findById(@RequestParam Long id) {
        return ResponseEntity.ok(eventoService.findById(id));
    }
    
    @GetMapping("/findAll")
    public ResponseEntity<List<EventoEntity>> findAll() {
        return ResponseEntity.ok(eventoService.findAll());
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        return ResponseEntity.ok(eventoService.delete(id));
    }
    
    @PutMapping("/update")
    public ResponseEntity<EventoEntity> update(@RequestBody EventoEntity evento) {
        return ResponseEntity.ok(eventoService.update(evento));
    }
}
