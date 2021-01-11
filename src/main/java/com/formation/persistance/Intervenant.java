package com.formation.persistance;

public class Intervenant {
private int id_i,tel;
private String nom,prenom,mail;



public int getId_i() {
	return id_i;
}
public void setId_i(int id_i) {
	this.id_i = id_i;
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
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id_i;
	result = prime * result + ((mail == null) ? 0 : mail.hashCode());
	result = prime * result + ((nom == null) ? 0 : nom.hashCode());
	result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
	result = prime * result + tel;
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
	Intervenant other = (Intervenant) obj;
	if (id_i != other.id_i)
		return false;
	if (mail == null) {
		if (other.mail != null)
			return false;
	} else if (!mail.equals(other.mail))
		return false;
	if (nom == null) {
		if (other.nom != null)
			return false;
	} else if (!nom.equals(other.nom))
		return false;
	if (prenom == null) {
		if (other.prenom != null)
			return false;
	} else if (!prenom.equals(other.prenom))
		return false;
	if (tel != other.tel)
		return false;
	return true;
}
@Override
public String toString() {
	return "Intervenant [id_i=" + id_i + ", tel=" + tel + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail
			+ "]";
}






}
