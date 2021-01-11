package com.formation.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.formation.persistance.Facture;


public class FactureHome {


	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
            return HibernateUtil.getSessionFactory();
		} catch (Exception e) {

			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}
	

	// Méthode d'ajout
	public void persist(Facture f) {
		try {
			sessionFactory.getCurrentSession().persist(f);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	

	// Méthode supression
	public void delete(Facture f) {
		try {
			sessionFactory.getCurrentSession().delete(f);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	

	// Méthode de modification
	public Facture merge(Facture f) {
		try {
			Facture result=(Facture) sessionFactory.getCurrentSession().merge(f);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	
	// Méthode de recherche par clé primaire
	public Facture findById(Integer id) {
		try {
			Facture result=(Facture) sessionFactory.getCurrentSession().get(Facture.class,id);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	// Méthode retourne la liste de tous les Factures
		@SuppressWarnings("unchecked")
		public List<Facture> findAll() {
			Criteria crit = sessionFactory.getCurrentSession()
					.createCriteria(Facture.class);
			return crit.list();
			}


		// Méthode de recherche des Factures par montant
		@SuppressWarnings("unchecked")
		public List<Facture> findByM(int m) {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(Facture.class)
					.add(Restrictions.eq("montant", m));
			return crit.list();
		}
		
}
