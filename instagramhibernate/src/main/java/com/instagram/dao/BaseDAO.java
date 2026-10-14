package com.instagram.dao;
import com.instagram.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import java.util.function.Function;

public abstract class BaseDAO<T> {
    private final Class<T> type;
    protected BaseDAO(Class<T> type){this.type=type;}

    protected <R> R tx(Function<Session,R> work) {
        Transaction tx=null;
        try(Session s=HibernateUtil.getSessionFactory().openSession()){
            tx=s.beginTransaction();
            R result=work.apply(s);
            tx.commit();
            return result;
        } catch(RuntimeException e) {
            if(tx!=null) tx.rollback();
            throw e;
        }
    }
    public T findById(Long id){return tx(s->s.get(type,id));}
    public T save(T obj){return tx(s->{s.persist(obj); return obj;});}
    public T update(T obj){return tx(s->{return s.merge(obj);});}
    public void delete(T obj){tx(s->{s.remove(s.merge(obj)); return null;});}
    public List<T> findAll(){return tx(s->s.createQuery("from "+type.getSimpleName(),type).getResultList());}
}
