package com.formation.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;


import com.formation.persistance.ChefP;



public class ChefPHome {

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
            return HibernateUtil.getSessionFactory();
		} catch (Exception e) {

			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}
	

	// M�thode d'ajout
	public void persist(ChefP a) {
		try {
			sessionFactory.getCurrentSession().persist(a);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	

	// M�thode supression
	public void delete(ChefP a) {
		try {
			sessionFactory.getCurrentSession().delete(a);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	

	// M�thode de modification
	public ChefP merge(ChefP a) {
		try {
			ChefP result=(ChefP) sessionFactory.getCurrentSession().merge(a);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	
	// M�thode de recherche par cl� primaire
	public ChefP findById(Integer id) {
		try {
			ChefP result=(ChefP) sessionFactory.getCurrentSession().get(ChefP.class,id);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	// M�thode retourne la liste de tous les Articles
		@SuppressWarnings("unchecked")
		public List<ChefP> findAll() {
			Criteria crit = sessionFactory.getCurrentSession()
					.createCriteria(ChefP.class);
			return crit.list();
			}


		// M�thode de recherche des Articles par ref
		@SuppressWarnings("unchecked")
		public List<ChefP> findBytel(int tel) {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(ChefP.class)
					.add(Restrictions.eq("tel", tel));
			return crit.list();
		}
		
}
