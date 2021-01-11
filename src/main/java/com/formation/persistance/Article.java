package com.formation.persistance;

public class Article {
	private int idArticle;
	private int reference;
	private String libelle;
	private int prixU;
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
	public void setPrixU(int prixU) {
		this.prixU = prixU;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idArticle;
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + prixU;
		result = prime * result + reference;
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
		Article other = (Article) obj;
		if (idArticle != other.idArticle)
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (prixU != other.prixU)
			return false;
		if (reference != other.reference)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", reference=" + reference + ", libelle=" + libelle + ", prixU="
				+ prixU + "]";
	}
	
}
