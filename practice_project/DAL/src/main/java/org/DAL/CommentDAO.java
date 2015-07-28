package org.DAL;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.DAL.model.Citizen;
import org.DAL.model.Comment;
import org.DAL.model.Person;

public abstract class CommentDAO {

	abstract EntityManager getEntityManager();

	public void insertComment(Comment comment)
	{
		getEntityManager().persist(comment);
	}

	public void addComment(Comment comment, int bonus) {
		insertComment(comment);
		Person p= comment.getAuthor();
		if (p instanceof Citizen) ((Citizen) p).setBonusPoint(((Citizen) p).getBonusPoint()+bonus);
	}

	public void voteForComment(long id, int bonus) {
		Comment comment = getCommentById(id);
		int n = comment.getNumberOfVotes();
		comment.setNumberOfVotes(++n);
		Person p= comment.getAuthor();
		if (p instanceof Citizen) ((Citizen) p).setBonusPoint(((Citizen) p).getBonusPoint()+bonus);
	}


	public Comment getCommentById(long id) {
		return getEntityManager().find(Comment.class, id);
	}

	/*Удаление предложение по id*/
	public void removeComment(int сommentId){
		Comment tmp = getEntityManager().find(Comment.class, сommentId);
		getEntityManager().remove(tmp);
	}
	
	public int changeBonusPoint(long idUser, long bonusPoint)
	{
		Citizen citizen = getEntityManager().find(Citizen.class, idUser);
		if (citizen == null)
			return -1;
		citizen.setBonusPoint(citizen.getBonusPoint() + bonusPoint);
		return 0;
	}
	
	public List<Comment> getCommentForPremoderation()
	{
		List<Comment> result;
		String q = "FROM Comment c WHERE c.premoderation = fasle";
		Query query = getEntityManager().createQuery(q);
		result = query.getResultList();
		return result;
	}
	
}
