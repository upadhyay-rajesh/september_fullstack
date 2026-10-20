package com.socialbook.service;

import com.socialbook.dao.SocialDao;
import com.socialbook.model.*;
import java.util.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SocialService {
	@Autowired
	private SocialDao dao;

	public User register(User u) {
		if (!dao.query("from User u where u.email = ?1", User.class, u.getEmail()).isEmpty())
			throw new IllegalArgumentException("Email is already registered.");
		return dao.save(u);
	}

	public User login(String email, String password) {
		List<User> x = dao.query("from User u where u.email = ?1 and u.password = ?2", User.class, email, password);
		return x.isEmpty() ? null : x.get(0);
	}

	public User user(Long id) {
		return dao.get(User.class, id);
	}

	public List<User> users() {
		return dao.all(User.class);
	}

	public List<User> searchUsers(String q) {
		return dao.query("from User u where lower(u.fullName) like ?1 or lower(u.email) like ?2", User.class,
				"%" + q.toLowerCase() + "%", "%" + q.toLowerCase() + "%");
	}

	public Post createPost(Long uid, String content, String image, String visibility) {
		User u = user(uid);
		if (u == null)
			throw new IllegalArgumentException("Please log in.");
		Post p = new Post();
		p.setAuthor(u);
		p.setContent(content);
		p.setImageUrl(image);
		p.setVisibility(visibility);
		return dao.save(p);
	}

	public List<Post> feed() {
		return dao.all(Post.class);
	}

	public List<Post> userPosts(Long id) {
		return dao.query("from Post p where p.author.id = ?1 order by p.createdAt desc", Post.class, id);
	}

	public Post post(Long id) {
		return dao.get(Post.class, id);
	}

	public void deletePost(Long postId, Long userId) {
		Post p = post(postId);
		if (p != null && p.getAuthor().getId().equals(userId))
			dao.delete(p);
	}

	public Comment comment(Long uid, Long pid, String content) {
		Comment c = new Comment();
		c.setAuthor(user(uid));
		c.setPost(post(pid));
		c.setContent(content);
		return dao.save(c);
	}

	public List<Comment> comments(Long pid) {
		return dao.query("from Comment c where c.post.id = ?1 order by c.createdAt asc", Comment.class, pid);
	}

	public void like(Long uid, Long pid) {
		List<PostLike> found = dao.query("from PostLike l where l.user.id = ?1 and l.post.id = ?2", PostLike.class, uid,
				pid);
		if (found.isEmpty()) {
			PostLike l = new PostLike();
			l.setUser(user(uid));
			l.setPost(post(pid));
			dao.save(l);
		} else
			dao.delete(found.get(0));
	}

	public long likeCount(Long pid) {
		List<?> x = dao.query("select l.id from PostLike l where l.post.id = ?1", Object.class, pid);
		return x.size();
	}

	public void requestFriend(Long from, Long to) {
		if (from.equals(to))
			return;
		List<Friendship> f = dao.query(
				"from Friendship f where (f.requester.id=?1 and f.recipient.id=?2) or (f.requester.id=?3 and f.recipient.id=?4)",
				Friendship.class, from, to, to, from);
		if (f.isEmpty()) {
			Friendship x = new Friendship();
			x.setRequester(user(from));
			x.setRecipient(user(to));
			dao.save(x);
		}
	}

	public List<Friendship> friendRequests(Long uid) {
		return dao.query("from Friendship f where f.recipient.id=?1 and f.status='PENDING'", Friendship.class, uid);
	}

	public List<Friendship> friends(Long uid) {
		return dao.query("from Friendship f where f.status='ACCEPTED' and (f.requester.id=?1 or f.recipient.id=?2)",
				Friendship.class, uid, uid);
	}

	public void respondFriend(Long fid, boolean accept, Long uid) {
		Friendship f = dao.get(Friendship.class, fid);
		if (f != null && f.getRecipient().getId().equals(uid)) {
			if (accept)
				f.setStatus("ACCEPTED");
			else
				dao.delete(f);
		}
	}

	public Message sendMessage(Long from, Long to, String content) {
		Message m = new Message();
		m.setSender(user(from));
		m.setRecipient(user(to));
		m.setContent(content);
		return dao.save(m);
	}

	public List<Message> inbox(Long uid) {
		return dao.query("from Message m where m.recipient.id=?1 order by m.sentAt desc", Message.class, uid);
	}

	public List<Message> conversation(Long a, Long b) {
		return dao.query(
				"from Message m where (m.sender.id=?1 and m.recipient.id=?2) or (m.sender.id=?3 and m.recipient.id=?4) order by m.sentAt",
				Message.class, a, b, b, a);
	}

	public List<Notification> notifications(Long uid) {
		return dao.query("from Notification n where n.recipient.id=?1 order by n.createdAt desc", Notification.class,
				uid);
	}

	public void notify(Long uid, String text) {
		Notification n = new Notification();
		n.setRecipient(user(uid));
		n.setMessage(text);
		dao.save(n);
	}

	public void updateProfile(Long id, String name, String bio, String city, String privacy) {
		User u = user(id);
		if (u != null) {
			u.setFullName(name);
			u.setBio(bio);
			u.setCity(city);
			u.setPrivacy(privacy);
			dao.save(u);
		}
	}

	public List<Post> searchPosts(String q) {
		return dao.query("from Post p where lower(p.content) like ?1 order by p.createdAt desc", Post.class,
				"%" + q.toLowerCase() + "%");
	}

	public List<Friendship> allFriendships(Long uid) {
		return friends(uid);
	}

	public List<Post> savedPosts(Long uid) {
		return dao.query("select s.post from SavedPost s where s.user.id=?1", Post.class, uid);
	}

	public void savePost(Long uid, Long pid) {
		List<SavedPost> x = dao.query("from SavedPost s where s.user.id=?1 and s.post.id=?2", SavedPost.class, uid,
				pid);
		if (x.isEmpty()) {
			SavedPost s = new SavedPost();
			s.setUser(user(uid));
			s.setPost(post(pid));
			dao.save(s);
		}
	}

	public void reportPost(Long uid, Long pid, String reason) {
		Report r = new Report();
		r.setReporter(user(uid));
		r.setPost(post(pid));
		r.setReason(reason);
		dao.save(r);
	}

	public List<SocialGroup> groups() {
		return dao.all(SocialGroup.class);
	}

	public SocialGroup createGroup(String name, String description, Long uid) {
		SocialGroup g = new SocialGroup();
		g.setName(name);
		g.setDescription(description);
		g.setCreator(user(uid));
		dao.save(g);
		joinGroup(g.getId(), uid);
		return g;
	}

	public void joinGroup(Long gid, Long uid) {
		SocialGroup g = dao.get(SocialGroup.class, gid);
		User u = user(uid);
		if (g != null && u != null) {
			List<GroupMember> x = dao.query("from GroupMember m where m.group.id=?1 and m.user.id=?2",
					GroupMember.class, gid, uid);
			if (x.isEmpty()) {
				GroupMember m = new GroupMember();
				m.setGroup(g);
				m.setUser(u);
				dao.save(m);
			}
		}
	}

	public List<GroupMember> groupMembers(Long gid) {
		return dao.query("from GroupMember m where m.group.id=?1", GroupMember.class, gid);
	}

	public List<Event> events() {
		return dao.all(Event.class);
	}

	public Event createEvent(String title, String description, String date, Long uid) {
		Event e = new Event();
		e.setTitle(title);
		e.setDescription(description);
		e.setEventDate(date);
		e.setCreator(user(uid));
		dao.save(e);
		return e;
	}

	public void rsvp(Long eid, Long uid) {
		Event e = dao.get(Event.class, eid);
		User u = user(uid);
		if (e != null && u != null) {
			EventRsvp r = new EventRsvp();
			r.setEvent(e);
			r.setUser(u);
			dao.save(r);
		}
	}
}
