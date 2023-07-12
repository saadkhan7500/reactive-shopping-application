package com.ShoppyReactive.dto;

public class ProductDto {
	
	private String id;
	private String ownerEmail;
	private String ownerName;
	private String ownerContact;
	private String name;
	private String price;
	private String category;
	private String details;
	private String discount;
	private String size;
	private String quantity;
	private String imagePath;
	private String status;
	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDto(String id, String ownerEmail, String ownerName, String ownerContact, String name, String price,
			String category, String details, String discount, String size, String quantity, String imagePath,
			String status) {
		super();
		this.id = id;
		this.ownerEmail = ownerEmail;
		this.ownerName = ownerName;
		this.ownerContact = ownerContact;
		this.name = name;
		this.price = price;
		this.category = category;
		this.details = details;
		this.discount = discount;
		this.size = size;
		this.quantity = quantity;
		this.imagePath = imagePath;
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOwnerEmail() {
		return ownerEmail;
	}
	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerContact() {
		return ownerContact;
	}
	public void setOwnerContact(String ownerContact) {
		this.ownerContact = ownerContact;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", ownerEmail=" + ownerEmail + ", ownerName=" + ownerName + ", ownerContact="
				+ ownerContact + ", name=" + name + ", price=" + price + ", category=" + category + ", details="
				+ details + ", discount=" + discount + ", size=" + size + ", quantity=" + quantity + ", imagePath="
				+ imagePath + ", status=" + status + "]";
	}
	
	

}
