package demo.project.tables.dao;

import java.util.List;

import demo.project.tables.model.Category;

public interface CategoryService 
{
	public abstract boolean addCategory(Category category);
	public List<Category> getCategoryDetails();
}
