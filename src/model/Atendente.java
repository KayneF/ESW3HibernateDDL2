package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "atendente")
public class Atendente extends Funcionario {

    @Column(name = "hora_entrada")
    @NotNull
    private int horarioEntrada;

    @Column(name = "hora_saida")
    @NotNull
    private int horarioSaida;

    @Column(name = "email_atendente", length = 100)
    @NotNull
    private String emailAtendente;

	// -----------------------------------------------------

    public int getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(int horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public int getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(int horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public String getEmailAtendente() {
        return emailAtendente;
    }

    public void setEmailAtendente(String emailAtendente) {
        this.emailAtendente = emailAtendente;
    }

    @Override
    public String toString() {
        return "Atendente{" +
                "horarioEntrada=" + horarioEntrada +
                ", horarioSaida=" + horarioSaida +
                ", emailAtendente='" + emailAtendente + '\'' +
                '}';
    }
}