package com.example.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.Dto.OwnerDto;

@Entity
@Table(name="Owner")
public class OwnerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="Owner_Name")
	private String OwnerName;
	
	@Column(name="Owner_Address")
	private String OwnerAdd;
	
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "ownerentity")
	private ShopEntity shopentity;

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

	public ShopEntity getShopentity() {
		return shopentity;
	}

	public void setShopentity(ShopEntity shopentity) {
		this.shopentity = shopentity;
	}
	
	public OwnerEntity(OwnerDto ownerdto) {
		this.OwnerName=ownerdto.getOwnerName();
		this.OwnerAdd=ownerdto.getOwnerAdd();
	}

	public OwnerEntity() {
		// TODO Auto-generated constructor stub
	}

}
