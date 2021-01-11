package com.formation.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.formation.persistance.Article;
import com.formation.services.ArticleService;


@ManagedBean(name ="articleBean")
@SessionScoped
public class ArticleBean {
	    private int idArticle;
	    private int reference;
		private String libelle;
		private int prixU;
		private List<Article> articles=new ArrayList<Article>();
		
		public int getIdArticle() {
			return idArticle;
		}
		public void setIdArticle(int idArticle) {
			this.idArticle = idArticle;
		}
		public int getReference() {
			return reference;
		}
		public void setReference(int reference) {
			this.reference = reference;
		}
		public String getLibelle() {
			return libelle;
		}
		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}
		public int getPrixU() {
			return prixU;
		}
		public void setPrixU(int prix) {
			this.prixU = prix;
		}
		public List<Article> getArticles() {
		   ArticleService as=new ArticleService();
		   articles=as.rechercheTousArticle();
			return articles;
		}
		public void setArticles(List<Article> articles) {
			this.articles = articles;
		}
		
   /***************************************************************************/
		public Article rechercheparid(Integer id){
			 ArticleService ls=new ArticleService();
			 return ls.rechercheArticleParId(id);}
		 
		
		public void recupererArticle(Article a){
			
			idArticle  = a.getIdArticle();
			reference=a.getReference();
			libelle=a.getLibelle();
			prixU=a.getPrixU();
		}

		public void modifArticle(){
			Article a= new Article();
			List<Article> la= new ArrayList<Article>();
			FacesContext faces = FacesContext.getCurrentInstance();
			
						la = new ArticleService().rechercheArticleParReference(reference);
						if(la != null && la.size() > 0 && la.get(0).getIdArticle()!=idArticle){
						faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Article existe déjà.", ""));}
			
						else
						{
						a.setIdArticle(idArticle);
						a.setLibelle(libelle);
						a.setPrixU(prixU);
						a.setReference(reference);
						ArticleService as=new ArticleService();
						as.modifierArticle(a);
						System.out.println("modif");}
					}
		
		
		
	public void ajouterA(){
		    System.out.println("ajout");
			/*List<Article> la= new ArrayList<Article>();
			FacesContext faces = FacesContext.getCurrentInstance();
				if(reference==0)
				{faces.addMessage(null, new FacesMessage(
			        FacesMessage.SEVERITY_ERROR, "Veuillez saisir la reference Article.", ""));
				}
				else {
					la = new ArticleService().rechercheArticleParReference(reference);
					if(la != null && la.size() > 0)
						faces.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "Article existe déjà.", ""));
			         }
			
			
				if(faces.getMessageList().size()==0)*/
			
			
					Article a =new Article();
					a.setReference(reference);
					a.setLibelle(libelle);
					a.setPrixU(prixU);
					ArticleService as=new ArticleService();
					as.ajouterArticle(a);
					}
			
			
			public void supprimerArticle(Article a){
				FacesContext faces = FacesContext.getCurrentInstance();
			
				if(faces.getMessageList().size()==0){
					ArticleService as=new ArticleService();
					as.supprimerArticle(a);}
		        }
			

}
