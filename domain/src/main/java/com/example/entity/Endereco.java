package com.example.entity;


public record Endereco(
        String logradouro,
        String numero,
        String cidade,
        String estado
) {}