package com.example.repository;

import com.example.entity.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteRepository {
    Cliente salvar(Cliente cliente);
    List<Cliente> buscarTodos();
    Optional<Cliente> buscarPorId(String id);
    void deletar(String id);
}