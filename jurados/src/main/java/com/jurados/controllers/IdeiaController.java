package com.jurados.controllers;

import com.jurados.entities.IdeiaEntity;
import com.jurados.services.IdeiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ideia")
public class IdeiaController {
    
    @Autowired
    private IdeiaService ideiaService;
    
    @PostMapping("/save")
    public ResponseEntity<IdeiaEntity> save(@RequestBody IdeiaEntity ideia) {
        return ResponseEntity.ok(ideiaService.save(ideia));
    }
    
    @GetMapping("/findById")
    public ResponseEntity<IdeiaEntity> findById(@RequestParam Long id) {
        return ResponseEntity.ok(ideiaService.findById(id));
    }
    
    @GetMapping("/findAll")
    public ResponseEntity<List<IdeiaEntity>> findAll() {
        return ResponseEntity.ok(ideiaService.findAll());
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        return ResponseEntity.ok(ideiaService.delete(id));
    }
    
    @PutMapping("/update")
    public ResponseEntity<IdeiaEntity> update(@RequestBody IdeiaEntity ideia) {
        return ResponseEntity.ok(ideiaService.update(ideia));
    }
}
