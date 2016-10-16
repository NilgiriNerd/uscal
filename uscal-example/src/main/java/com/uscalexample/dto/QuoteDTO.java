package com.uscalexample.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class QuoteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String code = "";
	private String time = "";
	private BigDecimal  price = null;
	
	public QuoteDTO(){
		
	}
	
	public QuoteDTO(String code, String time, BigDecimal price){
		this.code = code;
		this.time = time;
		this.price = price;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
