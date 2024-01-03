package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tx_sell_dtl")
public class TxSellDtl extends BaseEntity{
	
	@Column(name = "sell_no")
	private String sellNo;

	@Id
	@Column(name = "sell_no_dtl")
	private String sellNoDtl;

	@Column(name = "product_id")
	private String productId;

	private String premi;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getPremi() {
		return premi;
	}
	public void setPremi(String premi) {
		this.premi = premi;
	}
	public String getSellNo() {
		return sellNo;
	}
	public void setSellNo(String sellNo) {
		this.sellNo = sellNo;
	}
	public String getSellNoDtl() {
		return sellNoDtl;
	}
	public void setSellNoDtl(String sellNoDtl) {
		this.sellNoDtl = sellNoDtl;
	}
}
