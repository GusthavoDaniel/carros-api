package com.catalogo.carros.controller;

import com.catalogo.carros.model.Carro;
import com.catalogo.carros.service.CarroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/carros")
public class CarroController {
    private final CarroService service;

    public CarroController(CarroService service) {
        this.service = service;
    }

    @GetMapping("/potencia")
    public List<Carro> getCarrosMaisPotentes() {
        return service.getCarrosMaisPotentes();
    }

    @GetMapping("/economia")
    public List<Carro> getCarrosMaisEconomicos() {
        return service.getCarrosMaisEconomicos();
    }

    @GetMapping("/eletricos")
    public List<Carro> getCarrosEletricos() {
        return service.getCarrosEletricos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> getCarroById(@PathVariable Long id) {
        Optional<Carro> carro = service.getCarroById(id);
        return carro.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Carro> create(@RequestBody Carro carro) {
        Carro savedCarro = service.save(carro);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCarro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}