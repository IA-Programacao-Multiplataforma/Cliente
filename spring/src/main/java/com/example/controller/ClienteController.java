package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.controller.adapter.ClienteControllerAdapter;
import com.example.controller.dto.ClienteRequest;
import com.example.entity.Cliente;
import com.example.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteRepository repository;

    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Cliente criar(@RequestBody ClienteRequest request) {
        Cliente clienteParaSalvar = ClienteControllerAdapter.castPostRequest(request);
        return repository.salvar(clienteParaSalvar);
    }

    @GetMapping
    public List<Cliente> listar() {
        return repository.buscarTodos();
    }

    @GetMapping("/{id}")
    public Cliente buscar(@PathVariable String id) {
        return repository.buscarPorId(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable String id) {
        repository.deletar(id);
    }
}