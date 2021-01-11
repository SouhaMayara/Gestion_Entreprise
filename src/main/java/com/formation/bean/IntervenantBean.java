package com.formation.bean;
import java.util.ArrayList;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import com.formation.persistance.Intervenant;

import com.formation.services.IntervenantService;


@ManagedBean(name ="intervenantBean")
@SessionScoped
public class IntervenantBean {
		private int id_i,tel;
		private String nom,prenom,mail;
		private List<Intervenant> intervenants=new ArrayList<Intervenant>();
		
		
		/***********************/
		
		public int getId_i() {
			return id_i;
		}

		public void setId_i(int id_i) {
			this.id_i = id_i;
		}

		public int getTel() {
			return tel;
		}

		public void setTel(int tel) {
			this.tel = tel;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
		}

		public List<Intervenant> getIntervenants() {
			return intervenants;
		}

		public void setIntervenants(List<Intervenant> intervenants) {
			this.intervenants = intervenants;
		}
		
		/******************************************************************/
		 /*public List<Intervenant> rechercheparidFacture(Integer id){
			 IntervenantService ls=new IntervenantService();
			 return ls.rechercheIntervenantParIdChefP(id);}*/
		 
		
	    public void recupererIntervenant(Intervenant f){
			id_i=f.getId_i();
			nom=f.getNom();
			prenom=f.getPrenom();
			mail=f.getMail();
			tel=f.getTel();
			
		}
	    
		/*public void modifIntervenant(){
			Intervenant f= new Intervenant();
					List<Intervenant> lf= new ArrayList<Intervenant>();
			FacesContext faces = FacesContext.getCurrentInstance();
			
						lf = new IntervenantService().rechercheIntervenantParQte(qte);
						if(lf != null && lf.size() > 0 && lf.get(0).getQte()!=qte){
						faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Intervenant existe déjà.", ""));}
			
						else
						{
			        f.setIdIntervenant(idIntervenant);
		         	f.setQte(qte);
						if (idFacture != null) {
							Facture v = new Facture();
							v.setIdFacture(idFacture);
							f.setFacture(v);}
						
						if (idArticle != null) {
							Article s = new Article();
							s.setIdArticle(idArticle);
							f.setArticle(s);}
						IntervenantService fs=new IntervenantService();
						fs.modifierIntervenant(f);
						System.out.println("modif");
					}*/
	    
	    
	    
	    
	      
	    
	    

			public void modifIntervenant(){
			
			Intervenant s=new Intervenant();
		    s.setId_i(id_i);
			s.setNom(nom);
			s.setMail(mail);
			s.setPrenom(prenom);
			s.setTel(tel);
			
			
			
			IntervenantService ss=new IntervenantService();
			ss.modifierIntervenant(s);
	        }
	    	
	    	

			public void ajouterIntervenant() {
				System.out.println("ajout");
			    Intervenant s =new Intervenant();
			    s.setNom(nom);
				s.setMail(mail);
				s.setPrenom(prenom);
				s.setTel(tel);

				IntervenantService ps=new IntervenantService();
				ps.ajouterIntervenant(s);
			}
			
			
			
			public void supprimerIntervenant(Intervenant f){
					IntervenantService fs=new IntervenantService();
					fs.supprimerIntervenant(f);}
			
	}

