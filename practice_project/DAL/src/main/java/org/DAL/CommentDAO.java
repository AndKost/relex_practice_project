package org.DAL;

import org.DAL.model.Citizen;
import org.DAL.model.Comment;
import org.DAL.model.Person;

import javax.persistence.EntityManager;

public abstract class CommentDAO {

    abstract EntityManager getEntityManager();

    public void insertComment(Comment comment) {
        getEntityManager().persist(comment);
    }

    public void addComment(Comment comment, int bonus) {
        insertComment(comment);
        Person p = comment.getAuthor();
        if (p instanceof Citizen) ((Citizen) p).setBonusPoint(((Citizen) p).getBonusPoint() + bonus);
    }

    public void voteForComment(long id, int bonus) {
        Comment comment = getCommentById(id);
        int n = comment.getNumberOfVotes();
        comment.setNumberOfVotes(++n);
        Person p = comment.getAuthor();
        if (p instanceof Citizen) ((Citizen) p).setBonusPoint(((Citizen) p).getBonusPoint() + bonus);
    }


    public Comment getCommentById(long id) {
        return getEntityManager().find(Comment.class, id);
    }

    /*Удаление предложение по id*/
    public void removeComment(long сommentId) {
        Comment tmp = getEntityManager().find(Comment.class, сommentId);
        getEntityManager().remove(tmp);
    }
}
