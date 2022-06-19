package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "funcionario")
//@MappedSuperclass
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario", length = 5, unique = true)
    @NotNull
    private int id;

    @Column(name = "nome_funcionario", length = 50)
    @NotNull
    private String nome;

    @Column(name = "data_nascimento")
    @NotNull
    private LocalDate nascimento;

    @Column(name = "salario", length = 7)
    @NotNull
    private float salario;

    @Column(name = "telefone_funcionario", length = 11)
    @NotNull
    private String telefone;

	// -----------------------------------------------------

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nascimento=" + nascimento +
                ", salario=" + salario +
                ", telefone=" + telefone +
                '}';
    }
}