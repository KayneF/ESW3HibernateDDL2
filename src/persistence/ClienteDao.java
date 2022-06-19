package persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Cliente;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class ClienteDao implements InterfaceDao<Cliente> {

    private SessionFactory sf;

    public ClienteDao(SessionFactory sf){
        this.sf = sf;
    }

    @Override
    public void insere(Cliente cliente) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(cliente);
        transaction.commit();
    }

    @Override
    public void modifica(Cliente cliente) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(cliente);
        transaction.commit();
    }

    @Override
    public void remove(Cliente cliente) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(cliente);
        transaction.commit();
    }

    @Override
    public Cliente busca(Cliente cliente) {
        EntityManager entityManager = sf.createEntityManager();
        cliente = entityManager.find(Cliente.class, cliente.getCpf());
        return cliente;
    }

    @Override
    public List lista() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT cpf_cliente, nome_cliente, telefone_cliente, email_cliente, ");
        buffer.append("pronome_tratamento ");
        buffer.append("FROM cliente ");
        buffer.append("ORDER BY nome_cliente");
        EntityManager entityManager = sf.createEntityManager();
        Query query = entityManager.createNativeQuery(buffer.toString());
        List<Object[]> lista = query.getResultList();
        for (Object[] obj : lista) {
            Cliente c = new Cliente();
            c.setCpf(obj[0].toString());
            c.setNome(obj[1].toString());
            c.setEmail(obj[2].toString());
            c.setTelefone(obj[3].toString());
            c.setPronomeTratamento(obj[4].toString());

            clientes.add(c);
        }
        return clientes;
    }
}
