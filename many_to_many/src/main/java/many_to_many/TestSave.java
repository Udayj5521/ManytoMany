package many_to_many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSave {
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("uday");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Cab cab = new Cab();
		cab.setDriverName("TOM");
		cab.setCost(150);
		
		Person person1 =  new Person();
		person1.setName("Dinga");
		person1.setAge(20);
		person1.setEmail("dinga@gmail.com");
		
		Person person2 =  new Person();
		person2.setName("Jerry");
		person2.setAge(23);
		person2.setEmail("jerry@gmail.com");
		
		List<Person> persons = new ArrayList<Person>();
		persons.add(person1);
		persons.add(person2);
		
		cab.setPerson(persons);
		
		entityTransaction.begin();
		entityManager.persist(cab);
		entityManager.persist(person1);
		entityManager.persist(person2);
		entityTransaction.commit();
	}

}
