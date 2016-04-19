package edu.mum.mumscrum.datalayer.dao;

import java.util.Collection;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.eclipse.persistence.expressions.Expression;
import org.eclipse.persistence.jpa.JpaEntityManager;
import org.eclipse.persistence.queries.ReadAllQuery;
import org.eclipse.persistence.queries.SQLCall;
import org.eclipse.persistence.sessions.UnitOfWork;

import edu.mum.mumscrum.common.ConfigurationConstants.SortingType;

public class MUMScrumDAO {

	private static MUMScrumDAO mumScrumDAO;
	private static final String persistenceUnitName = "DataLayer";
	private static EntityManagerFactory factory;
	private JpaEntityManager em;
	private UnitOfWork uow;

	private MUMScrumDAO() {
		factory = Persistence.createEntityManagerFactory(persistenceUnitName);
	}

	public static MUMScrumDAO getInstance() {
		if (mumScrumDAO == null) {
			return new MUMScrumDAO();
		}
		return mumScrumDAO;
	}

	private void instantiateConnection() {
		em = (JpaEntityManager) factory.createEntityManager();
		em.getTransaction().begin();
		uow = em.getUnitOfWork();
	}

	private void terminateConnection() {
		em.getTransaction().commit();
		uow.release();
		em.close();
	}

	private ReadAllQuery createReadAllQuery(Class clazz, Expression expression,
			SortingType sortingType, String columnName) {
		ReadAllQuery query = new ReadAllQuery();
		query.setReferenceClass(clazz);
		query.setSelectionCriteria(expression);
		if (sortingType.equals(SortingType.ASCENDING)) {
			query.addAscendingOrdering(columnName);
		} else {
			query.addDescendingOrdering(columnName);
		}
		return query;
	}

	public <T> T getAllObjects(Class clazz) {
		instantiateConnection();
		T clone;
		clone = (T) uow.readAllObjects(clazz);
		terminateConnection();
		return clone;
	}

	public <T> T getAllObjectsByExpression(Class clazz, Expression expression) {
		instantiateConnection();
		T clone;
		clone = (T) uow.readAllObjects(clazz, expression);
		terminateConnection();
		return clone;
	}

	public <T> T getAllObjectsByExpression(Class clazz, Expression expression,
			SortingType sortingType, String columnName) {
		instantiateConnection();
		ReadAllQuery query = createReadAllQuery(clazz, expression, sortingType,
				columnName);

		T clone;
		clone = (T) uow.executeQuery(query);
		terminateConnection();
		return clone;
	}

	public <T> T getObjectByExpression(Class clazz, Expression expression) {
		instantiateConnection();

		T clone;
		clone = (T) uow.readObject(clazz, expression);
		terminateConnection();
		return clone;
	}

	public <T> T addObject(T t) {
		instantiateConnection();
		T clone;
		clone = (T) uow.registerObject(t);
		// System.out.println(clone.toString());
		terminateConnection();
		return clone;
	}

	public <T> T updateObject(T t) {
		instantiateConnection();
		T clone;
		clone = (T) uow.deepMergeClone(t);
		terminateConnection();
		return clone;
	}

	public int executeNonSelectingSQLCall(String sql) {
		instantiateConnection();
		try {
			uow.executeNonSelectingCall(new SQLCall(sql));
			return 1;// Success

		} catch (Exception ex) {
			System.out
					.println(" MumScrumDao.executeNonSelectingSQLCall catch msg "
							+ ex.getMessage());
			return -1;// fail

		} finally {
			System.out.println(" terminate Connection ");
			terminateConnection();
		}
	}

	public <T> T deleteObject(T t) {
		instantiateConnection();
		T clone;
		clone = (T) uow.deleteObject(t);
		terminateConnection();
		return clone;
	}

	public <T> void deleteAllObjects(T objects) {
		instantiateConnection();
		uow.deleteAllObjects((Collection) objects);
		terminateConnection();
	}

	public <T> T deleteAllObjectsBasedOnExpression(Class clazz,
			Expression expression) {
		T clone;
		clone = getAllObjectsByExpression(clazz, expression);
		deleteAllObjects(clone);
		return clone;
	}
}
