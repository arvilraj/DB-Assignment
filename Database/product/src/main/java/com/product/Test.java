package com.product;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.product.dao.productDao;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(config.class);
		productDao pDao = context.getBean(productDao.class);
		System.out.println(pDao);
	}
}
