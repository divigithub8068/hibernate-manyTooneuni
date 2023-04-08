package com.ty.manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetItemAmzon {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prashi");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Item item = entityManager.find(Item.class, 1);
		if(item != null)
		{
			System.out.println("Item Id  :"+item.getId());
			System.out.println("Item Name:"+item.getName());
			System.out.println("Item Price:"+item.getCost());
			System.out.println("Item Quantity:"+item.getQuantity());
			System.out.println("---------------------------------------");
			AmazonOrder amazonOrder = item.getAmazonOrder();
			System.out.println("Amazon Id:"+amazonOrder.getId());
			System.out.println("Amazon Name:"+amazonOrder.getName());
			System.out.println("Amazon Address:"+amazonOrder.getAddress());
			System.out.println("Amazon Status:"+amazonOrder.getStatus());
		}
		else
		{
			System.out.println("No data is found...!");
		}
	}

}
