package com.instagram.dao;
import com.instagram.entity.Comment;
import java.util.List;
public class CommentDAO extends BaseDAO<Comment>{
 public CommentDAO(){super(Comment.class);}
 public List<Comment> byPost(Long id){return tx(s->s.createQuery("from Comment c join fetch c.user where c.post.id=:id order by c.createdAt asc",Comment.class).setParameter("id",id).getResultList());}
}