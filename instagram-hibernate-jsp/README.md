# Instagram Hibernate JSP MVC (Tomcat 9)

This is a server-rendered version of the Instagram-style training project. It intentionally does **not** use JavaScript, AJAX, JSON APIs, arrow/lambda expressions, or client-side fetch calls. HTML forms submit to servlets; servlets call service interfaces; services call DAO interfaces; DAO implementations use `SessionFactory`, `Session`, Hibernate `Query`, and transactions; controllers forward results through `request` attributes to JSP pages.

## Compatibility
- Java 8 or later (project source/target is Java 8)
- Apache Tomcat 9.x
- Maven 3.8+
- MySQL 8.x
- Hibernate ORM 5.6.15.Final (`javax.persistence`, compatible with Tomcat 9's `javax.servlet`)

## Setup
1. Install JDK, Maven, MySQL 8, and Tomcat 9.
2. Create the database using `database/README.sql` or allow the JDBC URL to create it.
3. Edit `src/main/resources/hibernate.cfg.xml` and replace `CHANGE_ME` with your MySQL password.
4. From the project root, run `mvn clean package`.
5. Copy `target/instagram-hibernate.war` into Tomcat 9's `webapps` directory.
6. Start Tomcat and open `http://localhost:8080/instagram-hibernate/`.
7. Register, log in, create posts, browse the feed, and search users/posts.

## Architecture
`Servlet controller -> Service interface -> Service implementation -> DAO interface -> DAO implementation -> SessionFactory / Session / Query -> MySQL`

## Key URLs
- `/register` — registration form and submission
- `/login` — login form and submission
- `/home` — server-rendered feed
- `/posts/create` — create post
- `/search?q=keyword` — search users and posts
- `/logout` — invalidate the session

## HQL training catalog
`com.instagramhibernate.dao.HqlQueryCatalogDAO` includes examples for user lookup/search/update/delete, post listing/feed/search/pagination, comments, likes/unlikes/counts, followers/following, active stories/story viewers, hashtags, saved posts, messages, notifications, aggregation with GROUP BY/HAVING, JOIN FETCH, and native SQL. The attached source document mentions additional topics such as DTO projections, named queries, second-level cache, optimistic locking, and entity graphs; those advanced examples are not all wired into the basic JSP workflow.

## Important security note
This is a classroom demonstration. The login sample compares passwords directly to keep the example focused on Hibernate and MVC. Do not deploy it publicly without password hashing, CSRF protection, output escaping, authorization checks, validation, and secret management. In production, use a password-hashing algorithm such as BCrypt.
