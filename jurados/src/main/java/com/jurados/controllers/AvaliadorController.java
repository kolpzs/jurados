package com.jurados.controllers;

import com.jurados.entities.AvaliadorEntity;
import com.jurados.services.AvaliadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliador")
public class AvaliadorController {

    @Autowired
    private AvaliadorService avaliadorService;

    @PostMapping("/save")
    public ResponseEntity<AvaliadorEntity> save(@RequestBody AvaliadorEntity avaliador) {
        return ResponseEntity.ok(avaliadorService.save(avaliador));
    }

    @GetMapping("/findById")
    public ResponseEntity<AvaliadorEntity> findById(@RequestParam Long id) {
        return ResponseEntity.ok(avaliadorService.findById(id));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<AvaliadorEntity>> findAll() {
        return ResponseEntity.ok(avaliadorService.findAll());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        return ResponseEntity.ok(avaliadorService.delete(id));
    }

    @PutMapping("/update")
    public ResponseEntity<AvaliadorEntity> update(@RequestBody AvaliadorEntity avaliador) {
        return ResponseEntity.ok(avaliadorService.update(avaliador));
    }
}
