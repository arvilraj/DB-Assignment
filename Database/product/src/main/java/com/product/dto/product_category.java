package com.product.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class product_category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private String description;
	@CreationTimestamp
	private LocalDateTime created_at;
	@UpdateTimestamp
	private LocalDateTime modified_at;
	@UpdateTimestamp
	private LocalDateTime deleted_at;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private product prod;
}
