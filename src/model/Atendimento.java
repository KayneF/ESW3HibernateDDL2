package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "atendimento")
public class Atendimento {

    @Id
    @Column(name = "data_atendimento")
    @NotNull
    private LocalDateTime dataAtendimento;

    @Id
    @ManyToOne
    @JoinColumn(name = "atend_cliente")
    @NotNull
    private Cliente atendCliente;

    @Id
    @ManyToOne
    @JoinColumn(name = "atend_atendente")
    @NotNull
    private Atendente atendAtendente;

    // -----------------------------------------------------

    public LocalDateTime getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(LocalDateTime dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public Cliente getAtendCliente() {
        return atendCliente;
    }

    public void setAtendCliente(Cliente atendCliente) {
        this.atendCliente = atendCliente;
    }

    public Atendente getAtendAtendente() {
        return atendAtendente;
    }

    public void setAtendAtendente(Atendente atendAtendente) {
        this.atendAtendente = atendAtendente;
    }

    @Override
    public String toString() {
        return "Atendimento{" +
                "dataAtendimento=" + dataAtendimento +
                ", atendCliente=" + atendCliente +
                ", atendAtendente=" + atendAtendente +
                '}';
    }
}