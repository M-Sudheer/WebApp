//VendorService
package demo.project.tables.dao;

import java.util.List;

import demo.project.tables.model.User;

public interface UserService
{
	public abstract boolean addUser(User user);
	public abstract boolean updateUser(User user);
	public abstract boolean deleteUser(User user);
	public User login(String email,String password);
	public  User getUser(int id); 
	public User getUserByEmail(String email);
	public List<User> getVendorDetails();
}
