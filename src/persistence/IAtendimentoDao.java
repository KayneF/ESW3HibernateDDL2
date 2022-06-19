package persistence;

import model.Atendimento;

import java.util.List;

public interface IAtendimentoDao {

    void insere(Atendimento atend);
    Atendimento selectOne(Atendimento atend);
    List<Atendimento> selectOneCliente(Atendimento atend);
    List<Atendimento> selectOneAtendente(Atendimento atend);
    List<Atendimento> selectAll();

}