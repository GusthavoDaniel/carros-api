package com.catalogo.carros.service;

import com.catalogo.carros.model.Carro;
import com.catalogo.carros.model.TipoCarro;
import com.catalogo.carros.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {
    private final CarroRepository repository;

    public CarroService(CarroRepository repository) {
        this.repository = repository;
    }

    public List<Carro> getCarrosMaisPotentes() {
        return repository.findTop10ByOrderByPotenciaDesc();
    }

    public List<Carro> getCarrosMaisEconomicos() {
        return repository.findTop10ByOrderByEconomiaDesc();
    }

    public List<Carro> getCarrosEletricos() {
        return repository.findByTipo(TipoCarro.ELETRICO);
    }

    public Optional<Carro> getCarroById(Long id) {
        return repository.findById(id);
    }

    public Carro save(Carro carro) {
        return repository.save(carro);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}