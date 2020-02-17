package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dominio.Pessoa;

public class Programa {

	private static SessionFactory sessionFactory = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Pessoa p1 = new Pessoa(null, "Edson Araujo", "edson@gmail.com");
		Pessoa p2 = new Pessoa(null, "Silmara Araujo", "silmara@gmail.com");
		Pessoa p3 = new Pessoa(null, "Sandro Araujo", "sandro@gmail.com");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("con_xe");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			
		em.createNativeQuery("INSERT INTO PESSOA (ID, NOME, EMAIL) VALUES (seq_pessoa.nextval, ?, ?)")
		   .setParameter(1, p1.getNome())
		   .setParameter(2, p1.getEmail())
		   .executeUpdate();

		em.createNativeQuery("INSERT INTO PESSOA (ID, NOME, EMAIL) VALUES (seq_pessoa.nextval, ?, ?)")
		   .setParameter(1, p2.getNome())
		   .setParameter(2, p2.getEmail())
		   .executeUpdate();		

		em.createNativeQuery("INSERT INTO PESSOA (ID, NOME, EMAIL) VALUES (seq_pessoa.nextval, ?, ?)")
		   .setParameter(1, p3.getNome())
		   .setParameter(2, p3.getEmail())
		   .executeUpdate();
		
		em.getTransaction().commit();
		
		
		em.getTransaction().begin();
		
		
		
		
		em.close();
		emf.close();
		
		System.out.println("Pronto");
		
	}

}
