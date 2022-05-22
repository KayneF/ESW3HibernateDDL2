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
    private int numeroCNH;

    @Column(name = "categoria_cnh", length = 3)
    @NotNull
    private CategoriaCNH categoriaCNH;

    // -----------------------------------------------------

    public int getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(int numeroCNH) {
        this.numeroCNH = numeroCNH;
    }

    public CategoriaCNH getCategoriaCNH() {
        return categoriaCNH;
    }

    public void setCategoriaCNH(CategoriaCNH categoriaCNH) {
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