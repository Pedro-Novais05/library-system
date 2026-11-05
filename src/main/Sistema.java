package main;

import model.Livro;
import service.Biblioteca;

import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {

        Biblioteca livrosDisponiveis = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;

        while(rodando) {
            System.out.println("\nBem vindo (a) à service.Biblioteca PHN. Deseja ver os livros disponíveis? (SIM/NÃO)");
            String resposta = scanner.nextLine();

            if (resposta.equalsIgnoreCase("NÃO")) {
                System.out.println("\nTudo bem! Nos vemos na próxima!");
                rodando = false;

            } else if (resposta.equalsIgnoreCase("SIM")) {
                System.out.println("\nSegue abaixo a lista de Livros disponíveis:");

                for (Livro livro : livrosDisponiveis.getLivrosDisponiveis()) {
                    System.out.printf("%d - %s (model.Autor: %s)%n", livro.getId(), livro.getTitulo(), livro.getAutor().getNome());
                }

                boolean operacaoConcluida = true;

                while (operacaoConcluida) {
                    try {
                        System.out.println("\n\nSelecione por ID (Número) o livro desejado:");
                        int escolha = scanner.nextInt();
                        scanner.nextLine();

                        if (escolha < 1 || escolha > 12) {
                            System.err.println("Escolha uma opção válida");
                            throw new IllegalArgumentException("ID fora do intervalo permitido");
                        }

                        System.out.println("\nDigite o seu nome: ");
                        String nome = scanner.nextLine();

                        livrosDisponiveis.realizarEmprestimo(escolha, nome);
                        System.out.println("\n---PRESSIONE ENTER PARA VOLTAR AO MENU PRINCIPAL---");
                        scanner.nextLine();

                        operacaoConcluida = false;

                    } catch (IllegalArgumentException e) {
                        System.err.println("Coloque um valor válido entre 1 e 12");
                    }
                }
            } else {
                System.out.println("Resposta inválida: Digite 'SIM' ou 'NÃO' ");
            }
        }
    }
}
