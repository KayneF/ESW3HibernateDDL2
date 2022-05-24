package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

@Entity
@Table(name = "atendente")
public class Atendente extends Funcionario {

    @Column(name = "hora_entrada")
    @NotNull
    private LocalTime horarioEntrada;

    @Column(name = "hora_saida")
    @NotNull
    private LocalTime horarioSaida;

    @Column(name = "email_atendente", length = 100)
    @NotNull
    private String emailAtendente;

	// -----------------------------------------------------

    public LocalTime getHorarioEntrada() {
        return horarioEntrada;
    }

    public void setHorarioEntrada(LocalTime horarioEntrada) {
        this.horarioEntrada = horarioEntrada;
    }

    public LocalTime getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(LocalTime horarioSaida) {
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