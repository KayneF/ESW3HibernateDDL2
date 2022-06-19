package persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Entregador;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EntregadorDao implements InterfaceDao<Entregador> {

    private SessionFactory sf;

    public EntregadorDao(SessionFactory sf){
        this.sf = sf;
    }

    @Override
    public void insere(Entregador entregador) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(entregador);
        transaction.commit();
    }

    @Override
    public void modifica(Entregador entregador) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(entregador);
        transaction.commit();
    }

    @Override
    public void remove(Entregador entregador) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(entregador);
        transaction.commit();
    }

    @Override
    public Entregador busca(Entregador entregador) {
        EntityManager entityManager = sf.createEntityManager();
        entregador = entityManager.find(Entregador.class, entregador.getId());
        return entregador;
    }

    @Override
    public List<Entregador> lista() {
        List<Entregador> entregadores = new ArrayList<Entregador>();
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT nome_funcionario, data_nascimento, salario, telefone_funcionario, ");
        buffer.append("numero_cnh, categoria_cnh ");
        buffer.append("FROM funcionario ");
        buffer.append("ORDER BY nome_funcionario");
        EntityManager entityManager = sf.createEntityManager();
        Query query = entityManager.createNativeQuery(buffer.toString());
        List<Object[]> lista = query.getResultList();
        for (Object[] obj : lista) {
            Entregador entregador = new Entregador();
            entregador.setId(Integer.parseInt(obj[0].toString()));
            entregador.setNome(obj[1].toString());
            entregador.setNascimento(LocalDate.parse(obj[2].toString()));
            entregador.setSalario(Float.parseFloat(obj[3].toString()));
            entregador.setTelefone(obj[4].toString());
            entregador.setNumeroCNH(obj[5].toString());
            entregador.setCategoriaCNH(obj[6].toString());

            entregadores.add(entregador);
        }
        return entregadores;
    }
}
