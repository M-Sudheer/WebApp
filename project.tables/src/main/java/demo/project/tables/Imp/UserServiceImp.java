//VendorServiceImp
package demo.project.tables.Imp;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import demo.project.tables.dao.UserService;
import demo.project.tables.model.User;
import demo.project.tables.model.User;

@Component
@Transactional
public class UserServiceImp implements UserService
{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addUser(User user)
	
	{
		try
		{
			sessionFactory.getCurrentSession().save(user);
			
			return true;
		}
		
		catch (Exception e) 
		{	
			return false;
		}
	}



	@Override
	public boolean deleteUser(User user) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(user);
			
			return true;
		}
		
		catch (Exception e) 
		{	
			return false;
		}

	}



	@Override
	public User login(String email, String password) 
	{
    	Query<User> query=sessionFactory.getCurrentSession().createQuery("from User where email=:email and password=:password",User.class);
        query.setParameter("email",email);
        query.setParameter("password",password);
        return query.getSingleResult();
	}



	@Override
	public User getUser(int id) 
	{
		try
		{
			return sessionFactory.getCurrentSession().get(User.class,id);
		}
		catch (Exception e) 
		{
			return null;
		}
	}

	@Override
	public User getUserByEmail(String email) 
	{
		try
		{
		Query<User> query=sessionFactory.getCurrentSession().createQuery("from Vendor where email=:email",User.class);
		query.setParameter("email",email);
		return query.getSingleResult();
	}
	catch (Exception e) 
		{
		return null;
		}
	}



	@Override
	public boolean updateUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().update(user);
			
			return true;
		}
		
		catch (Exception e) 
		{	
			return false;
		}
	}



	@Override
	public List<User> getVendorDetails() 
	{
		try
		{
			Query<User> query=sessionFactory.getCurrentSession().createQuery("from User where role='vendor'",User.class);
			return query.getResultList();
		}
		catch (Exception e) {

		return null;
	}

	}
}
