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

@ManagedBean(name ="villeBean")
@SessionScoped
public class VilleBean {
    private int idVille;
    private String nom;
	private String codeString;
	private int codePostale;
	private List<Ville> villes=new ArrayList<Ville>();
	
	
	public String getCodeString() {
		return codeString;
	}


	public void setCodeString(String codeString) {
		this.codeString = codeString;
	}


	public List<Ville> getVilles() {
		VilleService vs=new VilleService();
		villes=vs.rechercheTousVille();
		return villes;
	}


	public int getIdVille() {
		return idVille;
	}


	public void setIdVille(int idVille) {
		this.idVille = idVille;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(int codePostale) {
		this.codePostale = codePostale;
	}
	
	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}
/************************************************************************************/

	public void recupererVille(Ville v){
		
		idVille  = v.getIdVille();
		nom=v.getNomVille();
		codePostale=v.getCodePostale();
	}

	public void modifVille(){
		Ville v= new Ville();
		List<Ville> lV= new ArrayList<Ville>();
		FacesContext faces = FacesContext.getCurrentInstance();
		
	
			
			 lV = new VilleService().rechercheVilleParNom(nom);
			 if(lV != null && lV.size() > 0 && lV.get(0).getIdVille()!=idVille){
				
			        faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Ville existe déjà.", ""));}
		
		
		
			 else
	
		{System.out.println("nom=="+nom);
		v.setIdVille(idVille);
		v.setNomVille(nom);
		v.setCodePostale(codePostale);
		
		VilleService vs=new VilleService();
		vs.modifierVille(v);
		System.out.println("modif");}
		
	}

	
	

	
/*	public boolean isObjectInteger(Object o)
	{
	    return o instanceof Integer;
	}*/
	
	
	public void ajouterV(){
    System.out.println("ajout");
	List<Ville> lV= new ArrayList<Ville>();
	FacesContext faces = FacesContext.getCurrentInstance();
	if(nom ==null || nom.trim().length()==0 )
		{faces.addMessage(null, new FacesMessage(
	        FacesMessage.SEVERITY_ERROR, "Veuillez saisir le nom ville.", ""));
		
	}
	 else {
		
		 lV = new VilleService().rechercheVilleParNom(nom);
		 if(lV != null && lV.size() > 0)
		faces.addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_ERROR, "Ville existe déjà.", ""));
	}
	
	/*if(!(isObjectInteger(codePostale))){
		System.out.println("le code postale est integer "+isObjectInteger(codePostale));
		faces.addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_ERROR, "Code postale doit être un nombre composé d’un ou de plusieurs chiffres. ", ""));
	}*/
	int no=0;
	try
	{ 
		no=Integer.parseInt(codeString);
		System.out.println("entier");}

	catch(Exception ex)
	{faces.addMessage(null, new FacesMessage(
				FacesMessage.SEVERITY_ERROR, "Code postale doit être un nombre composé d’un ou de plusieurs chiffres. ", ""));
	}
	
	
	if(faces.getMessageList().size()==0){
	
	Ville v =new Ville();
	v.setNomVille(nom);
	v.setCodePostale(no);
	
	VilleService vs=new VilleService();
	vs.ajouterVille(v);
	}
	}
	
	public void supprimerVille(Ville v){
		FacesContext faces = FacesContext.getCurrentInstance();
		PersonneService pss=new PersonneService();
		SocieteService sss=new SocieteService();
		List<Societe> ls= new ArrayList<Societe>();
		  		ls=sss.rechercheSocieteParIdVille(v.getIdVille());
		List<Personne>lp=new ArrayList<Personne>();
				lp=pss.recherchePersonneParIdVille(v.getIdVille());
		if(lp.size()!=0){
			faces.addMessage(null, new FacesMessage(
			        FacesMessage.SEVERITY_ERROR, "Ville existe dans liste Personne.", ""));
		}
		if(ls.size()!=0){
			faces.addMessage(null, new FacesMessage(
			        FacesMessage.SEVERITY_ERROR, "Ville existe dans liste Societe.", ""));
		}
		
		
		
		if(faces.getMessageList().size()==0){
		VilleService vs=new VilleService();
		vs.supprimerVille(v);}
        }
	

}
