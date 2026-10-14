package com.instagram.dao;
import com.instagram.entity.Follower;
import com.instagram.entity.User;
import java.util.List;
public class FollowerDAO extends BaseDAO<Follower>{
 public FollowerDAO(){super(Follower.class);}
 public boolean exists(Long a,Long b){return tx(s->s.createQuery("select count(f) from Follower f where f.follower.id=:a and f.following.id=:b",Long.class).setParameter("a",a).setParameter("b",b).uniqueResult()>0);}
 public void remove(Long a,Long b){tx(s->{s.createMutationQuery("delete from Follower f where f.follower.id=:a and f.following.id=:b").setParameter("a",a).setParameter("b",b).executeUpdate();return null;});}
 public List<User> followers(Long id){return tx(s->s.createQuery("select f.follower from Follower f where f.following.id=:id",User.class).setParameter("id",id).getResultList());}
 public List<User> following(Long id){return tx(s->s.createQuery("select f.following from Follower f where f.follower.id=:id",User.class).setParameter("id",id).getResultList());}
 public long followersCount(Long id){return tx(s->s.createQuery("select count(f) from Follower f where f.following.id=:id",Long.class).setParameter("id",id).uniqueResult());}
 public long followingCount(Long id){return tx(s->s.createQuery("select count(f) from Follower f where f.follower.id=:id",Long.class).setParameter("id",id).uniqueResult());}
}