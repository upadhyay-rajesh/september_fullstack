package com.instagram.dao;
import com.instagram.entity.Hashtag;
import com.instagram.entity.Post;
import java.util.List;
public class HashtagDAO extends BaseDAO<Hashtag>{
 public HashtagDAO(){super(Hashtag.class);}
 public Hashtag findByName(String n){return tx(s->s.createQuery("from Hashtag h where h.name=:n",Hashtag.class).setParameter("n",n).uniqueResult());}
 public List<Post> posts(String n){return tx(s->s.createQuery("select ph.post from PostHashtag ph join fetch ph.post.user where ph.hashtag.name=:n order by ph.post.createdAt desc",Post.class).setParameter("n",n).getResultList());}
}