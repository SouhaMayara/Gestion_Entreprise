package com.formation.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.formation.persistance.Personne;
import com.formation.persistance.Societe;
import com.formation.persistance.Ville;
import com.formation.services.PersonneService;
import com.formation.services.SocieteService;
import com.formation.services.VilleService;
@ManagedBean(name ="societeBean")
@SessionScoped
public class SocieteBean {
	private int idSociete;
	private String raisonSocial;
	private String adresse;
	
	private List<Societe> societes=new ArrayList<Societe>();
	
	private Integer idVille;
	private List<Ville> villes = new ArrayList<Ville>(0);
/**************************************/
	public Integer getIdVille() {
		return idVille;
	}

	public void setIdVille(Integer idVille) {
		this.idVille = idVille;
	}

	public List<Ville> getVilles() {
		villes = new VilleService().rechercheTousVille();
		return villes;
	}

	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}
	
	
	
	public String getRaisonSocial() {
		return raisonSocial;
	}
	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}
	public List<Societe> getSocietes() {
		SocieteService ss=new SocieteService();
		societes=ss.rechercheTousSocieteavecjoin();
		return societes;
	}
	

	public void setSocietes(List<Societe> societes) {
		this.societes = societes;
	}
	public int getIdSociete() {
		return idSociete;
	}
	public void setIdSociete(int idSociete) {
		this.idSociete = idSociete;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	 
	
	
	
	
/*********************************************/	
	public void ajouterSociete(){
		System.out.println("ajout");
		List<Societe> ls= new ArrayList<Societe>();
		FacesContext faces = FacesContext.getCurrentInstance();
		if(raisonSocial ==null || raisonSocial.trim().length()==0 )
			{faces.addMessage(null, new FacesMessage(
		        FacesMessage.SEVERITY_ERROR, "Veuillez saisir la raison sociale.", ""));
			}
		 else {
			 ls = new SocieteService().rechercheSocieteParraison(raisonSocial);
			 if(ls != null && ls.size() > 0)
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Ville existe déjà.", ""));
		}
		
		
		if(faces.getMessageList().size()==0){
	    Societe s =new Societe();
		s.setAdresse(adresse);
		s.setRaisonSocial(raisonSocial);
		if (idVille != null) {
			Ville v = new Ville();
			v.setIdVille(idVille);
			s.setVille(v);}
		SocieteService ss=new SocieteService();
		ss.ajouterSociete(s);}
	}
	
	
	
	public void recupererSociete(Societe s){
		
		idSociete = s.getIdSociete();
		raisonSocial=s.getRaisonSocial();
		adresse=s.getAdresse();
		if (s.getVille() != null)
			idVille = s.getVille().getIdVille();
		if (idVille != null) {
			Ville v = new Ville();
			v.setIdVille(idVille);
			s.setVille(v);}
		
		}

	public void modifierSociete(){
		
		Societe s=new Societe();
		
		List<Societe> ls= new ArrayList<Societe>();
		FacesContext faces = FacesContext.getCurrentInstance();
		ls = new SocieteService().rechercheSocieteParraison(raisonSocial);
			 if(ls != null && ls.size() > 0 && ls.get(0).getIdSociete()!=idSociete){
				
			        faces.addMessage(null, new FacesMessage(
			        		FacesMessage.SEVERITY_ERROR, "Societe existe déjà.", ""));}
		else
		
	    {s.setIdSociete(idSociete);
		s.setAdresse(adresse);
		s.setRaisonSocial(raisonSocial);
		if (s.getVille() != null)
			idVille = s.getVille().getIdVille();
		
		SocieteService ss=new SocieteService();
		ss.modifierSociete(s);}
			 
        }
	
	public void supprimerSociete(Societe s){
		FacesContext faces = FacesContext.getCurrentInstance();
		PersonneService pss=new PersonneService();
		List<Personne>lp=new ArrayList<Personne>();
		lp=pss.recherchePersonneParIdSct(s.getIdSociete());
if(lp.size()!=0){
	faces.addMessage(null, new FacesMessage(
	        FacesMessage.SEVERITY_ERROR, "Societe existe dans liste Personne.", ""));
            }
if(faces.getMessageList().size()==0){
	SocieteService ss=new SocieteService();
		ss.supprimerSociete(s);
        }
	}
	
	
}
