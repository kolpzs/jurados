package com.jurados.controllers;

import com.jurados.entities.AdmEntity;
import com.jurados.services.AdmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adm")
public class AdmController {

    @Autowired
    private AdmService admService;

    @PostMapping("/save")
    public ResponseEntity<AdmEntity> save(@RequestBody AdmEntity adm) {
        return ResponseEntity.ok(admService.save(adm));
    }

    @GetMapping("/findById")
    public ResponseEntity<AdmEntity> findById(@RequestParam Long id) {
        return ResponseEntity.ok(admService.findById(id));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<AdmEntity>> findAll() {
        return ResponseEntity.ok(admService.findAll());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        return ResponseEntity.ok(admService.delete(id));
    }

    @PutMapping("/update")
    public ResponseEntity<AdmEntity> update(@RequestBody AdmEntity adm) {
        return ResponseEntity.ok(admService.update(adm));
    }
}
