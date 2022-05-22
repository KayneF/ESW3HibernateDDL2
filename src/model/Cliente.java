package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@Column(name = "cpf", length = 11)
	@NotNull
	private int cpf;

	@Column(name = "nome_cliente", length = 100)
	@NotNull
	private String nome;

	@Column(name = "telefone_cliente", length = 11)
	@NotNull
	private int telefone;

	@Column(name = "email_cliente", length = 100)
	@NotNull
	private String email;

	@Column(name = "pronome_trat", length = 3)
	@NotNull
	private PronomeTratamento pronomeTratamento;

	@ManyToOne(targetEntity = Atendimento.class)
	@JoinColumn(name = "atendimento_cliente", referencedColumnName = "atendimento_cliente")
	@NotNull
	private Atendimento atendimento;

	// -----------------------------------------------------

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PronomeTratamento getPronomeTratamento() {
		return pronomeTratamento;
	}

	public void setPronomeTratamento(PronomeTratamento pronomeTratamento) {
		this.pronomeTratamento = pronomeTratamento;
	}

	@Override
	public String toString() {
		return "Cliente{" +
				"CPF=" + cpf +
				", nome='" + nome + '\'' +
				", telefone=" + telefone +
				", email='" + email + '\'' +
				", pronomeTratamento=" + pronomeTratamento +
				'}';
	}
}
