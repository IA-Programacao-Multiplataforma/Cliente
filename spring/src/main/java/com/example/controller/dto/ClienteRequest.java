package com.example.controller.dto;

import com.example.entity.Endereco;
import java.time.LocalDate;

public record ClienteRequest(
        String nome,
        LocalDate dataNascimento,
        Endereco endereco
) {}