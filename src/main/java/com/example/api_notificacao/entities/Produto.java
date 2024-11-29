package com.example.api_notificacao.entities;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Produto {

    private UUID id = UUID.randomUUID();
    private String nome;
    private Double valor;
}