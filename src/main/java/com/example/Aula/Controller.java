package com.example.Aula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.ref.Cleaner;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cliente/v1/")
public class Controller {


    @Autowired
    Repository repository;


    @PostMapping
    public Cliente create(@RequestBody Cliente cliente){
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
    public void deleteClienteById(@PathVariable Long id){
        repository.deleteById(id);
    }
    @GetMapping
    public List<Cliente> listClientes()
    {
        return repository.findAll();
    }
}