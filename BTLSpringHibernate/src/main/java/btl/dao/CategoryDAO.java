	package btl.dao;

import java.util.List;

import btl.entities.Category;

public interface CategoryDAO {
	public List<Category> getAllCate();
	public boolean insertCate(Category cat);
	public Category getCateById(Integer catId);
	public boolean updateCat(Category cat);
	public boolean deleteCat(Integer catId);
}
