package com.formation.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.formation.persistance.Societe;


public class SocieteHome {
	
	
	
	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
            return HibernateUtil.getSessionFactory();
		} catch (Exception e) {

			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}
	

	// Méthode d'ajout d'une societe
	public void persist(Societe s) {
		try {
			sessionFactory.getCurrentSession().persist(s);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	

	// Méthode supression d'une societe
	public void delete(Societe s) {
		try {
			sessionFactory.getCurrentSession().delete(s);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	

	// Méthode de modification d'une societe
	public Societe merge(Societe s) {
		try {
			Societe result=(Societe) sessionFactory.getCurrentSession().merge(s);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	
	// Méthode de recherche d'une societe par clé primaire
	public Societe findById(Integer id) {
		try {
			Societe result=(Societe) sessionFactory.getCurrentSession().get(Societe.class,id);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	// Méthode retourne la liste de tous les societes
		@SuppressWarnings("unchecked")
		public List<Societe> findAll() {
			Criteria crit = sessionFactory.getCurrentSession()
					.createCriteria(Societe.class);
			return crit.list();
			}


		// Méthode de recherche des societes par leur raison
		@SuppressWarnings("unchecked")
		public List<Societe> findByraison(String raison) {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(Societe.class)
					.add(Restrictions.eq("raisonSocial", raison));
			return crit.list();
		}
				
				
				
				//Méthode de recherche des personnes selon leur ville
				@SuppressWarnings("unchecked")
				public List<Societe> findByIdVille(Integer id) {
					Criteria crit = sessionFactory.getCurrentSession()
							.createCriteria(Societe.class)
							.setFetchMode("ville", FetchMode.JOIN)
							.createCriteria("ville")
							.add(Restrictions.eq("idVille", id));
					return crit.list();
				}

				// Méthode retourne la liste de tous les societes avec jointure
				@SuppressWarnings("unchecked")
				public List<Societe> findAllwithjoin() {
					Criteria crit = sessionFactory.getCurrentSession()
							.createCriteria(Societe.class)
							.setFetchMode("ville", FetchMode.JOIN);
					return crit.list();
					}

		

}
