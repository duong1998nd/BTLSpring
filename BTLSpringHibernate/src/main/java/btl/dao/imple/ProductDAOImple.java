package btl.dao.imple;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import btl.dao.ProductDAO;
import btl.entities.Product;
@Repository
public class ProductDAOImple implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Products").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean insertProduct(Product pro) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			session.save(pro);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public Product getProductById(Integer proId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			Product pro = session.get(Product.class, proId);
			return pro;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean updatePro(Product pro) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(pro);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean deletePro(Integer proId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(getProductById(proId));
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public List<Product> getProductsByName(String proName) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			if(proName==null || proName.length()==0)
				proName = "%";
			else
				proName = "%"+proName+"%";
			
			List list = session.createQuery("from Products where ProName like :proName")
					.setParameter("proName", proName)
					.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

}
