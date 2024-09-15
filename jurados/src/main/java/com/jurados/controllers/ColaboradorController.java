package com.jurados.controllers;

import com.jurados.entities.ColaboradorEntity;
import com.jurados.services.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @PostMapping("/save")
    public ResponseEntity<ColaboradorEntity> save(@RequestBody ColaboradorEntity colaborador) {
        return ResponseEntity.ok(colaboradorService.save(colaborador));
    }

    @GetMapping("/findById")
    public ResponseEntity<ColaboradorEntity> findById(@RequestParam Long id) {
        return ResponseEntity.ok(colaboradorService.findById(id));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ColaboradorEntity>> findAll() {
        return ResponseEntity.ok(colaboradorService.findAll());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        return ResponseEntity.ok(colaboradorService.delete(id));
    }

    @PutMapping("/update")
    public ResponseEntity<ColaboradorEntity> update(@RequestBody ColaboradorEntity colaborador) {
        return ResponseEntity.ok(colaboradorService.update(colaborador));
    }
}
