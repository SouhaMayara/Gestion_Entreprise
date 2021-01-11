package com.formation.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.formation.dao.ArticleHome;
import com.formation.dao.HibernateUtil;
import com.formation.persistance.Article;

public class ArticleService {
	private ArticleHome dao;

	public ArticleService() {
		dao = new ArticleHome();
	}
	public void ajouterArticle(Article a) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {   tx = session.beginTransaction();

			dao.persist(a);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public void supprimerArticle(Article a) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			dao.delete(a);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public Article modifierArticle(Article a) {
		Article am= null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			am = dao.merge(a);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return am;
	}

	public Article rechercheArticleParId(Integer id) {
		Article a = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			a = dao.findById(id);
			tx.commit();
  		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return a;

	}

	public List<Article> rechercheTousArticle() {
		List<Article> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findAll();
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);
		}

	
	public List<Article> rechercheArticleParReference(int ref)  {
		List<Article> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findByRef(ref);
			tx.commit();
			} 
		catch (RuntimeException ex) {
                      if (tx != null)
				         tx.rollback();
			             ex.printStackTrace();
		               }
		return (liste);
	}

	
}
