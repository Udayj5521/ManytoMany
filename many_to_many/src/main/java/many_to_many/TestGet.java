package many_to_many;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGet {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("uday");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Cab cab = entityManager.find(Cab.class, 1);
		if (cab != null) {
			System.out.println("Cab Driver Name: "+cab.getDriverName());
			System.out.println("Cab Cost: "+cab.getCost());
			System.out.println("=================================");

			List<Person> persons = cab.getPerson();

			for (Person person : persons) {
				System.out.println("Person Name: "+person.getName());
				System.out.println("Person Age: "+person.getAge());
				System.out.println("Person Email: "+person.getEmail());
				System.out.println("--------------");
			}
		} else {
			System.out.println("No Cab exists of giben id");
		}
	}
}
