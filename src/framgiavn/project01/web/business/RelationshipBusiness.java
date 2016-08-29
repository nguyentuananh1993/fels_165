package framgiavn.project01.web.business;

import framgiavn.project01.web.model.Relationship;

public interface RelationshipBusiness {

	public int createRelationship(Relationship relationship) throws Exception;

	public Relationship deleteById(int follower_id, int following_id) throws Exception;

	public Relationship findRelationshipById(int follower_id, int following_id) throws Exception;

}
