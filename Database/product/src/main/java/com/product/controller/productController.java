package com.product.controller;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.product.config;
import com.product.dao.productDao;
import com.product.dto.product;

public class productController {

	static productDao pDao;
	static Scanner sc = new Scanner(System.in);

	static {
		ApplicationContext context = new AnnotationConfigApplicationContext(config.class);
		pDao = context.getBean(productDao.class);
	}

	public static void main(String[] args) {
		System.out.println("1.Save Product");
		System.out.println("2.Update Product");
		System.out.println("3.Find Product by id");

		switch (sc.nextInt()) {
		case 1: {
			saveProduct();
			break;
		}
		case 2: {
			updateProduct();
			break;
		}
		case 3: {
			findProduct();
			break;
		}

		default: {
			System.out.println("Thank you! Application closed!");
		}
		}
	}

	public static void saveProduct() {
		System.out.println("Enter name, description, SKU, category id, inventory id, price and discount id");
		product p = new product();
		p.setName(sc.next());
		p.setDescription(sc.next());
		p.setSKU(sc.next());
		p.setCategory_id(sc.nextInt());
		p.setInventory_id(sc.nextInt());
		p.setPrice(sc.nextDouble());
		p.setDiscount_id(sc.nextInt());
		p = pDao.saveProduct(p);
		System.out.println("Product saved with id " + p.getId());
	}

	public static void updateProduct() {
		System.out.println("Enter Product id to update ");
		int id = sc.nextInt();
		System.out.println("Enter name, description, SKU, category id, inventory id, price and discount id");
		product p = new product();
		p.setId(id);
		p.setName(sc.next());
		p.setDescription(sc.next());
		p.setSKU(sc.next());
		p.setCategory_id(sc.nextInt());
		p.setInventory_id(sc.nextInt());
		p.setPrice(sc.nextDouble());
		p.setDiscount_id(sc.nextInt());
		p = pDao.updateProduct(p);
		System.out.println("Product updated!");
	}

	public static void findProduct() {
		System.out.println("Enter Product id to find Product:");
		int id = sc.nextInt();
		product p = pDao.findById(id);
		if (p != null) {
			System.out.println(p);
//			System.out.println("Id:" + p.getId());
//			System.out.println("Name:" + p.getName());
		} else {
			System.err.println("Invalid Id");
		}
	}
}
