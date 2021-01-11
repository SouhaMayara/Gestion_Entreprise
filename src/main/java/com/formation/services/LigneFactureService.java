package com.formation.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.formation.dao.HibernateUtil;
import com.formation.dao.LigneFactureHome;
import com.formation.persistance.LigneFacture;
public class LigneFactureService {
	
	private LigneFactureHome dao;

	public LigneFactureService() {
		dao = new LigneFactureHome();
	}

	
	

	public void ajouterLigneFacture(LigneFacture l) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {   tx = session.beginTransaction();

			dao.persist(l);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public void supprimerLigneFacture(LigneFacture l) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			dao.delete(l);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	
	
	
	
	
	public LigneFacture modifierLigneFacture(LigneFacture a) {
		LigneFacture am= null;
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
	
	
	
	public LigneFacture rechercheLigneFactureParid(Integer id) {
		LigneFacture l = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			l = dao.findById(id);
			tx.commit();
  		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return l;

	}

	public List<LigneFacture> rechercheTousLigneFacture() {
		List<LigneFacture> liste = null;
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

	
	public List<LigneFacture> rechercheLigneFactureParQte(int q) {
		List<LigneFacture> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findByQ(q);
			tx.commit();
			} 
		catch (RuntimeException ex) {
                      if (tx != null)
				         tx.rollback();
			             ex.printStackTrace();
		               }
		return (liste);
	}
	
	
	
	public List<LigneFacture> rechercheTousLigneFactureavecjoin() {
		List<LigneFacture> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findAllwithjoin();
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return (liste);
		}

	public List<LigneFacture> rechercheLigneFactureParIdFacture(Integer id) {
		List<LigneFacture> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findByIdFacture(id);
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
