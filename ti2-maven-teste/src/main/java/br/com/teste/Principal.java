package br.com.teste;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AlunoDAO dao = new AlunoDAO();

        int opcao;
        
        // Exibe o menu principal e permite escolher uma operação do CRUD.
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1) Listar");
            System.out.println("2) Inserir");
            System.out.println("3) Excluir");
            System.out.println("4) Atualizar");
            System.out.println("5) Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = scanner.nextInt();

            switch (opcao) {
            	
            	// Lista os alunos cadastrados no banco de dados.
                case 1:
                    dao.listar();
                    break;
                
                // Solicita os dados e insere um novo aluno.
                case 2:
                    System.out.print("Digite o ID: ");
                    int id = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o curso: ");
                    String curso = scanner.nextLine();

                    System.out.print("Digite a idade: ");
                    int idade = scanner.nextInt();

                    Aluno aluno = new Aluno(id, nome, curso, idade);

                    dao.inserir(aluno);
                    break;
                    
                // Solicita o ID e exclui o aluno correspondente.
                case 3:
                    System.out.print("Digite o ID do aluno que deseja excluir: ");
                    int idExcluir = scanner.nextInt();

                    dao.excluir(idExcluir);
                    break;
                
                // Solicita os novos dados e atualiza o aluno.
                case 4:
                    System.out.print("Digite o ID do aluno: ");
                    int idAtualizar = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Digite o novo nome: ");
                    String novoNome = scanner.nextLine();

                    System.out.print("Digite o novo curso: ");
                    String novoCurso = scanner.nextLine();

                    System.out.print("Digite a nova idade: ");
                    int novaIdade = scanner.nextInt();

                    Aluno alunoAtualizado = new Aluno(
                        idAtualizar,
                        novoNome,
                        novoCurso,
                        novaIdade
                    );

                    dao.atualizar(alunoAtualizado);
                    break;
                
                // Encerra a execução do programa.
                case 5:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 5);

        scanner.close();
    }
}