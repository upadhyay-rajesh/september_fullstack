package com.instagram.dao;
import com.instagram.entity.SavedPost;
import com.instagram.entity.Post;
import java.util.List;
public class SavedPostDAO extends BaseDAO<SavedPost>{
 public SavedPostDAO(){super(SavedPost.class);}
 public boolean exists(Long u,Long p){return tx(s->s.createQuery("select count(x) from SavedPost x where x.user.id=:u and x.post.id=:p",Long.class).setParameter("u",u).setParameter("p",p).uniqueResult()>0);}
 public void remove(Long u,Long p){tx(s->{s.createMutationQuery("delete from SavedPost x where x.user.id=:u and x.post.id=:p").setParameter("u",u).setParameter("p",p).executeUpdate();return null;});}
 public List<Post> byUser(Long u){return tx(s->s.createQuery("select x.post from SavedPost x join fetch x.post.user where x.user.id=:u order by x.id desc",Post.class).setParameter("u",u).getResultList());}
}