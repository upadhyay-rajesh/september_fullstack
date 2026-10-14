package com.instagram.service;
import com.instagram.dao.LikeDAO;
import com.instagram.entity.PostLike;
public class LikeService{
 private final LikeDAO dao=new LikeDAO();
 public boolean toggle(PostLike l){ if(dao.exists(l.getPost().getId(),l.getUser().getId())){dao.remove(l.getPost().getId(),l.getUser().getId());return false;} dao.save(l);return true;}
 public long count(Long p){return dao.count(p);}
}