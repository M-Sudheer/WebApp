
package demo.project.tables.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Entity
@Component("vendor")
public class Vendor 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int vid;
	private String companyName;
	@Column(unique=true)
	private String email;
	@Column(unique=true)
	private String mobile;
	@Column(unique=true)
	private String name;
	private String password;

	
	@OneToMany(mappedBy="vendor",cascade=CascadeType.ALL)
	private List<Products> Productss;
	
	@OneToMany(mappedBy="vendor",cascade=CascadeType.ALL)
	private Set<Address> Addresses;

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Products> getProductss() {
		return Productss;
	}

	public void setProductss(List<Products> productss) {
		Productss = productss;
	}

	public Set<Address> getAddresses() {
		return Addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		Addresses = addresses;
	}

	@Override
	public String toString() {
		return "Vendor [vid=" + vid + ", companyName=" + companyName + ", email=" + email + ", mobile=" + mobile
				+ ", name=" + name + ", password=" + password + ", Productss=" + Productss + ", Addresses=" + Addresses
				+ "]";
	}
}


