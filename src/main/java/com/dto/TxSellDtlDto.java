package com.dto;

import com.model.BaseEntity;

public class TxSellDtlDto extends BaseEntity{
	
	private String sellNo;

	private String sellNoDtl;
	private String productId;
	private String premi;

	public String getSellNo() {
		return sellNo;
	}
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
