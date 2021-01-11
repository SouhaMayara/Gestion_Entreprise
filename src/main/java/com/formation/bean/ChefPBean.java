package com.formation.bean;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.formation.persistance.ChefP;
import com.formation.services.ChefPService;


@ManagedBean(name ="chefpBean")
@SessionScoped



public class ChefPBean {

		    private int id_c,tel;
		    private String nom,prenom,mail;
			private List<ChefP> chefps=new ArrayList<ChefP>();
			
			
			
	  



	public int getId_c() {
				return id_c;
			}


			public void setId_c(int id_c) {
				this.id_c = id_c;
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


			public List<ChefP> getChefps() {
				return chefps;
			}


			public void setChefps(List<ChefP> chefps) {
				this.chefps = chefps;
			}


	/***************************************************************************/
			public ChefP rechercheparid(Integer id){
				ChefPService ls=new ChefPService();
				 return ls.rechercheChefPParId(id);}
			 
			
			public void recupererChefP(ChefP a){
				System.out.println("recuperation");
				id_c=a.getId_c();
				nom=a.getNom();
				prenom=a.getPrenom();
				tel=a.getTel();
				mail=a.getMail();
				System.out.println("recuperation");
			}

			public void modifChefP(){
				ChefP a= new ChefP();
				List<ChefP> la= new ArrayList<ChefP>();
				FacesContext faces = FacesContext.getCurrentInstance();
				
							la = new ChefPService().rechercheChefPPartel(tel);
							if(la != null && la.size() > 0 && la.get(0).getId_c()!=id_c){
							faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "ChefP existe déjà.", ""));}
				
							else
							{
							a.setId_c(id_c);
							a.setNom(nom);
							a.setPrenom(prenom);
							a.setTel(tel);
							a.setMail(mail);
							ChefPService as=new ChefPService();
							as.modifierChefP(a);
							System.out.println("modif");}
						}
			
			
			
		public void ajouterA(){
			    System.out.println("ajout");
				/*List<ChefP> la= new ArrayList<ChefP>();
				FacesContext faces = FacesContext.getCurrentInstance();
					if(reference==0)
					{faces.addMessage(null, new FacesMessage(
				        FacesMessage.SEVERITY_ERROR, "Veuillez saisir la reference ChefP.", ""));
					}
					else {
						la = new ChefPService().rechercheChefPParReference(reference);
						if(la != null && la.size() > 0)
							faces.addMessage(null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR, "ChefP existe déjà.", ""));
				         }
					if(faces.getMessageList().size()==0)*/
				
				
						ChefP a =new ChefP();
						a.setId_c(id_c);
						a.setNom(nom);
						a.setPrenom(prenom);
						a.setTel(tel);
						a.setMail(mail);
						ChefPService as=new ChefPService();
						as.ajouterChefP(a);
						}
		
				
				
		public void supprimerChefP(ChefP a){
					FacesContext faces = FacesContext.getCurrentInstance();
				
					if(faces.getMessageList().size()==0){
						ChefPService as=new ChefPService();
						as.supprimerChefP(a);}
			        }
				

	}

