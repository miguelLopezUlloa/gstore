package com.store.admin.web.models;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;
import com.store.entities.Product;
import com.store.admin.web.utils.WebUtils;
import com.store.entities.Category;

import lombok.Data;

@Data
public class ProductForm 
{
	private Integer id;
	
	@NotEmpty
	private String sku;
	
	@NotEmpty
	private String name;
	private String description;
	
	@NotNull
	@DecimalMin("0.1")
	private BigDecimal price = new BigDecimal("0.0");
	private String imageUrl;
	private MultipartFile image;
	private boolean disabled;
	
	@NotNull
	private Integer categoryId;
	
	public Product toProduct() {
		Product p = new Product();
		
		p.setId(id);
		p.setName(name);
		p.setDescription(description);
		p.setDisabled(disabled);
		p.setPrice(price);
		p.setSku(sku);
		
		Category category = new Category();
		category.setId(categoryId);
		p.setCategory(category );
		p.setImageUrl(WebUtils.IMAGES_PREFIX+id+".jpg");
		return p;
	}
	
	public static ProductForm fromProduct(Product product)
	{
		ProductForm p = new ProductForm();
		
		p.setId(product.getId());
		p.setName(product.getName());
		p.setDescription(product.getDescription());
		p.setDisabled(product.isDisabled());
		p.setPrice(product.getPrice());
		p.setSku(product.getSku());
		p.setCategoryId(product.getCategory().getId());
		//p.setImageUrl(WebUtils.IMAGES_PREFIX+product.getId()+".jpg");
		return p;
	}
}
