package framgiavn.project01.web.business.impl;

import framgiavn.project01.web.business.RelationshipBusiness;
import framgiavn.project01.web.dao.RelationshipDAO;
import framgiavn.project01.web.model.Relationship;

public class RelationshipBusinessImpl implements RelationshipBusiness {
	private RelationshipDAO relationshipDAO;

	public RelationshipDAO getRelationshipDAO() {
		return relationshipDAO;
	}

	public void setRelationshipDAO(RelationshipDAO relationshipDAO) {
		this.relationshipDAO = relationshipDAO;
	}

	@Override
	public int createRelationship(Relationship relationship) throws Exception {
		try {
			return getRelationshipDAO().createRelationship(relationship);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Relationship deleteById(int follower_id, int following_id) throws Exception {
		try {
			return getRelationshipDAO().deleteRelationshipById(follower_id, following_id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override 
	public Relationship findRelationshipById(int follower_id, int following_id) throws Exception {
		try {
			return getRelationshipDAO().findRelationshipById(follower_id, following_id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
