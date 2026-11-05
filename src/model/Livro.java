package model;

import java.time.LocalDate;

public class Livro {
    private int id;
    private String titulo;
    private Autor autor;
    private Disponibilidade disponibilidade;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;
    private static int contadorId =1;

    public Livro (String titulo, Autor autor){
        this.id = contadorId++;
        this.autor = autor;
        this.titulo = titulo;
        this.disponibilidade = Disponibilidade.DISPONIVEL;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public String toString() {
        return this.titulo;
    }

}
