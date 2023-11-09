package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerLocator {
	
	
	
		
			
			public static EntityManager getEntityManager() {
				EntityManagerFactory factory=Persistence.createEntityManagerFactory("cursosPU");
				return factory.createEntityManager();
			}

}
