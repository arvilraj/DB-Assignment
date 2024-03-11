package com.product.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.product.dto.product;

@Repository
public class productDao {
	@Autowired
	public EntityManager manager;

	public product saveProduct(product p) {
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(p);
		transaction.begin();
		transaction.commit();
		return p;
	}

	public product updateProduct(product p) {
		EntityTransaction transaction = manager.getTransaction();
		manager.merge(p);
		transaction.begin();
		transaction.commit();
		return p;
	}

	public product findById(int id) {
		return manager.find(product.class, id);
	}
}
