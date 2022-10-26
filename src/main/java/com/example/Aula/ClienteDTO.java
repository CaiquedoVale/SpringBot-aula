package com.example.Aula;

public class ClienteDTO {

    private String nome;
    private String endereco;

    public ClienteDTO() {
    }

    public ClienteDTO(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
