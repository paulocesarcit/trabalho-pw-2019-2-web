package br.edu.ifsul.dao;

import java.io.Serializable;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DAOGenerico<TIPO> implements Serializable {
    
    private List<TIPO> listaObjetos; // retorna uma consulta paginada (2ª etapa)
    private List<TIPO> listaTodos; // retorna todos os registros
    
    @PersistenceContext(unitName = "Trabalho-PW-2019-2-WebPU")
    protected EntityManager em;
    
    protected Class classePersistente; // classe que a instância do dao está utilizando
    
    public DAOGenerico() {
    
    }

    public List<TIPO> getListaObjetos() {
        String jpql = "from " + classePersistente.getSimpleName();
        return em.createQuery(jpql).getResultList();
    }

    public List<TIPO> getListaTodos() {
        String jpql = "from " + classePersistente.getSimpleName();
        return em.createQuery(jpql).getResultList();
    }
    
    public void persist(TIPO obj) throws Exception {
        em.persist(obj);
    }
    
    public void merge(TIPO obj) throws Exception {
        em.merge(obj);
    }
    
    @RolesAllowed("ADMINISTRADOR")
    public void remove(TIPO obj) throws Exception {
        obj = em.merge(obj);
        em.remove(obj);
    }
    
    public TIPO getObjectById(Object id) {
        return (TIPO) em.find(classePersistente, id);
    }
    
    public void setListaObjetos(List<TIPO> listaObjetos) {
        this.listaObjetos = listaObjetos;
    }

    public void setListaTodos(List<TIPO> listaTodos) {
        this.listaTodos = listaTodos;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Class getClassePersistente() {
        return classePersistente;
    }

    public void setClassePersistente(Class classePersistente) {
        this.classePersistente = classePersistente;
    }
    
}
