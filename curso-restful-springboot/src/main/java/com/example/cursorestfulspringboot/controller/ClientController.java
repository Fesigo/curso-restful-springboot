package com.example.cursorestfulspringboot.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    List <Cliente> clientes;

    @PostConstruct
    public void criarClientes(){  
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();
        Cliente c3 = new Cliente();

        c1.codigo = 1;
        c1.nome = "Jose";
        c1.endereco = "Rua X, 99";
        c1.saldo = 190;

        c2.codigo = 2;
        c2.nome = "Maria";
        c2.endereco = "Rua Y, 222";
        c2.saldo = 333;

        c3.codigo = 3;
        c3.nome = "Fernanda";
        c3.endereco = "Rua Z, 44";
        c3.saldo = 777;

        clientes = Arrays.asList(c1,c2,c3);
    }

    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
        return clientes;
    }

    @GetMapping("/clientes/{codigo}")
    public Cliente getCliente(@PathVariable int codigo){

        Cliente cli = null;

        for(int i; i<3; i++)
        {
            Cliente aux = clientes.get(i);
            if(aux.codigo == codigo){
                cli = aux;
                break;
            }

        }

        for(Cliente aux : clientes)
        {
            if(aux.codigo == codigo){
                cli = aux;
                break;
            }
        }

        return cli;
    }
    
}