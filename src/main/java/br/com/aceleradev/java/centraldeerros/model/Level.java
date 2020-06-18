package br.com.aceleradev.java.centraldeerros.model;

public enum Level {
    ERROR("error"), WARNING("warning"), INFO("info");

    private String descricao;

    Level(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
