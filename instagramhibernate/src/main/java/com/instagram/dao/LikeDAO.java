package com.instagram.dao;
import com.instagram.entity.PostLike;
public class LikeDAO extends BaseDAO<PostLike>{
 public LikeDAO(){super(PostLike.class);}
 public boolean exists(Long postId,Long userId){return tx(s->s.createQuery("select count(l) from PostLike l where l.post.id=:p and l.user.id=:u",Long.class).setParameter("p",postId).setParameter("u",userId).uniqueResult()>0);}
 public long count(Long postId){return tx(s->s.createQuery("select count(l) from PostLike l where l.post.id=:p",Long.class).setParameter("p",postId).uniqueResult());}
 public void remove(Long postId,Long userId){tx(s->{s.createMutationQuery("delete from PostLike l where l.post.id=:p and l.user.id=:u").setParameter("p",postId).setParameter("u",userId).executeUpdate();return null;});}
}