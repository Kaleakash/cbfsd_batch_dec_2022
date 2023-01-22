package com.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Category {
@Id
private int cid;
private String cname;
@OneToMany
@JoinColumn(name = "cid",referencedColumnName = "cid")
private List<Product> listOfProduct;

public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public List<Product> getListOfProduct() {
	return listOfProduct;
}
public void setListOfProduct(List<Product> listOfProduct) {
	this.listOfProduct = listOfProduct;
}

}
