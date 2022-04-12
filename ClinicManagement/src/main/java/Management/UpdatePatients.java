package Management;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Management.model.Patients;

public class UpdatePatients {

	static EntityManagerFactory emFactory;
	static EntityManager eManager ;
	static EntityTransaction enTransaction;
	
	public static void main(String[] args)
	{
		begin();
		update();
		end();
	}


	private static void begin() {
		emFactory = Persistence.createEntityManagerFactory("Management.model");
		eManager = emFactory.createEntityManager();
		enTransaction = eManager.getTransaction();
		enTransaction.begin();
		
	}
	
	private static void update() {
		Integer primaryKey = 1;
		Patients ref = eManager.find(Patients.class, primaryKey);
		ref.setFirstName("hello");
		ref.setLastName("wld");
		ref.setAge(45);
	}
	

	private static void end() {
		enTransaction.commit();
		eManager.close();
		emFactory.close();
	}

}
