package org.btm;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveHospital {

	public static void main(String[] args) {
		
		EntityManagerFactory factory =Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		Hospital hospital= new Hospital();
		hospital.setName("apollo");
		hospital.setFounder("sindhu");
		hospital.setGst(123456);
		
		Branch b1 = new Branch();
		b1.setName("bangalore");
		b1.setPhone(12345678L);
		b1.setEmail("sindhu@gmail123");
		
		Branch b2 = new Branch();
		b2.setName("mysore");
		b2.setPhone(12345688L);
		b2.setEmail("sind123@gmail123");
		
		Branch b3 = new Branch();
		b3.setName("mandya");
		b3.setPhone(11145678L);
		b3.setEmail("abcdhu@gmail123");
		
		List<Branch> branchs =new ArrayList<Branch>();
		branchs.add(b1);
		branchs.add(b2);
		branchs.add(b3);
		
		hospital.setBranchs(branchs);
		transaction.begin();
		manager.persist(hospital);
		manager.persist(b1);
		manager.persist(b2);
		manager.persist(b3);
		transaction.commit();
		
		

	}

}
