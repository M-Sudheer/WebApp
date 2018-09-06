//AppTest
package demo.project.tables;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import demo.project.tables.dao.AddressService;
import demo.project.tables.dao.AdminService;
import demo.project.tables.dao.CategoryService;
import demo.project.tables.dao.SubCategoryService;
import demo.project.tables.dao.UserService;
import demo.project.tables.model.Address;
import demo.project.tables.model.Admin;
import demo.project.tables.model.Category;
import demo.project.tables.model.SubCategory;
import demo.project.tables.model.User;
import demo.project.tables.products.Laptop;
import demo.project.tables.productsDao.LaptopService;

@SpringJUnitConfig(classes={HibernateConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AppTest
{
	@Autowired
	private User user;
	@Autowired
	private Category category;
	@Autowired
	private SubCategory subCategory;
	@Autowired
	private Laptop laptop;
	@Autowired
	private Admin admin;

	
	@Autowired
	private UserService userSevice;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private SubCategoryService subCategoryService;
	@Autowired
	private LaptopService laptopService;
	@Autowired
	private AdminService adminService;
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Before
	public  void setUp()
	{
		AnnotationConfigApplicationContext annotationConfigApplicationContext=new  AnnotationConfigApplicationContext(HibernateConfig.class);
		
		user.setName("sudheer");
		user.setEmail("sudheer@gmail.com");
		user.setMobile("9989873796");
		user.setPassword("sudheer");
		user.setCompanyName("Amazon");
		user.setRole("Customer");
		user.getUser_id();


		laptop.setRam("8gb");
		laptop.setRom("4gb");
		laptop.setProcessor("i7");
		
		
		admin.setName("Sudheer");
		admin.setPassword("sudheer");
		
	}
	
	
	@Test
	public void addUser()
	{
		assertEquals("Test user adding Failed",true,userSevice.addUser(user));
		deleteUser();
	}
	public void deleteUser()
	{
		userSevice.deleteUser(user);
	}
	
	public void getUserByEmail()
	{
		userSevice.addUser(user);
		assertEquals("test by email failed",true,userSevice.getUserByEmail(user.getEmail()));
	}
	
	public void getUser()
	{
		assertEquals("getting user",true,userSevice.addUser(user));
	}
	
	
	@Test
	public void addLaptop()
	{
		subCategory=subCategoryService.getSubCategory(1);
		userSevice.addUser(user);
		laptop.setSubCategory(subCategory);
		assertEquals("Test Insertion laptop failed",true,laptopService.addLaptop(laptop));
		deleteLaptop();
		deleteUser();
	}
	
	private void deleteLaptop() 
	{
	laptopService.deleteLaptop(laptop);
	}
	
	@Test
	public void addAdmin()

	{
		assertEquals("Admin test failed",true,adminService.addAdmin(admin));
		deleteAdmin();
	}
	public void deleteAdmin()
	{
		adminService.deleteAdmin(admin);
	}
}
