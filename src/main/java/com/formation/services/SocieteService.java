package com.formation.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.formation.dao.HibernateUtil;
import com.formation.dao.SocieteHome;
import com.formation.persistance.Societe;

public class SocieteService {
	
	
	

	SocieteHome dao;
	public SocieteService() {
		dao=new SocieteHome();
	}
	
	
	
	public void ajouterSociete(Societe s) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {   tx = session.beginTransaction();

			dao.persist(s);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public void supprimerSociete(Societe s) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			dao.delete(s);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public Societe modifierSociete(Societe s) {
		Societe sm= null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			sm = dao.merge(s);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return sm;
	}

	public Societe rechercheSocieteParId(Integer id) {
		Societe s = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			s = dao.findById(id);
			tx.commit();
  		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return s;

	}

	public List<Societe> rechercheTousSociete() {
		List<Societe> liste = null;
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


	public List<Societe> rechercheTousSocieteavecjoin() {
		List<Societe> liste = null;
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

	
	
	
	public List<Societe> rechercheSocieteParraison(String raison) {
		List<Societe> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findByraison(raison);
			tx.commit();
			} 
		catch (RuntimeException ex) {
                      if (tx != null)
				         tx.rollback();
			             ex.printStackTrace();
		               }
		return (liste);
	}

	
	public List<Societe> rechercheSocieteParIdVille(Integer id) {
		List<Societe> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findByIdVille(id);
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
