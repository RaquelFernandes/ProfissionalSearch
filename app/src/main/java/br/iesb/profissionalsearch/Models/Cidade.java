package br.iesb.profissionalsearch.Models;

import java.io.Serializable;

/**
 * Created by Raquel on 04/06/2017.
 */

public class Cidade implements Serializable {
    int id;
    String nome;

    public Cidade() {
    }

    public Cidade(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
