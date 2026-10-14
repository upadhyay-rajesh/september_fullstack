package com.instagram.service;
import com.instagram.dao.HashtagDAO;
import com.instagram.dao.PostHashtagDAO;
import com.instagram.entity.*;
import java.util.*;
public class HashtagService{
 private final HashtagDAO dao=new HashtagDAO(); private final PostHashtagDAO phDao=new PostHashtagDAO();
 public void addToPost(Post p,String raw){
  if(raw==null)return;
  for(String x:raw.split("\\s+")){
   if(x.startsWith("#")&&x.length()>1){
    String n=x.substring(1).toLowerCase(); Hashtag h=dao.findByName(n);
    if(h==null){h=new Hashtag();h.setName(n);h=dao.save(h);}
    PostHashtag ph=new PostHashtag();ph.setPost(p);ph.setHashtag(h);phDao.save(ph);
   }
  }
 }
 public List<Post> posts(String n){return dao.posts(n.replace("#","").toLowerCase());}
}