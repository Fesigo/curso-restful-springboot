package com.example.cursorestfulspringboot.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.example.cursorestfulspringboot.model.Cliente;

import org.springframework.stereotype.Component;

@Component //é o spring que gerencia esse objeto. "inversão de controle"
public class ClienteRepository {
    
    private List <Cliente> clientes;
    private int nextCode;

    @PostConstruct
    public void criarClientes(){  
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();
        Cliente c3 = new Cliente();

        c1.setCodigo(1);
        c1.setNome("Jose");
        c1.setEndereco("Rua X, 99");
        c1.setSaldo(190);

        c2.setCodigo(2);
        c2.setNome("Maria");
        c2.setEndereco("Rua Y, 222");
        c2.setSaldo(333);

        c3.setCodigo(3);
        c3.setNome("Fernanda");
        c3.setEndereco("Rua Z, 44");
        c3.setSaldo(777);

        clientes = new ArrayList<Cliente>();
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);
    }

    public List<Cliente> getAllClientes(){
        return clientes;
    }

    public Cliente getClienteByCodigo(int codigo){
        for(Cliente aux : clientes) {
            if(aux.getCodigo() == codigo){
                return aux;
            }
        }
        return null;

        /*
        for(i=0; i<3; i++)
        {
            Cliente aux = clientes.get(i);
            if(aux.getCodigo() == codigo){
                cli = aux;
                break;
            }

        }
        */
    }

    public Cliente save(Cliente cliente)
    {
        cliente.setCodigo(nextCode++);
        clientes.add(cliente);
        return cliente;
    }

	public void remove(Cliente cliente) {
        clientes.remove(cliente);
	}

	public Cliente update(Cliente cliente) {
        Cliente aux = getClienteByCodigo(cliente.getCodigo());
        
        if(aux != null){
            aux.setEndereco(cliente.getEndereco());
            aux.setNome(cliente.getNome());
            aux.setSaldo(cliente.getSaldo());
        }

        return aux;
	}

}
