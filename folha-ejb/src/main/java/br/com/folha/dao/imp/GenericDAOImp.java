package br.com.folha.dao.imp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.primefaces.model.SortOrder;

import br.com.folha.dao.GenericDAO;

public abstract class GenericDAOImp<T> implements GenericDAO<T>{
	
	private final static String UNIT_NAME = "folhaPU";

	@PersistenceContext(unitName = UNIT_NAME)
	private EntityManager em;

	private Class<T> entityClass;

	public GenericDAOImp(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public T inserir(T entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public void excluir(T entity) {
		T entityToBeRemoved = em.merge(entity);

		em.remove(entityToBeRemoved);
	}

	@Override
	public T alterar(T entity) {
		return em.merge(entity);
	}

	@Override
	public T consultar(Long entityID) {
		return em.find(entityClass, entityID);
	}

	@Override
	public List<T> listar() {
		CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(entityClass);
		cq.select(cq.from(entityClass));
		return em.createQuery(cq).getResultList();
	}

	@Override
	public Long count(T entidade) {
		@SuppressWarnings("unchecked")
		TypedQuery<T> query = (TypedQuery<T>) em.createQuery("SELECT COUNT(t) FROM "+ entidade.getClass().getSimpleName() + " t");
		return (Long) query.getSingleResult();
	}
	
	// Using the unchecked because JPA does not have a
	// ery.getSingleResult()<T> method
	@Override
	@SuppressWarnings("unchecked")
	public T procurarRegistroUnico(String namedQuery, Map<String, Object> parameters) throws NoResultException, Exception {
		T result = null;
		try {
			Query query = em.createNamedQuery(namedQuery);

			// Method that will populate parameters if they are passed not null and empty
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}
			result = (T) query.getSingleResult();
		} catch (NoResultException e) {
			throw e;
		} catch (Exception e) {
			System.out.println("Error while running query: " + e.getMessage());
			throw e;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> procurarListaRegistros(String namedQuery, Map<String, Object> parameters) {
		List<T> result = new ArrayList<T>();

		try {
			Query query = em.createNamedQuery(namedQuery);

			// Method that will populate parameters if they are passed not null and empty
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}
			result = (List<T>) query.getResultList();
		} catch (Exception e) {
			System.out.println("Error while running query: " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	private void populateQueryParameters(Query query, Map<String, Object> parameters) {
		for (Entry<String, Object> entry : parameters.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> listarLazy(int primeiroRegistro, int quantidadePagina, String campoOrdenacao,
			SortOrder ordenacao, Map<String, String> filtros){
		// Cria critério de busca
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(entityClass);
		Root<T> from = criteria.from(entityClass);
	 	CriteriaQuery<T> select = criteria.select(from);
	 	
	 	//Filtro vindo do datatable
		List<Predicate> predicates = new ArrayList<Predicate>(); 
		
		//Realiza ordenação
		if(ordenacao != null && campoOrdenacao != null){
			switch (ordenacao) {
			case ASCENDING:
			case UNSORTED:
				select.orderBy(builder.asc(from.get(campoOrdenacao)));
				break;
			case DESCENDING:
				select.orderBy(builder.desc(from.get(campoOrdenacao)));
				break;
			}
		}
		
		if(filtros != null){
			for(Iterator<String> it = filtros.keySet().iterator(); it.hasNext();){
				String chave = it.next();
				@SuppressWarnings({"rawtypes" })
				Expression expressao = (Expression)from.get(filtros.get(chave));
				predicates.add(builder.like(expressao, filtros.get(chave) + "%"));
			}
		}
		select.where(predicates.toArray(new Predicate[]{}));
		
		//Realizar a consulta paginada
		TypedQuery<T> query = getEntityManager().createQuery(select);
		query.setFirstResult(primeiroRegistro);
		query.setMaxResults(quantidadePagina);
		
		//Retorna a lista paginada
		return query.getResultList();
	}

	
	protected EntityManager getEntityManager(){
		return this.em;
	}
}