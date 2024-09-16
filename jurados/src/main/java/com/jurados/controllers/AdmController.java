package com.jurados.controllers;

import com.jurados.entities.AdmEntity;
import com.jurados.entities.AvaliadorEntity;
import com.jurados.entities.ColaboradorEntity;
import com.jurados.entities.EventoEntity;
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

    @PutMapping("/updateColaborador")
    public ResponseEntity<ColaboradorEntity> updateColaborador(@RequestBody ColaboradorEntity colaborador) {
        return ResponseEntity.ok(admService.updateColaborador(colaborador));
    }

    @PutMapping("/updateAvaliador")
    public ResponseEntity<AvaliadorEntity> updateAvaliador(@RequestBody AvaliadorEntity avaliador) {
        return ResponseEntity.ok(admService.updateAvaliador(avaliador));
    }

    @PostMapping("/saveEvento")
    public ResponseEntity<EventoEntity> saveEvento(@RequestBody EventoEntity evento) {
        return ResponseEntity.ok(admService.saveEvento(evento));
    }

    @PostMapping("/selecaoAvaliador")
    public ResponseEntity<EventoEntity> selecaoAvaliador(@RequestParam Long evento_id, @RequestParam List<Long> avaliadores_id) {
        return ResponseEntity.ok(admService.selecaoAvaliador(evento_id, avaliadores_id));
    }

    @PutMapping("/sorteiaIdeias/{id}")
    public ResponseEntity<EventoEntity> sorteiaIdeias(@PathVariable Long id) {
        return ResponseEntity.ok(admService.sorteiaIdeias(id));
    }
}
