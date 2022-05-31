package persistence;

import java.util.List;

public interface InterfaceDAO<T> {

    public void insere(T t);
    public void modifica(T t);
    public void remove(T t);
    public T busca(T t);
    public List<T> lista();

}
