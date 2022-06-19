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
    @JoinColumn(name = "cpf_cliente")
    @NotNull
    private Cliente cliente;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    @NotNull
    private Atendente atendente;

    // -----------------------------------------------------

    public LocalDateTime getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(LocalDateTime dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    @Override
    public String toString() {
        return "Atendimento{" +
                "dataAtendimento=" + dataAtendimento +
                ", atendCliente=" + cliente +
                ", atendAtendente=" + atendente +
                '}';
    }
}