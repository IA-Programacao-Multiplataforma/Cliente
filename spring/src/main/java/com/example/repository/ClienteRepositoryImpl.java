package com.example.repository;

import com.example.entity.Cliente;
import com.example.repository.adapter.ClienteRepositoryAdapter;
import com.example.repository.mongo.ClienteRepositoryWithMongoDB;
import com.example.repository.orm.ClienteOrmMongo;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {
    private final ClienteRepositoryWithMongoDB mongoRepo;

    public ClienteRepositoryImpl(ClienteRepositoryWithMongoDB mongoRepo) {
        this.mongoRepo = mongoRepo;
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        ClienteOrmMongo orm = ClienteRepositoryAdapter.castEntity(cliente);
        ClienteOrmMongo salvo = mongoRepo.save(orm);
        return ClienteRepositoryAdapter.castOrm(salvo);
    }
    @Override
    public List<Cliente> buscarTodos() {
        return mongoRepo.findAll().stream()
                .map(orm -> new Cliente(orm.id(), orm.nome(), orm.dataNascimento(), orm.endereco()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Cliente> buscarPorId(String id) {
        return mongoRepo.findById(id).map(orm -> new Cliente(orm.id(), orm.nome(), orm.dataNascimento(), orm.endereco()));
    }

    @Override
    public void deletar(String id) {
        mongoRepo.deleteById(id);
    }
}