package com.formation.persistance;

public class Personne {
     private int idPersonne;
     private String nomPersonne; 
     private String prenomPersonne; 
     private String adresse;
     private String email;
     private Ville ville;
     private Societe societe;
     
     
     
	public Societe getSociete() {
		return societe;
	}
	public void setSociete(Societe societe) {
		this.societe = societe;
	}
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idPersonne;
		result = prime * result + ((nomPersonne == null) ? 0 : nomPersonne.hashCode());
		result = prime * result + ((prenomPersonne == null) ? 0 : prenomPersonne.hashCode());
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
		Personne other = (Personne) obj;
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
		if (nomPersonne == null) {
			if (other.nomPersonne != null)
				return false;
		} else if (!nomPersonne.equals(other.nomPersonne))
			return false;
		if (prenomPersonne == null) {
			if (other.prenomPersonne != null)
				return false;
		} else if (!prenomPersonne.equals(other.prenomPersonne))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Personne [idPersonne=" + idPersonne + ", nomPersonne=" + nomPersonne + ", prenomPersonne="
				+ prenomPersonne + ", adresse=" + adresse + ", email=" + email + "]";
	} 
     
     
     
     
}
