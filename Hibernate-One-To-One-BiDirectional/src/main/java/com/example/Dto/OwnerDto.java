package com.example.Dto;

public class OwnerDto {
	
	private int id;
	private String OwnerName;
	private String OwnerAdd;
	private String ShopName;
	private String ShopAdd;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOwnerName() {
		return OwnerName;
	}
	public void setOwnerName(String ownerName) {
		OwnerName = ownerName;
	}
	public String getOwnerAdd() {
		return OwnerAdd;
	}
	public void setOwnerAdd(String ownerAdd) {
		OwnerAdd = ownerAdd;
	}
	public String getShopName() {
		return ShopName;
	}
	public void setShopName(String shopName) {
		ShopName = shopName;
	}
	public String getShopAdd() {
		return ShopAdd;
	}
	public void setShopAdd(String shopAdd) {
		ShopAdd = shopAdd;
	}
}
