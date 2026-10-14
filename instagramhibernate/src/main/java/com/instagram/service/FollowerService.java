package com.instagram.service;
import com.instagram.dao.FollowerDAO;
import com.instagram.entity.Follower;
import com.instagram.entity.User;
import java.util.List;
public class FollowerService{
 private final FollowerDAO dao=new FollowerDAO();
 public boolean toggle(Follower f){if(dao.exists(f.getFollower().getId(),f.getFollowing().getId())){dao.remove(f.getFollower().getId(),f.getFollowing().getId());return false;}dao.save(f);return true;}
 public List<User> followers(Long id){return dao.followers(id);}
 public List<User> following(Long id){return dao.following(id);}
 public long followersCount(Long id){return dao.followersCount(id);}
 public long followingCount(Long id){return dao.followingCount(id);}
}