package br.iesb.profissionalsearch.Models;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Created by Raquel on 04/06/2017.
 */

public class Estado implements Serializable {

    int id;
    String nome;
    ArrayList<Cidade> cidades;

    public Estado() {
    }

    public Estado(int id, String nome, ArrayList<Cidade> cidades) {
        this.id = id;
        this.nome = nome;
        this.cidades = cidades;
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

    public ArrayList<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(ArrayList<Cidade> cidades) {
        this.cidades = cidades;
    }
}
