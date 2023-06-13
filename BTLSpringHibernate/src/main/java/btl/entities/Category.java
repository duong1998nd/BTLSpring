package btl.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.Table;

@Entity
@Table(name = "Categories")
public class Category {
	@Id
	@Column(name = "CatId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "CatName")
	private String name;
	@Column(name = "created_at")
	private Date created_at;
	@Column(name = "update_at")
	private Date update_at;
	@Column(name = "delete_at")
	private Date delete_at;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    private List<Product> products;
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(Long id, String name, Date created_at, Date update_at, Date delete_at, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.created_at = created_at;
		this.update_at = update_at;
		this.delete_at = delete_at;
		this.products = products;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdate_at() {
		return update_at;
	}
	public void setUpdate_at(Date update_at) {
		this.update_at = update_at;
	}
	public Date getDelete_at() {
		return delete_at;
	}
	public void setDelete_at(Date delete_at) {
		this.delete_at = delete_at;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
