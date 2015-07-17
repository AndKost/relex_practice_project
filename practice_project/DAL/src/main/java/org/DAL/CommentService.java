package org.DAL;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.DAL.model.Comment;

@Stateless
public class CommentService extends CommentDAO {
	@PersistenceContext
	EntityManager entityManager;
	@Override
	EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void insertComment(Comment comment) {
		super.insertComment(comment);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addComment(Comment comment, int bonus) {
		super.addComment(comment, bonus);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void voteForComment(long id, int bonus) {
		super.voteForComment(id, bonus);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Comment getCommentById(long id) {
		return super.getCommentById(id);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void removeComment(int сommentId) {
		super.removeComment(сommentId);
	}
}
