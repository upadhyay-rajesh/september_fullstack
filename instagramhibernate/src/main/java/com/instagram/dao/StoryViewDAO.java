package com.instagram.dao;
import com.instagram.entity.StoryView;
public class StoryViewDAO extends BaseDAO<StoryView>{
 public StoryViewDAO(){super(StoryView.class);}
 public boolean exists(Long s,Long u){return tx(x->x.createQuery("select count(v) from StoryView v where v.story.id=:s and v.user.id=:u",Long.class).setParameter("s",s).setParameter("u",u).uniqueResult()>0);}
 public long count(Long s){return tx(x->x.createQuery("select count(v) from StoryView v where v.story.id=:s",Long.class).setParameter("s",s).uniqueResult());}
}