package com.example.cursorestfulspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @GetMapping("/clientes")
    public String getClientes(){
        return "vai retornar TODOS os clientes";
    }

    @GetMapping("/clientes/{codigo}")
    public String getCliente(@PathVariable int codigo){
        return "vai retornar UM cliente pelo codigo" + codigo;
    }
    
}