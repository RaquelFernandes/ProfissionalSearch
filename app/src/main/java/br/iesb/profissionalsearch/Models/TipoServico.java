package br.iesb.profissionalsearch.Models;

import java.io.Serializable;

/**
 * Created by Raquel on 04/06/2017.
 */

public class TipoServico implements Serializable {

    String id;
    String nome;

    public TipoServico() {
    }

    public TipoServico(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
