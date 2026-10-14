package com.instagram.service;
import com.instagram.dao.StoryDAO;
import com.instagram.dao.StoryViewDAO;
import com.instagram.entity.Story;
import com.instagram.entity.StoryView;
import java.util.List;
public class StoryService{
 private final StoryDAO dao=new StoryDAO(); private final StoryViewDAO viewDao=new StoryViewDAO();
 public Story save(Story s){return dao.save(s);}
 public List<Story> active(){return dao.active();}
 public List<Story> byUser(Long u){return dao.byUser(u);}
 public boolean view(StoryView v){if(viewDao.exists(v.getStory().getId(),v.getUser().getId()))return false;viewDao.save(v);return true;}
 public long views(Long id){return viewDao.count(id);}
}