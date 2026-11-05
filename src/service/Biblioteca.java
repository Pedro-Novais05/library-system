package service;

import model.Autor;
import model.Disponibilidade;
import model.Emprestimo;
import model.Livro;
import util.Formatadador_Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Biblioteca (){
        incializarDados();
    }

    private void incializarDados(){
        Autor machadoDeAssis = new Autor("Machado de Assis", LocalDate.parse("21/06/1839", Formatadador_Data.formatter));
        autores.add(machadoDeAssis);

        Livro domCasmurro = new Livro("Dom Casmurro", machadoDeAssis);
        Livro memoriasPostumas = new Livro("Memórias Postumas de Brás Cubas", machadoDeAssis);
        Livro oAlienista = new Livro("O Alienista", machadoDeAssis);
        livros.add(domCasmurro);
        livros.add(memoriasPostumas);
        livros.add(oAlienista);

        Autor clarice = new Autor("Clarice Lispector", LocalDate.parse("10/12/1920", Formatadador_Data.formatter));
        autores.add(clarice);

        Livro horaEstrela = new Livro("A Hora da Estrela", clarice);
        Livro aPaixao = new Livro("A Paixão Segundo G.H.", clarice);
        Livro coracao = new Livro("Perto do Coração Selvagem", clarice);
        livros.add(horaEstrela);
        livros.add(aPaixao);
        livros.add(coracao);

        Autor georgeOrwell = new Autor("George Orwell", LocalDate.parse("25/06/1903", Formatadador_Data.formatter));
        autores.add(georgeOrwell);

        Livro g1984 = new Livro("1984", georgeOrwell);
        Livro revolucao = new Livro("A Revolução dos Bichos", georgeOrwell);
        Livro caminho = new Livro("A Caminho de Wigan", georgeOrwell);
        livros.add(g1984);
        livros.add(revolucao);
        livros.add(caminho);

        Autor gabrieGarcia = new Autor("Gabriel Garcia Márquez", LocalDate.parse("06/02/1927", Formatadador_Data.formatter));
        autores.add(gabrieGarcia);

        Livro cemAnos= new Livro("Cem Anos de Solidão", gabrieGarcia);
        Livro oAmor = new Livro("O Amor nos Tempos do Cólera", gabrieGarcia);
        Livro cronica = new Livro("Crônica de uma Morte Anunciada", gabrieGarcia);
        livros.add(cemAnos);
        livros.add(oAmor);
        livros.add(cronica);
    }

    public List<Livro> getLivrosDisponiveis(){
        List<Livro> disponiveis = new ArrayList<>();
        for (Livro livro: livros){
            if (livro.getDisponibilidade() == Disponibilidade.DISPONIVEL){
                disponiveis.add(livro);
            }
        }
        return disponiveis;
    }

    public void realizarEmprestimo(int id, String nomeCliente){


        LocalDate dataAtual = LocalDate.now();
        LocalDate dataVencimento = dataAtual.plusDays(40);

        getLivrosDisponiveis();
        for (Livro livro : livros){
            if (livro.getId() == id){

                Emprestimo emprestimo = new Emprestimo(livro, nomeCliente, dataAtual, dataVencimento);
                emprestimos.add(emprestimo);

                System.out.println("\nEmpréstimo concluído para o cliente: " + nomeCliente + "!!!");
                System.out.println("O livro selecionado foi: " + livro );
                livro.setDisponibilidade(Disponibilidade.INDISPONIVEL);
                System.out.println("Data de empréstimo: " + dataAtual.format(Formatadador_Data.formatter));
                System.out.println("Data máxima para devolução: " + dataVencimento.format(Formatadador_Data.formatter));
            }
        }
    }

}


