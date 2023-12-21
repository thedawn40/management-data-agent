package com.model.master;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.model.BaseEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ms_product")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class MsProduct extends BaseEntity{
	
	@Id
	private String productId;	
	private String brand;
	private double weight;
	private String unitWeightId;
	private int qty;
	
}
