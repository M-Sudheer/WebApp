package demo.project.tables.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Component
public class User
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int user_id;
	@Column(unique=true)
	private String name;
	@Column(unique=true)
	private String email;
	@Column(unique=true)
	private String mobile;
	private String companyName;
	@Column(unique=true)
	private String password;
	private String role;
	
	private boolean status=false;
	

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@OneToMany(mappedBy="user")
	private Set<Products> products;

	
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Products> getProducts() {
		return products;
	}

	public void setProducts(Set<Products> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", email=" + email + ", mobile=" + mobile
				+ ", companyName=" + companyName + ", password=" + password + ", products=" + products + "]";
	}

	
	


}
