package fr.codeonce.examples.rest;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ProductDto {

	private String code;
	private String title;
	private float quantity;
	private BigDecimal price;
	
	public ProductDto(String code, String title, float quantity, BigDecimal price) {
		super();
		this.code = code;
		this.title = title;
		this.quantity = quantity;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "ProductDto [code=" + code + ", title=" + title + ", quantity=" + quantity + ", price=" + price + "]";
	}

	public ProductDto() {
		// TODO Auto-generated constructor stub
	}

	


	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
    @Override
	 public int hashCode() {
	     // you pick a hard-coded, randomly chosen, non-zero, odd number
	     // ideally different for each class
	     return new HashCodeBuilder(17, 37).
	       append(code).
	       append(title).
	       toHashCode();
	   }
    
    
    @Override
    public boolean equals(Object obj) {
    	   if (obj == null) { return false; }
    	   if (obj == this) { return true; }
    	   if (obj.getClass() != getClass()) {
    	     return false;
    	   }
    	   ProductDto rhs = (ProductDto) obj;
    	   return new EqualsBuilder()
    	                 .append(code, rhs.code)
    	                 .append(title, rhs.title)
    	                 .isEquals();
    	  }

	
	
	
	
	
}
