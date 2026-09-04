package br.com.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AlunoDAO {
	
	// Dados utilizados para conectar ao banco de dados PostgreSQL.
    private String url = "jdbc:postgresql://localhost:5432/teste";
    private String usuario = "ti2cc";
    private String senha = "ti@cc";
    
    // Estabelece a conexão com o banco de dados.
    public Connection conectar() {

        try {
            return DriverManager.getConnection(url, usuario, senha);

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados.", e);
        }
    }
    
    // Insere um novo aluno na tabela aluno.
    public void inserir(Aluno aluno) {

        String sql = "INSERT INTO aluno (id, nome, curso, idade) VALUES (?, ?, ?, ?)";

        try (Connection conexao = conectar();
             java.sql.PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, aluno.getId());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getCurso());
            stmt.setInt(4, aluno.getIdade());

            stmt.executeUpdate();

            System.out.println("Aluno inserido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir aluno.", e);
        }
    }
    
    // Lista todos os alunos cadastrados.
    public String listar() {

        String sql = "SELECT * FROM aluno";

        String html = "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<meta charset='UTF-8'>"
                + "<title>Lista de Alunos</title>"
                + "</head>"
                + "<body>"
                + "<h1>Lista de Alunos</h1>"
                + "<table border='1'>"
                + "<tr>"
                + "<th>ID</th>"
                + "<th>Nome</th>"
                + "<th>Curso</th>"
                + "<th>Idade</th>"
                + "</tr>";

        try (Connection conexao = conectar();
             java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
             java.sql.ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {

                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String curso = resultado.getString("curso");
                int idade = resultado.getInt("idade");

                html += "<tr>"
                        + "<td>" + id + "</td>"
                        + "<td>" + nome + "</td>"
                        + "<td>" + curso + "</td>"
                        + "<td>" + idade + "</td>"
                        + "</tr>";
            }

        } catch (SQLException e) {

            throw new RuntimeException("Erro ao listar alunos.", e);
        }

        html += "</table>"
                + "</body>"
                + "</html>";

        return html;
    }
    
    // Exclui um aluno pelo seu ID.
    public void excluir(int id) {

        String sql = "DELETE FROM aluno WHERE id = ?";

        try (Connection conexao = conectar();
             java.sql.PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Aluno excluido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir aluno.", e);
        }
    }
    
    // Atualiza os dados de um aluno pelo seu ID.
    public void atualizar(Aluno aluno) {

        String sql = "UPDATE aluno SET nome = ?, curso = ?, idade = ? WHERE id = ?";

        try (Connection conexao = conectar();
             java.sql.PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCurso());
            stmt.setInt(3, aluno.getIdade());
            stmt.setInt(4, aluno.getId());

            stmt.executeUpdate();

            System.out.println("Aluno atualizado com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar aluno.", e);
        }
    }
}