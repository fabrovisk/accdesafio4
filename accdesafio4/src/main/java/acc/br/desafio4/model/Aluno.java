package acc.br.desafio4.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.util.Objects;

@EntityScan
@Table(name = "ALUNO")
public class Aluno {

    @Id
    private Long id;

    private String nome;
    private String curso;
    private String cep;
    private String localidade;
    private LocalDate dataNascimento;

    public Aluno() {}
    
    public Aluno(Long id, String nome, String cep, String localidade, LocalDate dataNascimento, String curso) {
        this.id = id;
        this.nome = nome;
        this.cep = cep;
        this.localidade = localidade;
        this.dataNascimento = dataNascimento;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno that = (Aluno) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cep='" + cep + '\'' +
                ", localidade='" + localidade + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", curso='" + curso + '\'' +
                '}';
    }
}
