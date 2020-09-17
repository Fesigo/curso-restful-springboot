package com.example.cursorestfulspringboot.controller;

import java.net.URI;
import java.util.List;

import com.example.cursorestfulspringboot.model.Cliente;
import com.example.cursorestfulspringboot.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Autowired //"amarra" à classe que é um componente, injetando esse objeto aqui. "Injeção de dependência"
    private ClienteRepository repositorio;

    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
        return repositorio.getAllClientes();
    }

    @DeleteMapping("/clientes/{codigo}")
    public ResponseEntity<Void> remover(@PathVariable int codigo){
        Cliente cliente = repositorio.getClienteByCodigo(codigo);
        
        if(cliente != null){
            repositorio.remove(cliente);
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/clientes/{codigo}")
    public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente, @PathVariable int codigo){
        

        if(repositorio.getClienteByCodigo(codigo) != null){
            cliente.setCodigo(codigo);
            repositorio.update(cliente);
            return ResponseEntity.ok(cliente);

        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/clientes/{codigo}")
    public ResponseEntity<Cliente> getCliente(@PathVariable int codigo){
        Cliente cliente = repositorio.getClienteByCodigo(codigo);
        
        if(cliente != null){
            return ResponseEntity.ok(cliente);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/clientes")
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente){ //essa anotação pega os dados do postman e salva
        Cliente novoCliente = repositorio.save(cliente);
        URI uri = URI.create("http://localhost:8080/clientes/" + novoCliente.getCodigo());
        return ResponseEntity.created(uri).build();
    }
}