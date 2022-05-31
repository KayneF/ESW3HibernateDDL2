package persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Cliente;
import model.PronomeTratamento;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements InterfaceDAO<Cliente> {

    private SessionFactory sf;

    public ClienteDAO(){
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
        buffer.append("SELECT cpf_cliente, nome_cliente, email_cliente, telefone_cliente, ");
        buffer.append("pronome_tratamento ");
        buffer.append("FROM cliente ");
        buffer.append("ORDER BY nome_cliente");
        EntityManager entityManager = sf.createEntityManager();
        Query query = entityManager.createNativeQuery(buffer.toString());
        List<Object[]> lista = query.getResultList();
        for (Object[] obj : lista) {
            Cliente cliente = new Cliente();
            cliente.setCpf(Integer.parseInt(obj[0].toString()));
            cliente.setNome(obj[1].toString());
            cliente.setEmail(obj[2].toString());
            cliente.setTelefone(Integer.parseInt(obj[3].toString()));
            cliente.setPronomeTratamento(PronomeTratamento.valueOf(obj[4].toString()));

            clientes.add(cliente);
        }
        return clientes;
    }
}
