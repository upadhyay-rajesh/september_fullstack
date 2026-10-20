package com.socialbook.controller;

import com.socialbook.model.*;
import com.socialbook.service.SocialService;
import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SocialController {
	@Autowired
	private SocialService service;

	private Long uid(HttpSession s) {
		Object x = s.getAttribute("uid");
		return x == null ? null : (Long) x;
	}

	private String loginRequired(HttpSession s) {
		return uid(s) == null ? "redirect:/login" : null;
	}

	@GetMapping("/")
	public String root(HttpSession s) {
		return uid(s) == null ? "redirect:/login" : "redirect:/feed";
	}

	@GetMapping("/register")
	public String registerForm() {
		return "register";
	}

	@PostMapping("/register")
	public String register(@RequestParam String fullName, @RequestParam String email, @RequestParam String password,
			RedirectAttributes ra) {
		try {
			User u = new User();
			u.setFullName(fullName);
			u.setEmail(email);
			u.setPassword(password);
			service.register(u);
			ra.addFlashAttribute("success", "Account created. Please log in.");
			return "redirect:/login";
		} catch (Exception e) {
			ra.addFlashAttribute("error", e.getMessage());
			return "redirect:/register";
		}
	}

	@GetMapping("/login")
	public String loginForm() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password, HttpSession s,
			RedirectAttributes ra) {
		User u = service.login(email, password);
		if (u == null) {
			ra.addFlashAttribute("error", "Invalid email or password.");
			return "redirect:/login";
		}
		s.setAttribute("uid", u.getId());
		s.setAttribute("name", u.getFullName());
		return "redirect:/feed";
	}

	@GetMapping("/logout")
	public String logout(HttpSession s) {
		s.invalidate();
		return "redirect:/login";
	}

	@GetMapping("/feed")
	public String feed(HttpSession s, Model m) {
		if (uid(s) == null)
			return "redirect:/login";
		m.addAttribute("posts", service.feed());
		m.addAttribute("me", service.user(uid(s)));
		m.addAttribute("users", service.users());
		return "feed";
	}

	@PostMapping("/posts/create")
	public String createPost(@RequestParam String content, @RequestParam(defaultValue = "") String imageUrl,
			@RequestParam(defaultValue = "PUBLIC") String visibility, HttpSession s, RedirectAttributes ra) {
		if (uid(s) == null)
			return "redirect:/login";
		if (content.trim().isEmpty()) {
			ra.addFlashAttribute("error", "Post content cannot be empty.");
			return "redirect:/feed";
		}
		service.createPost(uid(s), content, imageUrl, visibility);
		return "redirect:/feed";
	}

	@PostMapping("/posts/{id}/delete")
	public String deletePost(@PathVariable Long id, HttpSession s) {
		if (uid(s) != null)
			service.deletePost(id, uid(s));
		return "redirect:/feed";
	}

	@PostMapping("/posts/{id}/like")
	public String like(@PathVariable Long id, HttpSession s) {
		if (uid(s) != null)
			service.like(uid(s), id);
		return "redirect:/feed";
	}

	@PostMapping("/posts/{id}/comment")
	public String comment(@PathVariable Long id, @RequestParam String content, HttpSession s, RedirectAttributes ra) {
		if (uid(s) == null)
			return "redirect:/login";
		if (!content.trim().isEmpty())
			service.comment(uid(s), id, content);
		return "redirect:/feed";
	}

	@GetMapping("/profile")
	public String profile(HttpSession s, Model m) {
		if (uid(s) == null)
			return "redirect:/login";
		m.addAttribute("profile", service.user(uid(s)));
		m.addAttribute("posts", service.userPosts(uid(s)));
		return "profile";
	}

	@PostMapping("/profile/update")
	public String updateProfile(@RequestParam String fullName, @RequestParam(defaultValue = "") String bio,
			@RequestParam(defaultValue = "") String city, @RequestParam(defaultValue = "PUBLIC") String privacy,
			HttpSession s) {
		if (uid(s) != null)
			service.updateProfile(uid(s), fullName, bio, city, privacy);
		return "redirect:/profile";
	}

	@GetMapping("/users/search")
	public String searchUsers(@RequestParam(defaultValue = "") String q, Model m, HttpSession s) {
		if (uid(s) == null)
			return "redirect:/login";
		m.addAttribute("q", q);
		m.addAttribute("users", service.searchUsers(q));
		return "users";
	}

	@PostMapping("/users/{id}/friend")
	public String friend(@PathVariable Long id, HttpSession s) {
		if (uid(s) != null)
			service.requestFriend(uid(s), id);
		return "redirect:/users/search";
	}

	@GetMapping("/friends")
	public String friends(HttpSession s, Model m) {
		if (uid(s) == null)
			return "redirect:/login";
		m.addAttribute("requests", service.friendRequests(uid(s)));
		m.addAttribute("friends", service.friends(uid(s)));
		return "friends";
	}

	@PostMapping("/friends/{id}/respond")
	public String respond(@PathVariable Long id, @RequestParam boolean accept, HttpSession s) {
		if (uid(s) != null)
			service.respondFriend(id, accept, uid(s));
		return "redirect:/friends";
	}

	@GetMapping("/messages")
	public String inbox(HttpSession s, Model m) {
		if (uid(s) == null)
			return "redirect:/login";
		m.addAttribute("messages", service.inbox(uid(s)));
		m.addAttribute("users", service.users());
		return "messages";
	}

	@PostMapping("/messages/send")
	public String sendMessage(@RequestParam Long recipientId, @RequestParam String content, HttpSession s) {
		if (uid(s) != null && !content.trim().isEmpty())
			service.sendMessage(uid(s), recipientId, content);
		return "redirect:/messages";
	}

	@GetMapping("/messages/conversation")
	public String conversation(@RequestParam Long userId, HttpSession s, Model m) {
		if (uid(s) == null)
			return "redirect:/login";
		m.addAttribute("messages", service.conversation(uid(s), userId));
		m.addAttribute("otherUser", service.user(userId));
		m.addAttribute("users", service.users());
		return "messages";
	}

	@GetMapping("/notifications")
	public String notifications(HttpSession s, Model m) {
		if (uid(s) == null)
			return "redirect:/login";
		m.addAttribute("notifications", service.notifications(uid(s)));
		return "notifications";
	}

	@GetMapping("/search/posts")
	public String searchPosts(@RequestParam(defaultValue = "") String q, Model m, HttpSession s) {
		if (uid(s) == null)
			return "redirect:/login";
		m.addAttribute("q", q);
		m.addAttribute("posts", service.searchPosts(q));
		return "postsearch";
	}

	@PostMapping("/posts/{id}/save")
	public String savePost(@PathVariable Long id, HttpSession s) {
		if (uid(s) != null)
			service.savePost(uid(s), id);
		return "redirect:/feed";
	}

	@GetMapping("/saved")
	public String saved(HttpSession s, Model m) {
		if (uid(s) == null)
			return "redirect:/login";
		m.addAttribute("posts", service.savedPosts(uid(s)));
		return "saved";
	}

	@PostMapping("/posts/{id}/report")
	public String report(@PathVariable Long id, @RequestParam String reason, HttpSession s) {
		if (uid(s) != null)
			service.reportPost(uid(s), id, reason);
		return "redirect:/feed";
	}

	@GetMapping("/groups")
	public String groups(HttpSession s, Model m) {
		if (uid(s) == null)
			return "redirect:/login";
		m.addAttribute("groups", service.groups());
		return "groups";
	}

	@PostMapping("/groups/create")
	public String createGroup(@RequestParam String name, @RequestParam String description, HttpSession s) {
		if (uid(s) != null)
			service.createGroup(name, description, uid(s));
		return "redirect:/groups";
	}

	@PostMapping("/groups/{id}/join")
	public String joinGroup(@PathVariable Long id, HttpSession s) {
		if (uid(s) != null)
			service.joinGroup(id, uid(s));
		return "redirect:/groups";
	}

	@GetMapping("/events")
	public String events(HttpSession s, Model m) {
		if (uid(s) == null)
			return "redirect:/login";
		m.addAttribute("events", service.events());
		return "events";
	}

	@PostMapping("/events/create")
	public String createEvent(@RequestParam String title, @RequestParam String description,
			@RequestParam String eventDate, HttpSession s) {
		if (uid(s) != null)
			service.createEvent(title, description, eventDate, uid(s));
		return "redirect:/events";
	}

	@PostMapping("/events/{id}/rsvp")
	public String rsvp(@PathVariable Long id, HttpSession s) {
		if (uid(s) != null)
			service.rsvp(id, uid(s));
		return "redirect:/events";
	}
}
