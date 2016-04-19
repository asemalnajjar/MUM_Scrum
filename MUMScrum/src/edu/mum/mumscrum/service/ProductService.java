package edu.mum.mumscrum.service;

import java.util.List;

import edu.mum.mumscrum.datalayer.dao.ProductDAO;
import edu.mum.mumscrum.datalayer.model.Product;

public class ProductService {

	private ProductDAO productDAO;

	public ProductService() {
		productDAO = ProductDAO.getInstance();
	}

	public List<Product> getAllProducts() {
		return productDAO.getAllProducts();
	}

	public Product getProductById(String id) {
		return productDAO.getProductById(id);
	}

	public Product addProduct(Product product) {
		return productDAO.addProduct(product);
	}

	public Product updateProduct(Product product) {
		return productDAO.updateProduct(product);
	}

	public Product deleteProduct(Product product) {
		return productDAO.deleteProduct(product);
	}

	public List<Product> deleteProductById(String id) {
		return productDAO.deleteProductById(id);
	}

	public void deleteAllChild(String id) {
		productDAO.deleteAllChild(id);

	}

}
