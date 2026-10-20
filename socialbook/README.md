# SocialBook — Facebook-style Spring MVC + Hibernate Training Project

A classroom-oriented, server-rendered social networking MVP using Java 17, Spring MVC 5.3, Hibernate 5.6, JSP/JSTL, Bootstrap 5 and MySQL 8. There is **no JavaScript written by the project**: interactions use normal HTML forms and full-page requests. Bootstrap CSS is loaded from its CDN.

## Included functionality (30+ training features)
1. Registration; 2. login; 3. logout; 4. profile display; 5. edit name/bio/city; 6. profile visibility preference; 7. create text posts; 8. attach an image URL; 9. choose post visibility; 10. feed; 11. delete own posts; 12. like/unlike posts; 13. comment on posts; 14. save posts; 15. saved-posts page; 16. report posts; 17. search people; 18. send friend requests; 19. accept requests; 20. decline requests; 21. friend list; 22. inbox; 23. send messages; 24. view conversation; 25. notifications page; 26. search post text; 27. create groups; 28. join groups; 29. create events; 30. RSVP to events; 31. responsive Bootstrap layout; 32. DAO/service/controller separation; 33. Hibernate entity relationships; 34. declarative transaction management.

## Requirements
- JDK 17
- Maven 3.9+
- MySQL 8+
- Apache Tomcat 9.0.x (javax.servlet based)
- Internet access for Bootstrap CDN (or download Bootstrap CSS into `src/main/webapp/assets` and update JSP links)

## Database setup
The JDBC URL creates the schema if it does not exist. You can also run:
```sql
CREATE DATABASE socialbook;
```
Edit `src/main/java/com/socialbook/config/AppConfig.java` and set your local MySQL username/password. The starter defaults are `root` / `root`; **change these for your machine**.

## Build and deploy
1. Open a terminal in the folder containing `pom.xml`.
2. Run `mvn clean package`.
3. Copy `target/socialbook.war` to Tomcat 9 `webapps/`.
4. Start Tomcat.
5. Open `http://localhost:8080/socialbook/`.
6. Register a new account and log in.

## Architecture
Browser (JSP + Bootstrap CSS + HTML forms) → `SocialController` → `SocialService` (`@Transactional`) → `SocialDao` → Hibernate `SessionFactory` → MySQL.

## Source layout
- `model/`: Hibernate entities (`User`, `Post`, `Comment`, `PostLike`, `Friendship`, `Message`, `Notification`, `SavedPost`, `Report`, `SocialGroup`, `GroupMember`, `Event`, `EventRsvp`)
- `dao/SocialDao.java`: persistence operations
- `service/SocialService.java`: business logic
- `controller/SocialController.java`: routes and request/session handling
- `config/`: Spring MVC, Hibernate and transaction configuration
- `src/main/webapp/WEB-INF/views/`: JSP views
- `src/main/webapp/assets/style.css`: custom styling

## Important teaching/security notes
This is a **training MVP**, not a production-ready public social network. For a production system, add BCrypt password hashing, CSRF protection, server-side authorization checks on every object, stronger validation, rate limiting, upload storage, privacy enforcement, message authorization, pagination, tests, and audit logging. Passwords are stored as plain text here to keep the initial teaching flow easy to inspect; do not use real credentials. The visibility field is stored but not yet enforced in feed queries. A number of social actions are intentionally simple examples to extend during labs.
