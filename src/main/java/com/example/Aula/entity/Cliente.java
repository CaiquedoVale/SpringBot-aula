package com.example.Aula.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cliente {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String endereco;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Produto> produto;

    public Cliente() {
    }

    public Cliente(String nome, String endereco, List<Produto> produtos ) {
        this.nome = nome;
        this.endereco = endereco;
        this.produto = produtos;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public List<Produto> getProduto() {
        return produto;
    }

    public void setProduto(List<Produto> produto) {
        this.produto = produto;
    }
}
