package com.formation.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import com.formation.persistance.LigneFacture;


public class LigneFactureHome {

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
            return HibernateUtil.getSessionFactory();
		} catch (Exception e) {

			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}
	//Méthode de recherche des Lignes selon leur Facture
			@SuppressWarnings("unchecked")
			public List<LigneFacture> findByIdFacture(Integer idFacture) {
				Criteria crit = sessionFactory.getCurrentSession()
						.createCriteria(LigneFacture.class)
						.setFetchMode("facture", FetchMode.JOIN)
						//.createCriteria("facture")
						.add(Restrictions.eq("facture.idFacture", idFacture));
				return crit.list();
			}
			
	      

	// Méthode d'ajout
	public void persist(LigneFacture l) {
		try {
			sessionFactory.getCurrentSession().persist(l);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	

	// Méthode supression
	public void delete(LigneFacture a) {
		try {
			sessionFactory.getCurrentSession().delete(a);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	

	// Méthode de modification
	public LigneFacture merge(LigneFacture a) {
		try {
			LigneFacture result=(LigneFacture) sessionFactory.getCurrentSession().merge(a);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	
	// Méthode de recherche par clé primaire
	public LigneFacture findById(Integer id) {
		try {
			LigneFacture result=(LigneFacture) sessionFactory.getCurrentSession().get(LigneFacture.class,id);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	// Méthode retourne la liste de tous les LigneFactures
		@SuppressWarnings("unchecked")
		public List<LigneFacture> findAll() {
			Criteria crit = sessionFactory.getCurrentSession()
					.createCriteria(LigneFacture.class);
			return crit.list();
			}


		// Méthode de recherche des LigneFactures par Q
		@SuppressWarnings("unchecked")
		public List<LigneFacture> findByQ(int q) {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(LigneFacture.class)
					.add(Restrictions.eq("qte", q));
			return crit.list();
		}
		

		// Méthode retourne la liste de tous les Lignes Factures avec jointure
		@SuppressWarnings("unchecked")
		public List<LigneFacture> findAllwithjoin() {
			Criteria crit = sessionFactory.getCurrentSession()
					.createCriteria(LigneFacture.class)
					.setFetchMode("Facture", FetchMode.JOIN)
					.setFetchMode("Article",FetchMode.JOIN);
			return crit.list();
			}
       
		
}
