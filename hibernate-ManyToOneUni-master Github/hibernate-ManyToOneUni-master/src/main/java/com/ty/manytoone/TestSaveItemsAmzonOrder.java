package com.ty.manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveItemsAmzonOrder {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prashi");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Item item1 = new Item();
		item1.setName("Vegitable");
		item1.setCost(100);
		item1.setQuantity(2);
		
		Item item2 = new Item();
		item2.setName("Food");
		item2.setCost(500);
		item2.setQuantity(1);
		
		Item item3 = new Item();
		item3.setName("Fruits");
		item3.setCost(50);
		item3.setQuantity(1);
		
		AmazonOrder amazonOrder = new AmazonOrder();
		amazonOrder.setName("Prashi");
		amazonOrder.setAddress("BTR");
		amazonOrder.setStatus("get Deleverd");
		
		item1.setAmazonOrder(amazonOrder);
		item2.setAmazonOrder(amazonOrder);
		item3.setAmazonOrder(amazonOrder);
		
		entityTransaction.begin();
		entityManager.persist(amazonOrder);
		entityManager.persist(item1);
		entityManager.persist(item2);
		entityManager.persist(item3);
		entityTransaction.commit();
	}
}
