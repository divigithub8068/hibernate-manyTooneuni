package com.ty.manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveBranchHospital {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prashi");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Branch branch1 = new Branch();
		branch1.setName("BTM Appolo");
		branch1.setState("Karnataka");
		branch1.setCountry("India");
		branch1.setPhone(82654365);
		
		Branch branch2 = new Branch();
		branch2.setName("BTR Appolo");
		branch2.setState("Karnataka");
		branch2.setCountry("India");
		branch2.setPhone(828752565);
		
		Branch branch3 = new Branch();
		branch3.setName("KR Market Appolo");
		branch3.setState("Karnataka");
		branch3.setCountry("India");
		branch3.setPhone(821799865);
		
		Hospital hospital = new Hospital();
		hospital.setName("Appolo");
		hospital.setWeb("Appolo.com");
		
		branch1.setHospital(hospital);
		branch2.setHospital(hospital);
		branch3.setHospital(hospital);
		
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityManager.persist(branch1);
		entityManager.persist(branch2);
		entityManager.persist(branch3);
		entityTransaction.commit();
	}

}
