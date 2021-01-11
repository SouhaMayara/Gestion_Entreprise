package com.formation.bean;


import java.util.ArrayList;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import com.formation.persistance.Article;
import com.formation.persistance.Facture;
import com.formation.persistance.LigneFacture;
import com.formation.services.ArticleService;
import com.formation.services.FactureService;
import com.formation.services.LigneFactureService;


@ManagedBean(name ="lignefactureBean")
@SessionScoped
public class LigneFactureBean {
	private int idLigneFacture;
	private int qte;
	private List<LigneFacture> lignefactures=new ArrayList<LigneFacture>();
	
	private Integer idFacture;
	private List<Facture> factures = new ArrayList<Facture>();
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
	public Integer getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(Integer idFacture) {
		this.idFacture = idFacture;
	}
	public List<Facture> getFactures() {
		FactureService vs=new FactureService();
		factures=vs.rechercheTousFacture();
		return factures;
	}
	public void setFactures(List<Facture> factures) {
		this.factures = factures;
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
    
	/*public void modifLigneFacture(){
		LigneFacture f= new LigneFacture();
				List<LigneFacture> lf= new ArrayList<LigneFacture>();
		FacesContext faces = FacesContext.getCurrentInstance();
		
					lf = new LigneFactureService().rechercheLigneFactureParQte(qte);
					if(lf != null && lf.size() > 0 && lf.get(0).getQte()!=qte){
					faces.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "LigneFacture existe déjà.", ""));}
		
					else
					{
		        f.setIdLigneFacture(idLigneFacture);
	         	f.setQte(qte);
					if (idFacture != null) {
						Facture v = new Facture();
						v.setIdFacture(idFacture);
						f.setFacture(v);}
					
					if (idArticle != null) {
						Article s = new Article();
						s.setIdArticle(idArticle);
						f.setArticle(s);}
					LigneFactureService fs=new LigneFactureService();
					fs.modifierLigneFacture(f);
					System.out.println("modif");
				}*/
    
    
    
    
      
    
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
        }
    	
    	

		public void ajouterLigneFacture() {
			System.out.println("ajout");
		    LigneFacture p =new LigneFacture();
			p.setQte(qte);
	
			if (idFacture!= null) {
			   Facture f=new Facture();
			   f.setIdFacture(idFacture);
			   p.setFacture(f);}
			
			if (idArticle!= null) {
				Article v = new Article();
				v.setIdArticle(idArticle);;
				p.setArticle(v);}
			
			LigneFactureService ps=new LigneFactureService();
			ps.ajouterLigneFacture(p);
		}
		
		
		
		public void supprimerLigneFacture(LigneFacture f){
				LigneFactureService fs=new LigneFactureService();
				fs.supprimerLigneFacture(f);}
		
}
