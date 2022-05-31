package persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Atendente;
import model.Cliente;
import model.PronomeTratamento;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AtendenteDAO implements InterfaceDAO<Atendente> {

    private SessionFactory sf;

    public AtendenteDAO(SessionFactory sf){
        this.sf = sf;
    }

    @Override
    public void insere(Atendente atendente) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(atendente);
        transaction.commit();
    }

    @Override
    public void modifica(Atendente atendente) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(atendente);
        transaction.commit();
    }

    @Override
    public void remove(Atendente atendente) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(atendente);
        transaction.commit();
    }

    @Override
    public Atendente busca(Atendente atendente) {
        EntityManager entityManager = sf.createEntityManager();
        atendente = entityManager.find(Atendente.class, atendente.getId());
        return atendente;
    }

    @Override
    public List lista() {
        List<Atendente> atentendes = new ArrayList<Atendente>();
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT nome_funcionario, data_nascimento, salario, telefone_funcionario");
        buffer.append("hora_entrada, hora_saida, email_atendente ");
        buffer.append("FROM funcionario ");
        buffer.append("ORDER BY nome_funcionario");
        EntityManager entityManager = sf.createEntityManager();
        Query query = entityManager.createNativeQuery(buffer.toString());
        List<Object[]> lista = query.getResultList();
        for (Object[] obj : lista) {
            Atendente atendente = new Atendente();
            atendente.setNome(obj[1].toString());
            atendente.setNascimento(LocalDate.parse(obj[2].toString()));
            atendente.setSalario(Double.parseDouble(obj[3].toString()));
            atendente.setTelefone(Integer.parseInt(obj[4].toString()));
            atendente.setHorarioEntrada(LocalTime.parse(obj[5].toString()));
            atendente.setHorarioSaida(LocalTime.parse(obj[5].toString()));
            atendente.setEmailAtendente(obj[6].toString());

            atentendes.add(atendente);
        }
        return atentendes;
    }
}
