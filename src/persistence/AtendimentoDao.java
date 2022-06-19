package persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Atendente;
import model.Atendimento;
import model.Cliente;
import org.hibernate.SessionFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AtendimentoDao implements IAtendimentoDao {

    private SessionFactory sf;

    public AtendimentoDao(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public void insere(Atendimento atend) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(atend);
        transaction.commit();
    }

    @Override
    public Atendimento selectOne(Atendimento atend) {
        Atendimento atendimento = new Atendimento();
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT * FROM atendimento ");
        buffer.append("INNER JOIN cliente ON cliente.cpf_cliente = atendiment.cpf_cliente ");
        buffer.append("INNER JOIN atendente ON atendente.id_funcionario = atendimento.id_funcionario ");
        buffer.append("WHERE ");
        buffer.append("atendimento.data_atendimento = " + atend.getDataAtendimento().toString());
        buffer.append("atendimento.id_funcionario= " + atend.getAtendente().getId());
        buffer.append("AND ");
        buffer.append("atendimento.cpf_cliente = " + atend.getCliente().getCpf());

        EntityManager entityManager = sf.createEntityManager();
        Query query = entityManager.createNativeQuery(buffer.toString());
        List<Object[]> resultado = query.getResultList();

        for(Object[] obj : resultado) {
            Cliente cliente = new Cliente();
            Atendente atendente = new Atendente();

            // Atendimento
            atendimento.setDataAtendimento(LocalDateTime.parse(obj[0].toString()));

            // Cliente
            cliente.setPronomeTratamento(obj[1].toString());
            cliente.setNome(obj[2].toString());
            cliente.setCpf(obj[3].toString());
            cliente.setTelefone(obj[4].toString());
            cliente.setEmail(obj[5].toString());

            // Atendente
            atendente.setNome(obj[6].toString());
            atendente.setId(Integer.parseInt(obj[7].toString()));

            // ===================================================
            atendimento.setAtendente(atendente);
            atendimento.setCliente(cliente);
        }

        return atendimento;
    }

    @Override
    public List<Atendimento> selectOneCliente(Atendimento atend) {
        List<Atendimento> atendimentos = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT * FROM atendimento ");
        buffer.append("INNER JOIN cliente ON cliente.cpf_cliente = atendiment.cpf_cliente ");
        buffer.append("INNER JOIN atendente ON atendente.id_funcionario = atendimento.id_funcionario ");
        buffer.append("WHERE ");
        buffer.append("atendimento.cpf_cliente = " + atend.getCliente().getCpf());

        EntityManager entityManager = sf.createEntityManager();
        Query query = entityManager.createNativeQuery(buffer.toString());
        List<Object[]> resultado = query.getResultList();

        for(Object[] obj : resultado) {
            Cliente cliente = new Cliente();
            Atendente atendente = new Atendente();
            Atendimento atendimento = new Atendimento();

            // Atendimento
            atendimento.setDataAtendimento(LocalDateTime.parse(obj[0].toString()));

            // Cliente
            cliente.setPronomeTratamento(obj[1].toString());
            cliente.setNome(obj[2].toString());
            cliente.setCpf(obj[3].toString());
            cliente.setTelefone(obj[4].toString());
            cliente.setEmail(obj[5].toString());

            // Atendente
            atendente.setNome(obj[6].toString());
            atendente.setId(Integer.parseInt(obj[7].toString()));

            // ===================================================
            atendimento.setAtendente(atendente);
            atendimento.setCliente(cliente);
        }

        return atendimentos;
    }

    @Override
    public List<Atendimento> selectOneAtendente(Atendimento atend) {
        List<Atendimento> atendimentos = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT * FROM atendimento ");
        buffer.append("INNER JOIN cliente ON cliente.cpf_cliente = atendiment.cpf_cliente ");
        buffer.append("INNER JOIN atendente ON atendente.id_funcionario = atendimento.id_funcionario ");
        buffer.append("WHERE ");
        buffer.append("atendimento.id_funcionario = " + atend.getAtendente().getId());

        EntityManager entityManager = sf.createEntityManager();
        Query query = entityManager.createNativeQuery(buffer.toString());
        List<Object[]> resultado = query.getResultList();

        for(Object[] obj : resultado) {
            Cliente cliente = new Cliente();
            Atendente atendente = new Atendente();
            Atendimento atendimento = new Atendimento();

            // Atendimento
            atendimento.setDataAtendimento(LocalDateTime.parse(obj[0].toString()));

            // Cliente
            cliente.setPronomeTratamento(obj[1].toString());
            cliente.setNome(obj[2].toString());
            cliente.setCpf(obj[3].toString());
            cliente.setTelefone(obj[4].toString());
            cliente.setEmail(obj[5].toString());

            // Atendente
            atendente.setNome(obj[6].toString());
            atendente.setId(Integer.parseInt(obj[7].toString()));

            // ===================================================
            atendimento.setAtendente(atendente);
            atendimento.setCliente(cliente);
        }

        return atendimentos;
    }

    @Override
    public List<Atendimento> selectAll() {
        List<Atendimento> atendimentos = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT * FROM atendimento ");
        buffer.append("INNER JOIN cliente ON cliente.cpf_cliente = atendiment.cpf_cliente ");
        buffer.append("INNER JOIN atendente ON atendente.id_funcionario = atendimento.id_funcionario ");
        EntityManager entityManager = sf.createEntityManager();
        Query query = entityManager.createNativeQuery(buffer.toString());
        List<Object[]> lista = query.getResultList();

        for (Object[] obj : lista) {
            Atendimento atendimento = new Atendimento();
            Atendente atendente = new Atendente();
            Cliente cliente = new Cliente();

            // Atendimento
            atendimento.setDataAtendimento(LocalDateTime.parse(obj[0].toString()));

            // Cliente
            cliente.setPronomeTratamento(obj[1].toString());
            cliente.setNome(obj[2].toString());
            cliente.setCpf(obj[3].toString());
            cliente.setTelefone(obj[4].toString());
            cliente.setEmail(obj[5].toString());

            // Atendente
            atendente.setNome(obj[6].toString());
            atendente.setId(Integer.parseInt(obj[7].toString()));

            // ===================================================
            atendimento.setAtendente(atendente);
            atendimento.setCliente(cliente);
            atendimentos.add(atendimento);
        }

        return atendimentos;
    }
}
