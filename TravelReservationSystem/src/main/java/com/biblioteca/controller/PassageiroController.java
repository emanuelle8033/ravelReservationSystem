package com.biblioteca.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.biblioteca.model.Passageiro;
import com.biblioteca.service.PassageiroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/passageiros")
@Tag(name = "Passageiros", description = "API para gerenciamento de passageiros")
public class PassageiroController {

    @Autowired
    private PassageiroService passageiroService;

    @GetMapping
    @Operation(summary = "Listar todos os passageiros")
    public ResponseEntity<List<Passageiro>> findAll() {
        return ResponseEntity.ok(passageiroService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar passageiro por ID")
    public ResponseEntity<Passageiro> findById(@PathVariable Long id) {
        return passageiroService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Criar novo passageiro")
    public ResponseEntity<Passageiro> create(@RequestBody Passageiro passageiro) {
        Passageiro saved = passageiroService.save(passageiro);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar passageiro")
    public ResponseEntity<Passageiro> update(@PathVariable Long id, @RequestBody Passageiro passageiro) {
        Passageiro updated = passageiroService.update(id, passageiro);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir passageiro")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        passageiroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}