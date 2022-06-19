package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "entregador")
public class Entregador extends Funcionario {

    @Column(name = "numero_cnh", length = 12)
    @NotNull
    private String numeroCNH;

    @Column(name = "categoria_cnh", length = 3)
    @NotNull
    private String categoriaCNH;

    // -----------------------------------------------------

    public String getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(String numeroCNH) {
        this.numeroCNH = numeroCNH;
    }

    public String getCategoriaCNH() {
        return categoriaCNH;
    }

    public void setCategoriaCNH(String categoriaCNH) {
        this.categoriaCNH = categoriaCNH;
    }

    @Override
    public String toString() {
        return "Entregador{" +
                "numeroCNH=" + numeroCNH +
                ", categoriaCNH=" + categoriaCNH +
                '}';
    }
}