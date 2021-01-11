package com.formation.persistance;

public class Societe {
		private int idSociete;
		private String raisonSocial;
		private String adresse;
		private Ville ville;
		
		
		public Ville getVille() {
			return ville;
		}
		public void setVille(Ville ville) {
			this.ville = ville;
		}
		
		
		public int getIdSociete() {
			return idSociete;
		}
		public void setIdSociete(int idSociete) {
			this.idSociete = idSociete;
		}
		public String getRaisonSocial() {
			return raisonSocial;
		}
		public void setRaisonSocial(String raisonSocial) {
			this.raisonSocial = raisonSocial;
		}
		public String getAdresse() {
			return adresse;
		}
		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
			result = prime * result + idSociete;
			result = prime * result + ((raisonSocial == null) ? 0 : raisonSocial.hashCode());
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
			Societe other = (Societe) obj;
			if (adresse == null) {
				if (other.adresse != null)
					return false;
			} else if (!adresse.equals(other.adresse))
				return false;
			if (idSociete != other.idSociete)
				return false;
			if (raisonSocial == null) {
				if (other.raisonSocial != null)
					return false;
			} else if (!raisonSocial.equals(other.raisonSocial))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Societe [idSociete=" + idSociete + ", raisonSocial=" + raisonSocial + ", adresse=" + adresse + "]";
		}
		
		
}
