package com.formation.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.formation.persistance.Article;

public class ArticleHome {

	
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
	public void persist(Article a) {
		try {
			sessionFactory.getCurrentSession().persist(a);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	

	// Méthode supression
	public void delete(Article a) {
		try {
			sessionFactory.getCurrentSession().delete(a);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	

	// Méthode de modification
	public Article merge(Article a) {
		try {
			Article result=(Article) sessionFactory.getCurrentSession().merge(a);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	
	// Méthode de recherche par clé primaire
	public Article findById(Integer id) {
		try {
			Article result=(Article) sessionFactory.getCurrentSession().get(Article.class,id);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	// Méthode retourne la liste de tous les Articles
		@SuppressWarnings("unchecked")
		public List<Article> findAll() {
			Criteria crit = sessionFactory.getCurrentSession()
					.createCriteria(Article.class);
			return crit.list();
			}


		// Méthode de recherche des Articles par ref
		@SuppressWarnings("unchecked")
		public List<Article> findByRef(int ref) {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(Article.class)
					.add(Restrictions.eq("reference", ref));
			return crit.list();
		}
		
}
