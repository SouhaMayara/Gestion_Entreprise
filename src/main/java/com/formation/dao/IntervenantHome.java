package com.formation.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.formation.persistance.Intervenant;

public class IntervenantHome {

		
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
		public void persist(Intervenant a) {
			try {
				sessionFactory.getCurrentSession().persist(a);
			} catch (RuntimeException re) {
				throw re;
			}
		}
		

		// Méthode supression
		public void delete(Intervenant a) {
			try {
				sessionFactory.getCurrentSession().delete(a);
			} catch (RuntimeException re) {
				throw re;
			}
		}
		

		// Méthode de modification
		public Intervenant merge(Intervenant a) {
			try {
				Intervenant result=(Intervenant) sessionFactory.getCurrentSession().merge(a);
				return result;
			} catch (RuntimeException re) {
				throw re;
			}
		}
		
		
		// Méthode de recherche par clé primaire
		public Intervenant findById(Integer id) {
			try {
				Intervenant result=(Intervenant) sessionFactory.getCurrentSession().get(Intervenant.class,id);
				return result;
			} catch (RuntimeException re) {
				throw re;
			}
		}
		
		// Méthode retourne la liste de tous les Intervenants
			@SuppressWarnings("unchecked")
			public List<Intervenant> findAll() {
				Criteria crit = sessionFactory.getCurrentSession()
						.createCriteria(Intervenant.class);
				return crit.list();
				}


			// Méthode de recherche des Intervenants par ref
			@SuppressWarnings("unchecked")
			public List<Intervenant> findByName(String n) {
				Criteria crit = sessionFactory.getCurrentSession().createCriteria(Intervenant.class)
						.add(Restrictions.eq("nom", n));
				return crit.list();
			}
			
	}

