package com.catalogo.carros.repository;

import com.catalogo.carros.model.Carro;
import com.catalogo.carros.model.TipoCarro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
    List<Carro> findTop10ByOrderByPotenciaDesc();
    List<Carro> findTop10ByOrderByEconomiaDesc();
    List<Carro> findByTipo(TipoCarro tipo);
}