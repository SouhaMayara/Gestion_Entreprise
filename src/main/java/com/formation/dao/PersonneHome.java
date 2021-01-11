package com.formation.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.formation.persistance.Personne;


public class PersonneHome {
	

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
            return HibernateUtil.getSessionFactory();
		} catch (Exception e) {

			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}
	

	// Méthode d'ajout d'une personne
	public void persist(Personne p) {
		try {
			sessionFactory.getCurrentSession().persist(p);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	

	// Méthode supression d'une personne
	public void delete(Personne p) {
		try {
			sessionFactory.getCurrentSession().delete(p);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	

	// Méthode de modification d'une personne
	public Personne merge(Personne p) {
		try {
			Personne result=(Personne) sessionFactory.getCurrentSession().merge(p);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	
	// Méthode de recherche d'une personne par clé primaire
	public Personne findById(Integer id) {
		try {
			Personne result=(Personne) sessionFactory.getCurrentSession().get(Personne.class,id);
			return result;
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	// Méthode retourne la liste de tous les personnes
		@SuppressWarnings("unchecked")
		public List<Personne> findAll() {
			Criteria crit = sessionFactory.getCurrentSession()
					.createCriteria(Personne.class);
			return crit.list();
			}


		// Méthode de recherche des personnes par leur nom
		@SuppressWarnings("unchecked")
		public List<Personne> findByName(String nom) {
			Criteria crit = sessionFactory.getCurrentSession().createCriteria(Personne.class)//select * from personne
					.add(Restrictions.eq("nomPersonne", nom))
					.setFetchMode("ville", FetchMode.JOIN)
					.setFetchMode("societe",FetchMode.JOIN);
			return crit.list();
		}
		
		// Méthode de recherche des personnes par leur prenom
				@SuppressWarnings("unchecked")
				public List<Personne> findByP(String prenom) {
					Criteria crit = sessionFactory.getCurrentSession().createCriteria(Personne.class)//select * from personne
							.add(Restrictions.eq("prenomPersonne", prenom))
							.setFetchMode("ville", FetchMode.JOIN)
							.setFetchMode("societe",FetchMode.JOIN);
					return crit.list();
				}
				
				// Méthode de recherche des personnes par leur adresse
				@SuppressWarnings("unchecked")
				public List<Personne> findByAdresse(String adresse) {
					Criteria crit = sessionFactory.getCurrentSession().createCriteria(Personne.class)//select * from personne
							.add(Restrictions.eq("adresse", adresse))
							.setFetchMode("ville", FetchMode.JOIN)
							.setFetchMode("societe",FetchMode.JOIN);
					return crit.list();
				}
				
				// Méthode de recherche des personnes par leur email
				@SuppressWarnings("unchecked")
				public List<Personne> findByEmail(String email) {
					Criteria crit = sessionFactory.getCurrentSession().createCriteria(Personne.class)//select * from personne
							.add(Restrictions.eq("email", email))
							.setFetchMode("ville", FetchMode.JOIN)
							.setFetchMode("societe",FetchMode.JOIN);
					return crit.list();
				}
				
		
				
				
		
		
		//Méthode de recherche des personnes selon leur ville
		@SuppressWarnings("unchecked")
		public List<Personne> findByIdVille(Integer id) {
			Criteria crit = sessionFactory.getCurrentSession()
					.createCriteria(Personne.class)
					.setFetchMode("ville", FetchMode.JOIN)
					.createCriteria("ville")
					.add(Restrictions.eq("idVille", id))
					.setFetchMode("societe",FetchMode.JOIN);
			return crit.list();
		}
       
		
		//Méthode de recherche des personnes selon leur nomville
				@SuppressWarnings("unchecked")
				public List<Personne>findByNomVille(String nom) {
					Criteria crit = sessionFactory.getCurrentSession()
							.createCriteria(Personne.class)
							.setFetchMode("societe",FetchMode.JOIN)
							.setFetchMode("ville", FetchMode.JOIN)
							.createCriteria("ville")
							.add(Restrictions.eq("nomVille", nom));
							
					return crit.list();
				}
				//Méthode de recherche des personnes selon leur idville et idSociete
				@SuppressWarnings("unchecked")
				public List<Personne> findByIdVilleIdSociete(Integer id1,Integer id2) {
					Criteria crit = sessionFactory.getCurrentSession()
							.createCriteria(Personne.class)
							.setFetchMode("ville", FetchMode.JOIN)
							.setFetchMode("societe",FetchMode.JOIN)
							.add(Restrictions.eq("ville.idVille", id1))
							.add(Restrictions.eq("societe.idSociete",id2));
					return crit.list();
					
				}
				
				//Méthode de recherche des personnes selon leur societe
				@SuppressWarnings("unchecked")
				public List<Personne> findByRaisonSociete(String r) {
					Criteria crit = sessionFactory.getCurrentSession()
							.createCriteria(Personne.class)
							.setFetchMode("ville", FetchMode.JOIN)
							.setFetchMode("societe", FetchMode.JOIN)
							.createCriteria("societe")
							.add(Restrictions.eq("raisonSocial", r));
					return crit.list();
				}

				
				//Méthode de recherche des personnes par la société où il travail 
				@SuppressWarnings("unchecked")
				public List<Personne> findBySociete(Integer idSociete) {
					Criteria crit = sessionFactory.getCurrentSession()
							.createCriteria(Personne.class)
							.setFetchMode("societe", FetchMode.JOIN)
							.createCriteria("societe")
							.add(Restrictions.eq("idSociete", idSociete));
					return crit.list();
				}
				
				// Méthode retourne la liste de tous les personnes avec jointure
				@SuppressWarnings("unchecked")
				public List<Personne> findAllwithjoin() {
					Criteria crit = sessionFactory.getCurrentSession()
							.createCriteria(Personne.class)
							.setFetchMode("ville", FetchMode.JOIN)
							.setFetchMode("societe",FetchMode.JOIN);
					return crit.list();
					}
		       
}
