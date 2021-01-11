package com.formation.persistance;

public class Facture {
	private int idFacture;
	private int montant;
	
	
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFacture;
		result = prime * result + montant;
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
		Facture other = (Facture) obj;
		if (idFacture != other.idFacture)
			return false;
		if (montant != other.montant)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Facture [idFacture=" + idFacture + ", montant=" + montant + "]";
	}
	
	
}
