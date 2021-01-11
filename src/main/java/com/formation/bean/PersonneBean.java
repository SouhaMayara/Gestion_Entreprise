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
@ManagedBean(name ="personneBean")
@SessionScoped
public class PersonneBean {
	private String parametre="";
	private String valeur;
	private int idPersonne;
	private String nomPersonne;
	private String prenomPersonne;
	private String adresse;
	private String email;
	/*******************/
	private Integer idSociete;
	private List<Societe> societes = new ArrayList<Societe>();
	private Integer idVille;
	private List<Ville> villes = new ArrayList<Ville>();

	private List<Personne>personnes=new ArrayList<Personne>();

    /*******************/
	
	public List<Societe> getSocietes() {
		SocieteService ss=new SocieteService();
		societes=ss.rechercheTousSociete();
		return societes;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idPersonne;
		result = prime * result + ((idSociete == null) ? 0 : idSociete.hashCode());
		result = prime * result + ((idVille == null) ? 0 : idVille.hashCode());
		result = prime * result + ((nomPersonne == null) ? 0 : nomPersonne.hashCode());
		result = prime * result + ((parametre == null) ? 0 : parametre.hashCode());
		result = prime * result + ((personnes == null) ? 0 : personnes.hashCode());
		result = prime * result + ((prenomPersonne == null) ? 0 : prenomPersonne.hashCode());
		result = prime * result + ((societes == null) ? 0 : societes.hashCode());
		result = prime * result + ((valeur == null) ? 0 : valeur.hashCode());
		result = prime * result + ((villes == null) ? 0 : villes.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonneBean other = (PersonneBean) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idPersonne != other.idPersonne)
			return false;
		if (idSociete == null) {
			if (other.idSociete != null)
				return false;
		} else if (!idSociete.equals(other.idSociete))
			return false;
		if (idVille == null) {
			if (other.idVille != null)
				return false;
		} else if (!idVille.equals(other.idVille))
			return false;
		if (nomPersonne == null) {
			if (other.nomPersonne != null)
				return false;
		} else if (!nomPersonne.equals(other.nomPersonne))
			return false;
		if (parametre == null) {
			if (other.parametre != null)
				return false;
		} else if (!parametre.equals(other.parametre))
			return false;
		if (personnes == null) {
			if (other.personnes != null)
				return false;
		} else if (!personnes.equals(other.personnes))
			return false;
		if (prenomPersonne == null) {
			if (other.prenomPersonne != null)
				return false;
		} else if (!prenomPersonne.equals(other.prenomPersonne))
			return false;
		if (societes == null) {
			if (other.societes != null)
				return false;
		} else if (!societes.equals(other.societes))
			return false;
		if (valeur == null) {
			if (other.valeur != null)
				return false;
		} else if (!valeur.equals(other.valeur))
			return false;
		if (villes == null) {
			if (other.villes != null)
				return false;
		} else if (!villes.equals(other.villes))
			return false;
		return true;
	}



	public String getParametre() {
		return parametre;
	}



	public void setParametre(String parametre) {
		this.parametre = parametre;
	}



	public String getValeur() {
		return valeur;
	}



	public void setValeur(String valeur) {
		this.valeur = valeur;
	}



	public void setSocietes(List<Societe> societes) {
		this.societes = societes;
	}

	public Integer getIdVille() {
		return idVille;
	}

	public void setIdVille(Integer idVille) {
		this.idVille = idVille;
	}

	public List<Ville> getVilles() {

		VilleService vs=new VilleService();
		villes=vs.rechercheTousVille();
		return villes;
	}

	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}

	
	
	
	public int getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getNomPersonne() {
		return nomPersonne;
	}

	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}

	public String getPrenomPersonne() {
		return prenomPersonne;
	}

	public void setPrenomPersonne(String prenomPersonne) {
		this.prenomPersonne = prenomPersonne;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Personne> getPersonnes() {
		
		PersonneService ps=new PersonneService();
		personnes=ps.rechercheTousPersonneavecjoin();
	    return personnes;
	}

	public void setPersonnes(List<Personne> personnes) {
		this.personnes = personnes;
	}
	public Integer getIdSociete() {
		return idSociete;
	}

	public void setIdSociete(Integer idSociete) {
		this.idSociete = idSociete;
	}
	
	
	/********************************************************************/
	
	public void ajouterPersonne(){
		System.out.println("ajout");
		
		List<Personne> lp= new ArrayList<Personne>();
		FacesContext faces = FacesContext.getCurrentInstance();
		if(nomPersonne ==null || nomPersonne.trim().length()==0 )
			{faces.addMessage(null, new FacesMessage(
		        FacesMessage.SEVERITY_ERROR, "Veuillez saisir la nom personne.", ""));
			}
		 else {
			 lp = new PersonneService().recherchePersonneParNom(nomPersonne);
			 if(lp != null && lp.size() > 0)
			faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Nom personne existe déjà.", ""));
		}
		
		
		if(faces.getMessageList().size()==0){
		
	    Personne p =new Personne();
		p.setNomPersonne(nomPersonne);
		p.setPrenomPersonne(prenomPersonne);
		p.setAdresse(adresse);
		p.setEmail(email);
		System.out.println("idVille=="+idVille);
		if (idVille != null) {
			Ville v = new Ville();
			v.setIdVille(idVille);
			p.setVille(v);}
		
		if (idSociete != null) {
			Societe s = new Societe();
			s.setIdSociete(idSociete);
			p.setSociete(s);}
		PersonneService ps=new PersonneService();
		ps.ajouterPersonne(p);
		}
	}
	
	
	
	public void recupererPersonne(Personne p){
		
		idPersonne  = p.getIdPersonne();
		nomPersonne=p.getNomPersonne();
		prenomPersonne=p.getPrenomPersonne();
		adresse=p.getAdresse();
		email=p.getEmail();
		if (p.getVille() != null)
			idVille = p.getVille().getIdVille();
		if (p.getSociete() != null)
			idSociete= p.getSociete().getIdSociete();}

	public void modifierPersonne(){	
		Personne p=new Personne();
		List<Personne> lp= new ArrayList<Personne>();
		FacesContext faces = FacesContext.getCurrentInstance();
		lp = new PersonneService().recherchePersonneParNom(nomPersonne);
			 
		if(lp != null && lp.size() > 0 && lp.get(0).getIdPersonne()!=idPersonne){
				 faces.addMessage(null, new FacesMessage(
			        		FacesMessage.SEVERITY_ERROR, "Personne existe déjà.", ""));}
		else{
		p.setIdPersonne(idPersonne);
		p.setNomPersonne(nomPersonne);
		p.setPrenomPersonne(prenomPersonne);
		p.setAdresse(adresse);
		p.setEmail(email);
		
		if (idVille != null) {
			Ville v = new Ville();
			v.setIdVille(idVille);
			p.setVille(v);
			}
		
		if (idSociete != null) {
			Societe s = new Societe();
			s.setIdSociete(idSociete);
			p.setSociete(s);
		}
		PersonneService ps=new PersonneService();
		ps.modifierPersonne(p);
        System.out.println("modif");
		}
	}
	
	public void supprimerPersonne(Personne p){
		PersonneService ps=new PersonneService();
		ps.supprimerPersonne(p);
        }
	
	
	public List<Personne> recherchePersonne(){
		
		PersonneService ps=new PersonneService();
		List<Personne> ls=new ArrayList<Personne>();

		System.out.println("parametre=="+parametre);
		System.out.println("valeur=="+valeur);
		System.out.println(((parametre==null)||(valeur==null)||(valeur.equals(""))||(parametre.equals(""))));
		
		
        if((parametre==null)||(valeur==null)||(valeur.equals(""))||(parametre.equals("")))	
		ls=ps.rechercheTousPersonneavecjoin();
	    if(parametre.equals("Nom"))
		ls=ps.recherchePersonneParNom(valeur);
		else if(parametre.equals("Prenom"))
		ls=ps.recherchePersonneParPrenom(valeur);
		else if(parametre.equals("adresse"))
			ls=ps.recherchePersonneParAdresse(valeur);
		else if(parametre.equals("email"))
			ls=ps.recherchePersonneParEmail(valeur);
		else if(parametre.equals("NomVille"))
			ls=ps.recherchePersonneParNomVille(valeur);
		else if(parametre.equals("raison"))
		  ls=ps.recherchePersonneParRSct(valeur);
		     
		return ls;
	}
	
	public void initialiserPersonne(){
	parametre="";
		valeur=null;
        }
	

}
