package com.ty.springBoot_FoodApp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	@NotNull(message = "Product should not be null")
	@NotBlank(message = "Product should not be blank")
	private String pname;
	@NotNull(message = "Description should not be null")
	@NotBlank(message = "Description should not be blank")
	private String description;
	@NotNull(message = "Price should not be null")
	@NotBlank(message = "Price should not be blank")
	private String price;
	@NotNull(message = "Category should not be null")
	@NotBlank(message = "Category should not be blank")
	private String category;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
