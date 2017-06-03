package br.iesb.profissionalsearch.Models;

import java.io.Serializable;

public class AreaAtuacao implements Serializable {

    int Id;
    String Nome;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
