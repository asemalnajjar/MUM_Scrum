package edu.mum.mumscrum.service;
import java.util.List;

import edu.mum.mumscrum.datalayer.dao.ReleaseDAO;
import edu.mum.mumscrum.datalayer.model.Release;

public class ReleaseService {

	ReleaseDAO releasedao;
	
	public ReleaseService() {
		releasedao = ReleaseDAO.getInstance();
	}
	
	public List<Release> getAllReleases()
	{
		return releasedao.getAllReleases();
	}
	
	public Release getReleaseById(String id)
	{

		return releasedao.getReleaseById(id);
		
	}
	
	public Release updateRelease(Release release)
	{
		return releasedao.updateRelease(release);
	}
	
	public Release deleteRelease(Release release)
	{	
		
		return releasedao.deleteRelease(release);
	}
	
	public List<Release> deleteReleaseById(String id)
	{
		return releasedao.deleteReleaseById(id);
	}
	public Release addRelease(Release release) {
		
		return releasedao.addRelease(release);
	}
	
	public void setReleasIdNull(String id )
	{
		releasedao.setReleasIdNull(id );
	}
}//ReleaseService
