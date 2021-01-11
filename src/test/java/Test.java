import java.util.ArrayList;
import java.util.List;

import com.formation.persistance.ChefP;
import com.formation.persistance.Facture;
import com.formation.persistance.LigneFacture;
import com.formation.persistance.Personne;
import com.formation.persistance.Societe;
import com.formation.persistance.Ville;
import com.formation.services.ArticleService;
import com.formation.services.PersonneService;
import com.formation.services.SocieteService;
import com.formation.services.ChefPService;



import com.formation.services.FactureService;
import com.formation.services.LigneFactureService;
public class Test {

	public static void main(String[] args) {
		
		
		
		ChefP v=new ChefP();
		v.setNom("Mayara");
		v.setPrenom("Haythem");
		v.setTel(24666111);
		v.setMail("mayara@gmail.com");
		ChefPService vs=new ChefPService();
		vs.ajouterChefP(v);
		
		v=vs.rechercheChefPParId(2);
		System.out.println(v);
		/*Ville v=new Ville();
		v.setCodePostale(200);
		v.setNomVille("sousse");
		VilleService vs=new VilleService();
		vs.ajouterVille(v);
		v=vs.rechercheVilleParId(1);
		System.out.println(v);
		v.setCodePostale(8000);
		vs.modifierVille(v);
		System.out.println(v);*/
		
		/*vs.supprimerVille(v);*/
		/*Personne p=new Personne();
		p.setAdresse("nabeul");
		p.setEmail("xxx");
		p.setNomPersonne("ali");
		p.setPrenomPersonne("x");
		PersonneService ps=new PersonneService();
		ps.ajouterPersonne(p);
	    System.out.println(p);*/
		
		/*Societe s=new Societe();
		s.setAdresse("yyy");
		s.setRaisonSocial("y");
		SocieteService ss=new SocieteService();
		ss.ajouterSociete(s);*/
		/*s=ss.rechercheSocieteParId(2);
		System.out.println(s);
		s.setAdresse("nn");
		ss.modifierSociete(s);
		System.out.println(s);
		/*ss.supprimerSociete(s);*/
		
	
		/*PersonneService ps=new PersonneService();
		List<Personne>l=new ArrayList<Personne>();
		l=ps.recherchePersonneParIdSct(3);
		for(int i=0;i<l.size();i++){
		System.out.println(l.get(i));
		}*/
		
		
		/*PersonneService pss=new PersonneService();
		List<Personne>lp=new ArrayList<Personne>();
		lp=pss.recherchePersonneParIdVilleIdSociete(2,3);
		for(int i=0;i<lp.size();i++){
		System.out.println(lp.get(i));
		}*/
		
		/*SocieteService ss=new SocieteService();
		List<Societe>ls=new ArrayList<Societe>();
		ls=ss.rechercheSocieteParIdVille(3);
		for(int i=0;i<ls.size();i++){
		System.out.println(ls.get(i));
		}
		 LigneFacture l=new LigneFacture();
		 l.setQte(22);*/
			
		/*List<LigneFacture>lp=new ArrayList<LigneFacture>();
	   LigneFactureService as=new LigneFactureService();
		lp=as.rechercheLigneFactureParIdFacture(2);
		for(int i=0;i<lp.size();i++){
			System.out.println(lp.get(i));
			}*/
		
		
		/*Facture f =new Facture();
		f.setMontant(222);
	
		System.out.println(f.getMontant());
		
		FactureService fs=new FactureService();
		fs.ajouterFacture(f);
		System.out.println("ajout");*/
		/*PersonneService ps=new PersonneService();
		List<Personne> ls=new ArrayList<Personne>();
		ls=ps.recherchePersonneParEmail("pp");
		for(int i=0;i<ls.size();i++){
			System.out.println(ls.get(i));}}*/
	
	/*PersonneService ps=new PersonneService();
	List<Personne> ls=new ArrayList<Personne>();
	
	Object valeur=null;
	Object parametre="Nom";
	if((parametre==null)||(valeur==null)||(valeur.equals(""))||(parametre.equals("")))
		
		ls=ps.rechercheTousPersonneavecjoin();
	for(int i=0;i<ls.size();i++){
		System.out.println(ls.get(i));}*/
	}

}
