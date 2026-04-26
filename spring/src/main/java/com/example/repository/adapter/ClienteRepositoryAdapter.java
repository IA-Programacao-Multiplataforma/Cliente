package com.example.repository.adapter;

import com.example.entity.Cliente;
import com.example.repository.orm.ClienteOrmMongo;

public class ClienteRepositoryAdapter {

    private ClienteRepositoryAdapter() {}

    public static Cliente castOrm(ClienteOrmMongo orm) {
        return new Cliente(
                orm.id(),
                orm.nome(),
                orm.dataNascimento(),
                orm.endereco()
        );
    }

    public static ClienteOrmMongo castEntity(Cliente entity) {
        return new ClienteOrmMongo(
                entity.id(),
                entity.nome(),
                entity.dataNascimento(),
                entity.endereco()
        );
    }
}