package Management;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Management.model.Patients;

public class AddPatients{
	
	static EntityManagerFactory emFactory;
	static EntityManager eManager ;
	static EntityTransaction enTransaction;
	
	public static void main(String[] args)
	{
		begin();
		create();
		end();
	}


	private static void begin() {
		emFactory = Persistence.createEntityManagerFactory("Management.model");
		eManager = emFactory.createEntityManager();
		enTransaction = eManager.getTransaction();
		enTransaction.begin();
		
	}

	private static void create() {
		Patients patients = new Patients();
		patients.setFirstName("Hello");
		patients.setLastName("World");
		patients.setAge(31);
		eManager.persist(patients);
	}
	
	private static void end() {
		enTransaction.commit();
		eManager.close();
		emFactory.close();
	}
}
