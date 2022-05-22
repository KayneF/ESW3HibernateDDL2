package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "atendimento")
public class Atendimento {

    @Id
    @Column(name = "atendimento_cliente")
    @NotNull
    private LocalDateTime atendimentoCliente;

    // -----------------------------------------------------

    public LocalDateTime getAtendimentoCliente() {
        return atendimentoCliente;
    }

    public void setAtendimentoCliente(LocalDateTime atendimentoCliente) {
        this.atendimentoCliente = atendimentoCliente;
    }

    @Override
    public String toString() {
        return "Atendimento{" +
                "atendimentoCliente=" + atendimentoCliente +
                '}';
    }
}