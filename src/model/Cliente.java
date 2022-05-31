package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@Column(name = "cpf_cliente", length = 11)
	@NotNull
	private String cpf;

	@Column(name = "nome_cliente", length = 100)
	@NotNull
	private String nome;

	@Column(name = "telefone_cliente", length = 11)
	@NotNull
	private String telefone;

	@Column(name = "email_cliente", length = 100)
	private String email;

	@Column(name = "pronome_tratamento", length = 5)
	private String pronomeTratamento;

	// -----------------------------------------------------

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPronomeTratamento() {
		return pronomeTratamento;
	}

	public void setPronomeTratamento(String pronomeTratamento) {
		this.pronomeTratamento = pronomeTratamento;
	}

	@Override
	public String toString() {
		return "Cliente{" +
				"cpf=" + cpf +
				", nome='" + nome + '\'' +
				", telefone=" + telefone +
				", email='" + email + '\'' +
				", pronomeTratamento=" + pronomeTratamento +
				'}';
	}
}
