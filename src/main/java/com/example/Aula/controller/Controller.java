package com.example.Aula.controller;

import com.example.Aula.entity.Produto;
import com.example.Aula.repository.Repository;
import com.example.Aula.dto.ClienteDTO;
import com.example.Aula.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cliente/v1/")
public class Controller {


    @Autowired
    Repository repository;


    @PostMapping
    public Cliente create(@RequestBody @Valid Cliente cliente){
        for(Produto p : cliente.getProduto())
        {
            Produto produto = new Produto(p.getNome() , p.getPrecoUnitario() , p.getPrecoTotal() , p.getQuantidade());
            p.setPrecoTotal(produto.getPrecoTotal());
        }
        Cliente clienteSaved = repository.save(cliente);
        return clienteSaved;
    }

    @GetMapping({"/{id}"})
    @ResponseBody
    public Optional<Cliente> getClienteById(@PathVariable Long id){
        Optional<Cliente> clienteReturned = this.repository.findById(id);
        return clienteReturned;
    }

    @DeleteMapping("/{id}")
    public String deleteClienteById(@PathVariable Long id)
    {
        try
        {
            Optional<Cliente> cliente = Optional.of(repository.getById(id));
            if(cliente.isPresent())
            {
                repository.deleteById(id);
                return "Cliente de " + id + " deletado com sucesso!";
            }
            else
            {
                throw new Exception("Cliente inexistente!");
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "O cliente de " + id + " não existe no banco de dados!";
        }
    }

    @GetMapping
    public List<Cliente> listClientes()
    {
        return repository.findAll();
    }

    @PutMapping("/atualize/{id}")
    public String updateClienteById(@RequestBody ClienteDTO clienteDTO, @PathVariable Long id){
        Optional<Cliente> oldCliente = repository.findById(id);
        if (oldCliente.isPresent()){
            Cliente cliente = oldCliente.get();
            cliente.setEndereco(clienteDTO.getEndereco());
            repository.save(cliente);
            return "Cliente do id " + cliente.getId() + "atualizado com sucesso!";
        }else{
            return "Cliente do id " + id + "não existe!";

        }
    }
}