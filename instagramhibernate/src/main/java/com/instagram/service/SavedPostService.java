package com.instagram.service;
import com.instagram.dao.SavedPostDAO;
import com.instagram.entity.SavedPost;
import com.instagram.entity.Post;
import java.util.List;
public class SavedPostService{
 private final SavedPostDAO dao=new SavedPostDAO();
 public boolean toggle(SavedPost s){if(dao.exists(s.getUser().getId(),s.getPost().getId())){dao.remove(s.getUser().getId(),s.getPost().getId());return false;}dao.save(s);return true;}
 public List<Post> byUser(Long id){return dao.byUser(id);}
}