package edu.mum.mumscrum.datalayer.dao;

import java.util.List;

import org.eclipse.persistence.expressions.Expression;
import org.eclipse.persistence.expressions.ExpressionBuilder;

import edu.mum.mumscrum.common.ConfigurationConstants.SortingType;
import edu.mum.mumscrum.datalayer.model.Release;

public class ReleaseDAO {
	
	private static ReleaseDAO releaseDAO;
	private MUMScrumDAO mumScrumDAO;

	private ReleaseDAO() {
		mumScrumDAO = MUMScrumDAO.getInstance();
	}

	public static ReleaseDAO getInstance() {
		if (releaseDAO == null) {
			return new ReleaseDAO();
		}
		return releaseDAO;
	}

	public List<Release> getAllReleases()
	{
		return mumScrumDAO.getAllObjectsByExpression(Release.class, new ExpressionBuilder(), 
				SortingType.ASCENDING ,"id");	
	}
	
	
	public Release getReleaseById(String id)
	{
		Expression exp = new ExpressionBuilder().get("id").equal(id);
		return mumScrumDAO.getObjectByExpression(Release.class, exp);
	}
	public Release addRelease(Release release)
	{
		return mumScrumDAO.addObject(release);
	}
	
	public Release updateRelease (Release release )
	{

		return mumScrumDAO.updateObject(release);
	}
	
	public Release deleteRelease(Release release)
	{
		return mumScrumDAO.deleteObject(release);
	}
	public List<Release> deleteReleaseById(String id)
	{
		Expression exp = new ExpressionBuilder().get("id").equal(id);
		return mumScrumDAO.deleteAllObjectsBasedOnExpression(Release.class, exp);
	}

	public void setReleasIdNull(String id) {
		String updateussql  = " update userstory set  Rels_id = null where  RELS_ID = " + id;
		String updatesprsql = " update sprint set Rels_id = null where  RELS_ID = " + id  ;
    	mumScrumDAO.executeNonSelectingSQLCall(updateussql);
    	mumScrumDAO.executeNonSelectingSQLCall(updatesprsql);
	}
}
