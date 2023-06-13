package btl.dao;

import java.util.List;

import btl.entities.Carousel;


public interface CarouselDAO {
	public List<Carousel> getCarouselByProductId(Integer proId);
}
