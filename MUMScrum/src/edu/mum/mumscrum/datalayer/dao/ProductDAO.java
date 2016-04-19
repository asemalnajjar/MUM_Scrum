package edu.mum.mumscrum.datalayer.dao;

import java.util.List;

import org.eclipse.persistence.expressions.Expression;
import org.eclipse.persistence.expressions.ExpressionBuilder;

import edu.mum.mumscrum.common.ConfigurationConstants.SortingType;
import edu.mum.mumscrum.datalayer.model.Product;

public class ProductDAO {

	private static ProductDAO productDAO;
	private MUMScrumDAO mumScrumDAO;

	private ProductDAO() {
		mumScrumDAO = MUMScrumDAO.getInstance();
	}

	public static ProductDAO getInstance() {
		if (productDAO == null) {
			return new ProductDAO();
		}
		return productDAO;
	}

	public List<Product> getAllProducts() {
		return mumScrumDAO.getAllObjectsByExpression(Product.class,
				new ExpressionBuilder(), SortingType.ASCENDING, "id");
	}

	public Product getProductById(String id) {
		Expression expression = new ExpressionBuilder().get("id").equal(id);
		return mumScrumDAO.getObjectByExpression(Product.class, expression);
	}

	public Product addProduct(Product product) {
		return mumScrumDAO.addObject(product);
	}

	public Product updateProduct(Product product) {
		return mumScrumDAO.updateObject(product);
	}

	public Product deleteProduct(Product product) {
		return mumScrumDAO.deleteObject(product);
	}

	public List<Product> deleteProductById(String id) {
		Expression expression = new ExpressionBuilder().get("id").equal(id);
		return mumScrumDAO.deleteAllObjectsBasedOnExpression(Product.class,
				expression);
	}

	public void deleteAllChild(String id) {
		String deletesql1 = 
				" delete from PROGRESS_RECORD p where p.usid in ( "
					+ " select us.ID from USERSTORY us where us.PRD_ID = " + id + ")" ;
		String deletesql2 =
				" delete from USERSTORY us where us.PRD_ID = " + id;
		String deletesql3 =
				"delete from SPRINT s where s.RELS_ID in (select r.ID from RELEASE r where r.PRD_ID = " + id + " )" ;
		String deletesql4 = 
				"delete from RELEASE r  where r.PRD_ID = " + id;

		mumScrumDAO.executeNonSelectingSQLCall(deletesql1 );	
		mumScrumDAO.executeNonSelectingSQLCall(deletesql2);
		mumScrumDAO.executeNonSelectingSQLCall(deletesql3);
		mumScrumDAO.executeNonSelectingSQLCall(deletesql4);	

	}

}
