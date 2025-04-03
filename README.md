# servlets-tutorial-series 🚀

*servlets-tutorial-series showcases a variety of projects focused on demonstrating core concepts and operations using Java Servlets.* 📘🚀

## Project Architecture 📂

- **hello-servlet**
  - This `hello-servlet` is a simple request handling implementation focusing on the default request and explicit request mapping to '/hello'.
  - Basic web deployment and servlet mapping in `web.xml`.

- **hello-servlet-greeting-web**
  - A simple Servlet-based web application that responds with a `greeting message` dynamically.
  - Demonstrates basic `GET request handling` with `HttpServlet`.

- **servlet-lifecycle-web**
  - Showcases the `lifecycle of a Servlet` (`init()`, `service()`, `destroy()`).
  - For understanding how Servlets are managed by the Servlet container.

- **book-management-servlet-app**
  - Tech Stack: Servlet, JSP, HTML, JDBC, MySQL, Maven, Tomcat
  - Models: Book `(fields: id, title, author)`, User `(Fields: uid, uname, email)`
  - Steps:
    1. **Setup:** Controller, Service, Dao, Model, DBConnection, Webapp
    2. **Models:** Implement the `Book` & `User` classes with required fields, getters & setters
    3. **Dependencies:** Add `jakarta-servlet`, `mysql` in `pom.xml`
    4. **Controllers:** Implement CRUD service logic 
    5. **Mappings:** Configure routes in `web.xml`
    6. **Views:** Create forms like (add-book.html), display pages (view-books.jsp), and other related UI components.
    7. **Deploy:** Build `.war`, deploy on Tomcat - Done! ✅

**Outcome:** A dynamic **Book Management System** with book & user handling via Servlets! 🎯📖
