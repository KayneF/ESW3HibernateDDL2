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

    @ManyToOne(targetEntity = Atendimento.class)
    @JoinColumn(name = "atendimento_cliente", referencedColumnName = "atendimento_cliente")
    @NotNull
    private Atendimento atendimento;

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

}