package com.catalogo.carros.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String modelo;
    private int ano;
    private int potencia;
    private double economia;

    @Enumerated(EnumType.STRING)
    private TipoCarro tipo;

    private double preco;
}