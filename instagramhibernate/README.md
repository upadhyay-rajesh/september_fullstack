# Instagram Hibernate Clone

A training/demo Instagram-style web application based on the supplied project document.

## Technology stack

- Java 17+
- Maven 3.9+
- Hibernate ORM 6.6
- Jakarta Servlet 6.1
- Tomcat 10.1+
- MySQL 8+
- Bootstrap 5, HTML5, CSS3, JavaScript and Fetch/AJAX

## Features included

- Register, login and logout
- User profile and user search
- Create and view posts / feed
- Like and unlike posts
- Add and view comments
- Follow and unfollow users
- Stories and story views
- Hashtags
- Save and unsave posts
- Conversations and messages
- Notifications
- DAO, service, servlet/controller and entity layers

## 1. Install prerequisites

Install a JDK (17 or later), Maven, MySQL Server 8+, and Apache Tomcat 10.1 or later.
Make sure `java -version` and `mvn -version` work in a new terminal.

## 2. Configure MySQL

Open `src/main/resources/hibernate.cfg.xml` and set these properties to match your local MySQL setup:

```xml
<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/instagram_db?createDatabaseIfNotExist=true&amp;serverTimezone=UTC</property>
<property name="hibernate.connection.username">root</property>
<property name="hibernate.connection.password">YOUR_MYSQL_PASSWORD</property>
```

The JDBC URL asks MySQL to create `instagram_db` if the configured user has permission. Alternatively, run `database.sql` in MySQL first. Hibernate's `hbm2ddl.auto=update` creates/updates mapped tables at startup.

## 3. Build the WAR

From the project root (the folder containing `pom.xml`):

```bash
mvn clean package
```

The generated artifact should be `target/instagram-hibernate.war`.

## 4. Deploy to Tomcat

Copy `target/instagram-hibernate.war` to Tomcat's `webapps` directory and start/restart Tomcat.

Windows example (adjust the Tomcat path to your installation):

```bat
copy target\instagram-hibernate.war C:\apache-tomcat-10.1\webapps\
C:\apache-tomcat-10.1\bin\startup.bat
```

Linux/macOS example:

```bash
cp target/instagram-hibernate.war "$CATALINA_HOME/webapps/"
"$CATALINA_HOME/bin/startup.sh"
```

Open:

- `http://localhost:8080/instagram-hibernate/`
- `http://localhost:8080/instagram-hibernate/login.html`
- `http://localhost:8080/instagram-hibernate/register.html`
- `http://localhost:8080/instagram-hibernate/home.html`
- `http://localhost:8080/instagram-hibernate/profile.html`
- `http://localhost:8080/instagram-hibernate/search.html`
- `http://localhost:8080/instagram-hibernate/stories.html`
- `http://localhost:8080/instagram-hibernate/saved.html`
- `http://localhost:8080/instagram-hibernate/messages.html`
- `http://localhost:8080/instagram-hibernate/notifications.html`

## Troubleshooting

- **Database connection refused:** verify MySQL is running and the JDBC URL/port is correct.
- **Access denied:** correct the MySQL username/password and confirm that user has database permissions.
- **404 after deployment:** verify Tomcat started and the WAR deployed without errors; check the Tomcat logs.
- **Maven dependency/build failure:** check internet access and run `mvn -U clean package`.
- **Hibernate schema error:** check the MySQL user has permission to create/alter tables.

## Important security note

This is a learning/demo project, not production-ready. The sample uses simple password handling to keep the training flow approachable. Before production use, implement password hashing, stronger authorization and session controls, input validation, CSRF protection, secure media uploads, rate limiting, and centralized error handling. Review the code before exposing it to a network.
