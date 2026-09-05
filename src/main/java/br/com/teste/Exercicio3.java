package br.com.teste;

import static spark.Spark.*;

public class Exercicio3 {

    public static void main(String[] args) {
    	
    	// Define a porta utilizada pelo servidor Spark.
        port(4568);

        System.out.println("EXECUTANDO EXERCICIO 3");
        
        // Cria o objeto DAO para realizar as operações no banco de dados.
        AlunoDAO dao = new AlunoDAO();
        
        // Exibe o formulário HTML de cadastro de alunos.
        get("/", (req, res) -> {

            String html =
                    "<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<meta charset='UTF-8'>"
                    + "<title>Cadastro de Alunos</title>"
                    + "</head>"
                    + "<body>"
                    + "<h1>Cadastro de Alunos</h1>"
                    + "<form method='post' action='/cadastrar'>"
                    + "<label>ID:</label>"
                    + "<input type='number' name='id'>"
                    + "<br><br>"
                    + "<label>Nome:</label>"
                    + "<input type='text' name='nome'>"
                    + "<br><br>"
                    + "<label>Curso:</label>"
                    + "<input type='text' name='curso'>"
                    + "<br><br>"
                    + "<label>Idade:</label>"
                    + "<input type='number' name='idade'>"
                    + "<br><br>"
                    + "<button type='submit'>Cadastrar</button>"
                    + "</form>"
                    + "</body>"
                    + "</html>";

            return html;
        });
        
        // Recebe os dados enviados pelo formulário e cadastra o aluno.
        post("/cadastrar", (req, res) -> {
        	
        	// Obtém os dados enviados pelo formulário.
            int id = Integer.parseInt(req.queryParams("id"));
            String nome = req.queryParams("nome");
            String curso = req.queryParams("curso");
            int idade = Integer.parseInt(req.queryParams("idade"));

            Aluno aluno = new Aluno(id, nome, curso, idade);

            dao.inserir(aluno);

            return "Aluno cadastrado com sucesso!";
        });
        
        // lista os alunos cadastrados no banco de dados em uma página HTML.
        get("/listar", (req, res) -> {
            return dao.listar();
        });
    }
}