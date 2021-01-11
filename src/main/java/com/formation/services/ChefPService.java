package com.formation.services;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.formation.dao.ChefPHome;
import com.formation.dao.HibernateUtil;
import com.formation.persistance.ChefP;

import java.util.List;

public class ChefPService {


	private ChefPHome dao;

	public ChefPService() {
		dao = new ChefPHome();
	}
	public void ajouterChefP(ChefP a) {
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

	public void supprimerChefP(ChefP a) {
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

	public ChefP modifierChefP(ChefP a) {
		ChefP am= null;
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

	public ChefP rechercheChefPParId(Integer id) {
		ChefP a = null;
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

	public List<ChefP> rechercheTousChefP() {
		List<ChefP> liste = null;
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

	
	public List<ChefP> rechercheChefPPartel(int tel)  {
		List<ChefP> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findBytel(tel);
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
