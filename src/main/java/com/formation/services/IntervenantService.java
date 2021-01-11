package com.formation.services;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.formation.dao.HibernateUtil;
import com.formation.dao.IntervenantHome;
import com.formation.persistance.Intervenant;
public class IntervenantService {

		private IntervenantHome dao;

		public IntervenantService() {
			dao = new IntervenantHome();
		}

		
		

		public void ajouterIntervenant(Intervenant l) {
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

		public void supprimerIntervenant(Intervenant l) {
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

		
		
		
		
		
		public Intervenant modifierIntervenant(Intervenant a) {
			Intervenant am= null;
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
		
		
		
		public Intervenant rechercheIntervenantParid(Integer id) {
			Intervenant l = null;
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

		public List<Intervenant> rechercheTousIntervenant() {
			List<Intervenant> liste = null;
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

		
		/*public List<Intervenant> rechercheIntervenantParQte(int q) {
			List<Intervenant> liste = null;
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
		}*/
		
		
		
		/*public List<Intervenant> rechercheTousIntervenantavecjoin() {
			List<Intervenant> liste = null;
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
			return (liste);}*/
			}

		
	