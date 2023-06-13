package btl.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Products")
public class Product {
	@Id
	@Column(name = "ProId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "ProName")
	private String proName;
	@Column(name = "Description")
	private String description;
	@Column(name = "Quantity")
	private Integer quantity;
	@Column(name = "Price")
	private Double price;
	@Column(name = "Sale_Price")
	private Double sale_Price;
	@Column(name = "Brand")
	private String brand;
	@Column(name = "created_at")
	private Date created_at;
	@Column(name = "update_at")
	private Date update_at;
	@Column(name = "delete_at")
	private Date delete_at;
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "product")
	private Set<Carousel> carousel;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Long id, String proName, String description, Integer quantity, Double price, Double sale_Price,
			String brand, Date created_at, Date update_at, Date delete_at, Set<Carousel> carousel, Category category) {
		super();
		this.id = id;
		this.proName = proName;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.sale_Price = sale_Price;
		this.brand = brand;
		this.created_at = created_at;
		this.update_at = update_at;
		this.delete_at = delete_at;
		this.carousel = carousel;
		this.category = category;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getSale_Price() {
		return sale_Price;
	}
	public void setSale_Price(Double sale_Price) {
		this.sale_Price = sale_Price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
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
	public Set<Carousel> getCarousel() {
		return carousel;
	}
	public void setCarousel(Set<Carousel> carousel) {
		this.carousel = carousel;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
