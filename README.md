# servlet-jsp-examples 🚀

The `servlet-jsp-examples` showcases a variety of hands-on projects focused on demonstrating the core concepts and operations using Java Servlets. 📘🚀

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
  - Models:  Book `(fields: id, title, author)`, User `(Fields: uid, uname, email)`, Admin `(fields:id, adminName, username,password)`
  - Features:
    1. **Setup:** Create Controller, Service, DAO, Model, DBConnection utility, and `webapp` folder structure.
    2. **Models:** Implement POJOs for `Book`, `User`, and `Admin` with appropriate fields, constructors, getters, and setters.
    3. **Dependencies:** Add required dependencies like `jakarta.servlet`, `mysql-connector-java` in `pom.xml`.
    4. **Controllers:** Implement full CRUD operations for **Books** and **Users**, and add logic for **Admin Register/Login**.
    5. **Routing:** Configure servlet routes and servlet mappings in `web.xml`.
    6. **Views:** Create interactive forms (`add-book.html`, `register-admin.html`, etc.), and display pages using JSP (`view-books.jsp`, etc.).
    7. **Deployment:** Build the `.war` file and deploy on Apache Tomcat server - Done! ✅

**Outcome:** A dynamic **Book Management System** with book, user and admin handling via Servlets! 🎯📖

---

### **Technologies Used** 💻🔧

#### **Backend & Web Technologies**
- **Java Servlets** ☕️: Core for handling HTTP requests and responses.
- **JDBC** 📡: To connect and interact with the MySQL database.
- **MySQL** 🗄️: Stores data for books, users, and admins.
- **JSP** 🧩: Java Server Pages for rendering dynamic content.
- **HTML & JavaScript** 🌐: For structuring frontend forms/pages and rendering pop-up messages.
- **Apache Tomcat v10** 🐱‍💻: Servlet container to deploy and run applications.
- **Maven** 🧰: For dependency management and project building.

---

### **Prerequisites** 🛠️

Before you begin, make sure the following are installed:

- **Java JDK 21 or later**: Download from [Oracle](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) or [OpenJDK](https://jdk.java.net/21/).
- **Apache Tomcat v10**: Download from [Tomcat’s website](https://tomcat.apache.org/download-10.cgi).
- **IntelliJ IDEA for Enterprise Java**: Download from [IntelliJ IDEA Download](https://www.jetbrains.com/idea/download/)
- **MySQL Server**: Install from [MySQL Community](https://dev.mysql.com/downloads/installer/).
- **Maven**: [Install Maven](https://maven.apache.org/install.html) if not bundled with your IDE.

---

## **Installation** 🛠️

### **Clone the Repository**

   ```bash
   git clone https://github.com/thevishalchothe/servlet-jsp-examples.git

   cd servlet-jsp-examples
   ```

---

## **Contributing** 💡

We welcome contributions to the **servlet-jsp-examples**! Here's how you can contribute:

1. Fork the repository and create a new branch for your feature or bug fix.
2. Implement your changes and commit them with clear messages.
3. Submit a pull request for review.

If you have any questions or need help, feel free to contact me at [vishalchothe134@gmail.com](mailto:vishalchothe134@gmail.com).

---

## **Conclusion & License** 📜

Using an open-source license encourages collaboration and contributions from the community, leading to continuous improvement.

See the [LICENSE](https://github.com/thevishalchothe) file for more information.

---

## **Thank You and Best Regards!** 🙏🎉

