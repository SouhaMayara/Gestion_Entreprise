package com.formation.persistance;

public class LigneFacture {
	private Integer idLigneFacture;
	private Integer qte;
	private Facture facture;
	private Article article;
	
	
	
	

	public Integer getIdLigneFacture() {
		return idLigneFacture;
	}

	public void setIdLigneFacture(Integer idLigneFacture) {
		this.idLigneFacture = idLigneFacture;
	}

	public Integer getQte() {
		return qte;
	}

	public void setQte(Integer qte) {
		this.qte = qte;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + qte;
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
		LigneFacture other = (LigneFacture) obj;
		if (qte != other.qte)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LigneFacture [qte=" + qte + "]";
	}

	
	
}
