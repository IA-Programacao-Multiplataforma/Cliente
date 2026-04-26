package com.example.controller.adapter;

import com.example.controller.dto.ClienteRequest;
import com.example.entity.Cliente;
import java.util.UUID;

public class ClienteControllerAdapter {

    private ClienteControllerAdapter() {}

    public static Cliente castPostRequest(ClienteRequest request) {
        return new Cliente(
                UUID.randomUUID().toString(),
                request.nome(),
                request.dataNascimento(),
                request.endereco()
        );
    }
}