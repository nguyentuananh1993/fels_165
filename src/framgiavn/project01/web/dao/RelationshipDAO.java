package framgiavn.project01.web.dao;

import framgiavn.project01.web.model.Relationship;

public interface RelationshipDAO {

	public int createRelationship(Relationship relationship);

	public Relationship deleteRelationshipById(int follower_id, int following_id) throws Exception;

	public Relationship findRelationshipById(int follower_id, int following_id) throws Exception;

}
