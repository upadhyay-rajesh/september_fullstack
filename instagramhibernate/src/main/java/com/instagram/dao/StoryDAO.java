package com.instagram.dao;
import com.instagram.entity.Story;
import java.util.List;
public class StoryDAO extends BaseDAO<Story>{
 public StoryDAO(){super(Story.class);}
 public List<Story> active(){return tx(s->s.createQuery("from Story s join fetch s.user where s.expiresAt>current_timestamp order by s.createdAt desc",Story.class).getResultList());}
 public List<Story> byUser(Long id){return tx(s->s.createQuery("from Story s where s.user.id=:id and s.expiresAt>current_timestamp order by s.createdAt desc",Story.class).setParameter("id",id).getResultList());}
}