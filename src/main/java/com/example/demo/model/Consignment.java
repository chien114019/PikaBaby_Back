package com.example.demo.model;

import java.util.Date;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

//	託售申請
@Entity
@Table(name = "Consignment")
public class Consignment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
    @Temporal(TemporalType.DATE)
	private Date applyDate;
    
	private String productName;
    
    private String img1;
    private String img2;
    private String img3;
    
	private String pCondition;
	private Integer quantity;
	private Integer delivery;
	
    @Temporal(TemporalType.DATE)
	private Date deliveryDate;
    
	private Integer review = 0;
	
	private Integer price;
	private String produceYear;
	
	private Boolean received = false;
	
	@Temporal(TemporalType.DATE)
	private Date pointDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public String getpCondition() {
		return pCondition;
	}
	public void setpCondition(String pCondition) {
		this.pCondition = pCondition;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getDelivery() {
		return delivery;
	}
	public void setDelivery(Integer delivery) {
		this.delivery = delivery;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Integer getReview() {
		return review;
	}
	public void setReview(Integer review) {
		this.review = review;
	}
	public Boolean getReceived() {
		return received;
	}
	public void setReceived(Boolean received) {
		this.received = received;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getProduceYear() {
		return produceYear;
	}
	public void setProduceYear(String produceYear) {
		this.produceYear = produceYear;
	}
	public Date getPointDate() {
		return pointDate;
	}
	public void setPointDate(Date pointDate) {
		this.pointDate = pointDate;
	}

	
//	------------------------------------



	@ManyToOne
	@JoinColumn(name = "custId")
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

//	------------------------------------

	@ManyToOne
	@JoinColumn(name = "type")
	private ProductType productType;
	
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
//	------------------------------------


	@ManyToOne
	@JoinColumn(name = "withdrawId")
	private Withdrawal withdrawal;

	public Withdrawal getWithdrawal() {
		return withdrawal;
	}
	public void setWithdrawal(Withdrawal withdrawal) {
		this.withdrawal = withdrawal;
	}
	
	
	
}
