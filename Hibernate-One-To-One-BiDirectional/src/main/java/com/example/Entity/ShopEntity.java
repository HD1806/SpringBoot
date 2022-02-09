package com.example.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.Dto.ShopDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Shop")
public class ShopEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="Shop_Name")
	private String ShopName;
	
	@Column(name="Shop_Address")
	private String ShopAdd;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Shop_id")
	@JsonIgnore
	private OwnerEntity ownerentity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public OwnerEntity getOwnerentity() {
		return ownerentity;
	}

	public void setOwnerentity(OwnerEntity ownerentity) {
		this.ownerentity = ownerentity;
	}
	
	public ShopEntity(ShopDto shopdto) {
		this.ShopName=shopdto.getShopName();
		this.ShopAdd=shopdto.getShopAdd();
	}

	public ShopEntity() {
		// TODO Auto-generated constructor stub
	}

}
