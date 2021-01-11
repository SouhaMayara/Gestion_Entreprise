package com.formation.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.formation.persistance.Article;
import com.formation.persistance.Facture;
import com.formation.persistance.LigneFacture;
import com.formation.services.ArticleService;
import com.formation.services.FactureService;
import com.formation.services.LigneFactureService;



@ManagedBean(name ="factureBean")
@SessionScoped
public class FactureBean {
	private int idFacture;
    private int montant;
    private Facture facture;
	private List<Facture> factures=new ArrayList<Facture>();
	
	
	public int getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(int idFacture) {
		this.idFacture = idFacture;
	}
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
	public List<Facture> getFactures() {
		FactureService fs=new FactureService();
		factures=fs.rechercheTousFacture();
		return factures;
	}
	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}

	/**
	 * @throws IOException *********************************************************************/
	
	
	public void recupererFacture(Facture f) throws IOException{
		
		facture=f;
		idFacture=f.getIdFacture();
		montant=f.getMontant();
		String url = "modifFacture.xhtml"; // Your URL here

		FacesContext.getCurrentInstance().getExternalContext().redirect(url);
	}

	public void modifFacture() throws IOException{
		Facture f= new Facture();
		/*List<Facture> lf= new ArrayList<Facture>();
		FacesContext faces = FacesContext.getCurrentInstance();
		
					lf = new FactureService().rechercheFactureParMontant(montant);
					if(lf != null && lf.size() > 0 && lf.get(0).getIdFacture()!=idFacture){
					faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Facture existe déjà.", ""));}
		
					else
					{*/
					f.setIdFacture(idFacture);
					f.setMontant(montant);
					FactureService fs=new FactureService();
					fs.modifierFacture(f);
					System.out.println("modif");
					String url = "NewFile.xhtml"; // Your URL here

					FacesContext.getCurrentInstance().getExternalContext().redirect(url);
				}
	
	
	
		public void ajouterF(){
	    System.out.println("ajout");
		List<Facture> lf= new ArrayList<Facture>();
		FacesContext faces = FacesContext.getCurrentInstance();
			if(montant==0)
			{faces.addMessage(null, new FacesMessage(
		        FacesMessage.SEVERITY_ERROR, "Veuillez saisir le montant Facture.", ""));
			}
			else {
				lf = new FactureService().rechercheFactureParMontant(montant);
				if(lf != null && lf.size() > 0)
					faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_INFO, "Facture existe déjà.", ""));
		         }
		
		
			if(faces.getMessageList().size()==0){
		
				Facture f =new Facture();
				f.setMontant(montant);
				FactureService fs=new FactureService();
				fs.ajouterFacture(f);
				{ faces.addMessage(null, new FacesMessage(
			        		FacesMessage.SEVERITY_ERROR, "Ligne Facture ajoutée.", ""));}
				}
		}
		
		public void supprimerFacture(Facture f){
			FacesContext faces = FacesContext.getCurrentInstance();
		
			if(faces.getMessageList().size()==0){
				FactureService fs=new FactureService();
				fs.supprimerFacture(f);}
	        }
		

	


	private int idLigneFacture;
	private int qte;
	private List<LigneFacture> lignefactures=new ArrayList<LigneFacture>();
	private Integer idArticle;
	private List<Article> articles = new ArrayList<Article>();
	/***********************/
	
	public int getIdLigneFacture() {
		return idLigneFacture;
	}
	public void setIdLigneFacture(int idLigneFacture) {
		this.idLigneFacture = idLigneFacture;
	}
	
	public int getQte() {
		return qte;
	}
	
	public Integer getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}
	public List<Article> getArticles() {
		ArticleService ps=new ArticleService();
		articles=ps.rechercheTousArticle();
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public List<LigneFacture> getLignefactures() {
		LigneFactureService ls=new LigneFactureService();
		//lignefactures=ls.rechercheLigneFactureParIdFacture(idFacture);
		lignefactures=ls.rechercheTousLigneFacture();
		return lignefactures;
	}
	public void setLignefactures(List<LigneFacture> lignefactures) {
		this.lignefactures = lignefactures;
	}

	
	/******************************************************************/
	 public List<LigneFacture> rechercheparidFacture(Integer id){
		 LigneFactureService ls=new LigneFactureService();
		 return ls.rechercheLigneFactureParIdFacture(id);}
	 
	
    public void recupererLigneFacture(LigneFacture f){
		idLigneFacture=f.getIdLigneFacture();
		qte=f.getQte();
		if (f.getArticle() != null)
			idArticle = f.getArticle().getIdArticle();
		if (f.getFacture() != null)
			idFacture= f.getFacture().getIdFacture();
	}
    
		public void modifLigneFacture(){
		
		LigneFacture s=new LigneFacture();
	    s.setIdLigneFacture(idLigneFacture);
		s.setQte(qte);
		Facture f=new Facture();
		f.setIdFacture(idFacture);
		s.setFacture(f);
		
		if (idArticle != null) {
			Article a = new Article();
			a.setIdArticle(idArticle);
			s.setArticle(a);}
		LigneFactureService ss=new LigneFactureService();
		ss.modifierLigneFacture(s);
		FacesContext faces = FacesContext.getCurrentInstance();
		{ faces.addMessage(null, new FacesMessage(
	        		FacesMessage.SEVERITY_INFO, "Modification effectuée.", ""));}
        }
    	
    	

		public void ajouterLigneFacture() {
			System.out.println("ajout");
		    LigneFacture p =new LigneFacture();
			p.setQte(qte);
	        p.setFacture(facture);
			
			   System.out.println("idArticle=="+idArticle);
			
			if (idArticle!= null) {
				Article v = new Article();
				v.setIdArticle(idArticle);;
				p.setArticle(v);}
			
			LigneFactureService ps=new LigneFactureService();
			ps.ajouterLigneFacture(p);
			FacesContext faces = FacesContext.getCurrentInstance();
			{ faces.addMessage(null, new FacesMessage(
		        		FacesMessage.SEVERITY_INFO, "Ligne Facture ajoutée.", ""));}
		}
		
		
		
		public void supprimerLigneFacture(LigneFacture f){
				LigneFactureService fs=new LigneFactureService();
				fs.supprimerLigneFacture(f);
		{    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage
				(FacesMessage.SEVERITY_INFO, "Supression avec succès.", ""));}
			}
}

