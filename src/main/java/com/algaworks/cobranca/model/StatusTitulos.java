package com.algaworks.cobranca.model;

/**
 * Created by rchibana on 2017/03/24.
 */
public enum StatusTitulos {

    PENDENTE("Pendente"),
    RECEBIDO("Recebido");

    private String descricao;

    StatusTitulos(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
