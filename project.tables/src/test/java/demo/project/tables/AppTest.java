//AppTest
package demo.project.tables;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import demo.project.tables.Imp.VendorServiceImp;
import demo.project.tables.dao.AddressService;
import demo.project.tables.dao.CategoryService;
import demo.project.tables.dao.ProductService;
import demo.project.tables.dao.SubCategoryService;
import demo.project.tables.dao.VendorService;
import demo.project.tables.model.Address;
import demo.project.tables.model.Category;
import demo.project.tables.model.Products;
import demo.project.tables.model.SubCategory;
import demo.project.tables.model.Vendor;
import demo.project.tables.products.Laptop;
import demo.project.tables.productsDao.LaptopService;

@SpringJUnitConfig(classes={HibernateConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest
{
	@Autowired
	private Vendor vendor;
	@Autowired
	private Category category;
	@Autowired
	private SubCategory subCategory;
	@Autowired
	private Laptop laptop;
	private Address address1;
	private Address address2;
	
	
	
	@Autowired
	private VendorService vendorSevice;
	@Autowired
	private AddressService addressService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private SubCategoryService subCategoryService;
	@Autowired
	private LaptopService laptopService;
	

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Before
	public  void setUp()
	{
		AnnotationConfigApplicationContext annotationConfigApplicationContext=new  AnnotationConfigApplicationContext(HibernateConfig.class);
		
		vendor.setCompanyName("Amazon");
		vendor.setEmail("raghu@gmail.com");
		vendor.setMobile("9594930075");
		vendor.setName("raghu");
		vendor.setPassword("raghu");
		vendor.getVid();

		
		HashSet<Address> hashSet=new HashSet<Address>();
		address1=new Address();
		address2=new Address();
		address1.setStreetNo(2);
		address2.setStreetNo(3);
		address1.setCity("Hyderabad");
		address2.setCity("Tenali");
		address1.setDistrict("Telangana");
		address2.setDistrict("Guntur");
		
		hashSet.add(address1);
		hashSet.add(address2);
		vendor.setAddresses(hashSet);
		address1.setVendor(vendor);
		address2.setVendor(vendor);
		
		
		
		laptop.setRam("8gb");
		laptop.setRom("4gb");
		laptop.setProcessor("i7");
	}
	
	
	@Test
	public void addVendorTest()
	{
		assertEquals("Test vendor adding Failed",true,vendorSevice.addVendor(vendor));
		deleteVendor();
	}
	public void deleteVendor()
	{
		vendorSevice.deleteVendor(vendor);
	}
	
	public void getVendorByEmail()
	{
		vendorSevice.addVendor(vendor);
		assertEquals("test by email failed",true,vendorSevice.getVendorByEmail(vendor.getEmail()));
	}
	
	public void getVendor()
	{
		assertEquals("getting vendor",true,vendorSevice.addVendor(vendor));
	}
	
	
	@Test
	public void addLaptop()
	{
		subCategory=subCategoryService.getSubCategory(1);
		vendorSevice.addVendor(vendor);
		laptop.setVendor(vendor);
		laptop.setSubCategory(subCategory);
		assertEquals("Test Insertion laptop failed",true,laptopService.addLaptop(laptop));
		deleteLaptop();
		deleteVendor();
	}
	private void deleteLaptop() 
	{
	laptopService.deleteLaptop(laptop);
	}
}
