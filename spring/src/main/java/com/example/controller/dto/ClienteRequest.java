package com.example.controller.dto;

import java.time.LocalDate;

import com.example.entity.Endereco;

public record ClienteRequest(
        String nome,
        LocalDate dataNascimento,
        Endereco endereco
) {
        
}