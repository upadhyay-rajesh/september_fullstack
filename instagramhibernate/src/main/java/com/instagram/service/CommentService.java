package com.instagram.service;
import com.instagram.dao.CommentDAO;
import com.instagram.entity.Comment;
import java.util.List;
public class CommentService{
 private final CommentDAO dao=new CommentDAO();
 public Comment save(Comment c){return dao.save(c);}
 public void delete(Comment c){dao.delete(c);}
 public List<Comment> byPost(Long id){return dao.byPost(id);}
 public Comment find(Long id){return dao.findById(id);}
}