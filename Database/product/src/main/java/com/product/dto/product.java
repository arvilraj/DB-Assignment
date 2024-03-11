package com.product.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private String SKU;
	@Column(nullable = false)
	private int category_id;
	@Column(nullable = false)
	private int inventory_id;
	@Column(nullable = false)
	private double price;
	@Column(nullable = false)
	private int discount_id;
	@CreationTimestamp
	private LocalDateTime created_at;
	@UpdateTimestamp
	private LocalDateTime modified_at;
	@UpdateTimestamp
	private LocalDateTime deleted_at;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "prod")
	private List<discount> disc;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "prod")
	private List<product_category> cat;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "prod")
	private List<product_inventory> inv;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSKU() {
		return SKU;
	}

	public void setSKU(String sKU) {
		SKU = sKU;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getInventory_id() {
		return inventory_id;
	}

	public void setInventory_id(int inventory_id) {
		this.inventory_id = inventory_id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDiscount_id() {
		return discount_id;
	}

	public void setDiscount_id(int discount_id) {
		this.discount_id = discount_id;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getModified_at() {
		return modified_at;
	}

	public void setModified_at(LocalDateTime modified_at) {
		this.modified_at = modified_at;
	}

	public LocalDateTime getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(LocalDateTime deleted_at) {
		this.deleted_at = deleted_at;
	}

	public List<discount> getDisc() {
		return disc;
	}

	public void setDisc(List<discount> disc) {
		this.disc = disc;
	}

	public List<product_category> getCat() {
		return cat;
	}

	public void setCat(List<product_category> cat) {
		this.cat = cat;
	}

	public List<product_inventory> getInv() {
		return inv;
	}

	public void setInv(List<product_inventory> inv) {
		this.inv = inv;
	}

	@Override
	public String toString() {
		return "product [id=" + id + ", name=" + name + ", description=" + description + ", SKU=" + SKU
				+ ", category_id=" + category_id + ", inventory_id=" + inventory_id + ", price=" + price
				+ ", discount_id=" + discount_id + "]";
	}

}
