package com.instagram.dao;
import com.instagram.entity.Post;
import java.util.List;
public class PostDAO extends BaseDAO<Post>{
 public PostDAO(){super(Post.class);}
 public List<Post> byUser(Long id){return tx(s->s.createQuery("from Post p join fetch p.user where p.user.id=:id order by p.createdAt desc",Post.class).setParameter("id",id).getResultList());}
 public List<Post> feed(Long id,int page,int size){return tx(s->s.createQuery("from Post p join fetch p.user where p.user.id=:id or p.user.id in (select f.following.id from Follower f where f.follower.id=:id) order by p.createdAt desc",Post.class).setParameter("id",id).setFirstResult(page*size).setMaxResults(size).getResultList());}
 public List<Post> search(String q){return tx(s->s.createQuery("from Post p join fetch p.user where lower(p.caption) like lower(:q) order by p.createdAt desc",Post.class).setParameter("q","%"+q+"%").getResultList());}
}