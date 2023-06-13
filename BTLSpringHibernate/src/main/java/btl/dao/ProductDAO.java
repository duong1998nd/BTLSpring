package btl.dao;

import java.util.List;

import btl.entities.Product;

public interface ProductDAO {
	public List<Product> getAllProduct();
	public boolean insertProduct(Product pro);
	public Product getProductById(Integer proId);
	public boolean updatePro(Product pro);
	public boolean deletePro(Integer proId);
	public List<Product> getProductsByName(String proName);
}
