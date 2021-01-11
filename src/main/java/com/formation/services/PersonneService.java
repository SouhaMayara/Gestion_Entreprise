package com.formation.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.formation.dao.HibernateUtil;
import com.formation.dao.PersonneHome;
import com.formation.persistance.Personne;

public class PersonneService {

	PersonneHome dao;
	public PersonneService(){
		dao=new PersonneHome();
	}
	
	
	
	public void ajouterPersonne(Personne p) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {   tx = session.beginTransaction();

			dao.persist(p);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public void supprimerPersonne(Personne p) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			dao.delete(p);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
	}

	public Personne modifierPersonne(Personne p) {
		Personne pm= null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			pm = dao.merge(p);
			tx.commit();

		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return pm;
	}

	public Personne recherchePersonneParId(Integer id) {
		Personne p = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			p = dao.findById(id);
			tx.commit();
  		} catch (RuntimeException ex) {

			if (tx != null)
				tx.rollback();
			ex.printStackTrace();
		}
		return p;

	}

	public List<Personne> rechercheTousPersonne() {
		List<Personne> liste = null;
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


	
	public List<Personne> rechercheTousPersonneavecjoin() {
		List<Personne> liste = null;
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

	
	
	public List<Personne> recherchePersonneParNom(String nom) {
		List<Personne> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findByName(nom);
			tx.commit();
			} 
		catch (RuntimeException ex) {
                      if (tx != null)
				         tx.rollback();
			             ex.printStackTrace();
		               }
		return (liste);
	}

	public List<Personne> recherchePersonneParPrenom(String prenom) {
		List<Personne> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findByP(prenom);
			tx.commit();
			} 
		catch (RuntimeException ex) {
                      if (tx != null)
				         tx.rollback();
			             ex.printStackTrace();
		               }
		return (liste);
	}
	
	
	public List<Personne> recherchePersonneParAdresse(String adresse) {
		List<Personne> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findByAdresse(adresse);
			tx.commit();
			} 
		catch (RuntimeException ex) {
                      if (tx != null)
				         tx.rollback();
			             ex.printStackTrace();
		               }
		return (liste);
	}
	
	
	
	
	
	public List<Personne> recherchePersonneParEmail(String email) {
		List<Personne> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findByEmail(email);
			tx.commit();
			} 
		catch (RuntimeException ex) {
                      if (tx != null)
				         tx.rollback();
			             ex.printStackTrace();
		               }
		return (liste);
	}
	
	
	
	public List<Personne> recherchePersonneParIdVille(Integer id) {
		List<Personne> liste = null;
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

	
	public List<Personne> recherchePersonneParNomVille(String nom) {
		List<Personne> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			liste = dao.findByNomVille(nom);
			tx.commit();
			} 
		catch (RuntimeException ex) {
                      if (tx != null)
				         tx.rollback();
			             ex.printStackTrace();
		               }
		return (liste);
	}
	
	
	
	
	public List<Personne> recherchePersonneParIdVilleIdSociete(Integer id1,Integer id2) {
		List<Personne> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			liste = dao.findByIdVilleIdSociete(id1, id2);
			tx.commit();
			
			} 
		catch (RuntimeException ex) {
                      if (tx != null)
				         tx.rollback();
			             ex.printStackTrace();
		               }
		return (liste);
	}
	
	
	
	public List<Personne> recherchePersonneParIdSct(Integer id1) {
		List<Personne> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			liste = dao.findBySociete(id1);
			tx.commit();
			
			} 
		catch (RuntimeException ex) {
                      if (tx != null)
				         tx.rollback();
			             ex.printStackTrace();
		               }
		return (liste);
	}
	
	public List<Personne> recherchePersonneParRSct(String r) {
		List<Personne> liste = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			liste = dao.findByRaisonSociete(r);
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
