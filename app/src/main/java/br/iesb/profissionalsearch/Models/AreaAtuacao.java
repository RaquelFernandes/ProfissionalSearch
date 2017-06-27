package br.iesb.profissionalsearch.Models;

import android.hardware.Camera;

import java.io.Serializable;

public class AreaAtuacao implements Serializable {

    int id;
    String nome;

    public AreaAtuacao(){

    }

    public AreaAtuacao(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
