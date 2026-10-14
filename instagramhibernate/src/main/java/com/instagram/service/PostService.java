package com.instagram.service;
import com.instagram.dao.PostDAO;
import com.instagram.entity.Post;
import java.util.List;
public class PostService{
 private final PostDAO dao=new PostDAO();
 public Post save(Post p){return dao.save(p);}
 public Post find(Long id){return dao.findById(id);}
 public void delete(Post p){dao.delete(p);}
 public List<Post> byUser(Long id){return dao.byUser(id);}
 public List<Post> feed(Long id,int page,int size){return dao.feed(id,page,size);}
 public List<Post> search(String q){return dao.search(q);}
}