package com.example.cursorestfulspringboot.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import com.example.cursorestfulspringboot.model.Cliente;
import com.example.cursorestfulspringboot.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired //"amarra" à classe que é um componente, injetando esse objeto aqui. "Injeção de dependência"
    private ClienteRepository repositorio;

    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
        return repositorio.getAllClientes();
    }

    @GetMapping("/clientes/{codigo}")
    public Cliente getCliente(@PathVariable int codigo){
        return repositorio.getClienteByCodigo(codigo);
    }

    @PostMapping("/clientes")
    public Cliente salvar(@RequestBody Cliente cliente){ //essa anotação pega os dados do postman e salva
        return repositorio.save(cliente);
    }
}