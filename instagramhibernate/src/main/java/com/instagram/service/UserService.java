package com.instagram.service;
import com.instagram.dao.UserDAO;
import com.instagram.entity.User;
import java.util.List;
public class UserService{
 private final UserDAO dao=new UserDAO();
 public User register(User u){ if(dao.findByUsername(u.getUsername())!=null) throw new IllegalArgumentException("Username already exists"); return dao.save(u);}
 public User login(String u,String p){return dao.login(u,p);}
 public User findById(Long id){return dao.findById(id);}
 public List<User> search(String q){return dao.search(q);}
 public User update(User u){return dao.update(u);}
}