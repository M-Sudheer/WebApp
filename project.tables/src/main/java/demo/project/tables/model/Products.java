//Products
package demo.project.tables.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Component("products")
public class Products
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int product_id;
	private String brand;
	private String color;
	private int warrantyPeriod;
	
	/*@ManyToOne(fetch = FetchType.LAZY)
    private Vendor */
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private SubCategory subCategory;
	
	public SubCategory getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(SubCategory subCategory) 
	{
		this.subCategory = subCategory;
	}
	public int getProduct_id() 
	{
		return product_id;
	}
	public String getBrand() 
	{
		return brand;
	}
	public void setBrand(String brand) 
	{
		this.brand = brand;
	}
	public String getColor() 
	{
		return color;
	}
	public void setColor(String color) 
	{
		this.color = color;
	}
	public int getWarrantyPeriod() 
	{
		return warrantyPeriod;
	}
	public void setWarrantyPeriod(int warrantyPeriod) 
	{
		this.warrantyPeriod = warrantyPeriod;
	}
	public User getUser() 
	{
		return user;
	}
	public void setUser(User vendor) 
	{
		this.user = vendor;
	}

	public void setProduct_id(int product_id) 
	{
		this.product_id = product_id;
	}
}
