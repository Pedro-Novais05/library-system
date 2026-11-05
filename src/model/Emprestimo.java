package model;

import java.time.LocalDate;

public class Emprestimo {
    private int id;
    private Livro livroEmprestado;
    private String nomeCliente;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private static int contadorId = 1;

    public Emprestimo(Livro livroEmprestado, String nomeCliente, LocalDate dataEmprestimo, LocalDate dataDevolucao){
        this.id = contadorId++;
        this.livroEmprestado = livroEmprestado;
        this.nomeCliente = nomeCliente;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public int getId() {
        return id;
    }

    public Livro getLivroEmprestado() {
        return livroEmprestado;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
}
