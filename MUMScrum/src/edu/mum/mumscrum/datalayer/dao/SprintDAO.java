package edu.mum.mumscrum.datalayer.dao;

import java.util.List;
import org.eclipse.persistence.expressions.Expression;
import org.eclipse.persistence.expressions.ExpressionBuilder;
import edu.mum.mumscrum.common.ConfigurationConstants.SortingType;
import edu.mum.mumscrum.datalayer.model.Sprint;

public class SprintDAO {
	
	private static SprintDAO sprintDAO;
	private MUMScrumDAO mumScrumDAO;

	private SprintDAO() {
		mumScrumDAO = MUMScrumDAO.getInstance();
	}

	public static SprintDAO getInstance() {
		if (sprintDAO == null) {
			return new SprintDAO();
		}
		return sprintDAO;
	}

	public List<Sprint> getAllSprintes()
	{
		return mumScrumDAO.getAllObjectsByExpression(Sprint.class, new ExpressionBuilder(), 
				SortingType.ASCENDING ,"id");				
	}
	
	public Sprint getSprintById(String id )
	{
		Expression exp = new ExpressionBuilder().get("id").equal(id);
		return mumScrumDAO.getObjectByExpression(Sprint.class, exp); 
	}

	public Sprint addSprint(Sprint sprint) {
		return mumScrumDAO.addObject(sprint);
	}

	public Sprint updateSprint(Sprint sprint) {
		return mumScrumDAO.updateObject(sprint);
	}

	public Sprint deleteSprint(Sprint sprint) {
		return mumScrumDAO.deleteObject(sprint);
	}

	public List<Sprint> deleteSprintById(String id) {
		Expression exp = new ExpressionBuilder().get("id").equal(id);
		return mumScrumDAO.deleteAllObjectsBasedOnExpression(Sprint.class, exp);
	}

	public void setReleasIdNull(String id) {
		String updateussql  = " update userStory set  spr_id = null where  spr_ID = " + id ;
		String updatesprsql = " update progress_record set  spr_id = null where  spr_ID = " + id ;
    	mumScrumDAO.executeNonSelectingSQLCall(updateussql);
    	mumScrumDAO.executeNonSelectingSQLCall(updatesprsql);
	}
	
}
