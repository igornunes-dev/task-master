# TaskMaster - Todo List with Categorization
## Description

TaskMaster is a task management system that allows you to create, categorize, and track the progress of your activities. The system is built with Java using Spring Boot and PostgreSQL for the backend, and a simple frontend for user interaction.
Features:

<ul>
  <li>
    Task Creation: Create tasks with titles and descriptions.
  </li>
  <li>
    Categorization: Assign categories such as "University", "Personal", "Work", and more to tasks.
  </li>
  <li>
     Task Status: Track the status of your tasks (in progress, completed, etc.).
  </li>
  <li>
     Task Deletion: Remove tasks that are completed or no longer needed.
  </li>
</ul>
    
## The system is designed to be easily expandable, allowing the addition of more categories or features like deadlines or priorities.
## 1. Prerequisites

    JDK 17+: The project is developed using Java 17.

    Maven: For managing dependencies and building the project.

    PostgreSQL: The database used to persist task and category information.

## 2. Clone the Repository

Clone the repository to your local machine:

git clone https://github.com/your-username/taskmaster.git
cd taskmaster

## 3. Configure the Database

Before running the application, make sure PostgreSQL is installed and configured properly.

    Create a database in PostgreSQL:

CREATE DATABASE tasks;

    Configure the database in the application.properties file:

spring.datasource.url=jdbc:postgresql://localhost:5432/tasks
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

## 4. Running the Project

In the terminal, within the project directory, run:

    mvn spring-boot:run

This will start the server on the default port 8080.
5. Using the Application

The system will be available at:

http://localhost:8080

You can interact with the backend through RESTful endpoints to:

This is a Task Management Application that allows you to manage tasks with different categories. You can perform CRUD operations for both tasks and categories.

## Endpoints

### **Category Endpoints (`/categories`)**

1. **GET /categories**
   - **Description**: Retrieves all categories.
   - **Response**: Returns a list of all categories.

2. **POST /categories**
   - **Description**: Creates a new category.
   - **Request**: Requires a `CategoryDto` object in the request body.
   - **Response**: Returns the created category.

3. **GET /categories/{id}**
   - **Description**: Retrieves a specific category by its ID.
   - **Request**: Requires the `id` of the category as a path parameter.
   - **Response**: Returns the category with the specified ID.

4. **DELETE /categories/{id}**
   - **Description**: Deletes a category by its ID.
   - **Request**: Requires the `id` of the category as a path parameter.
   - **Response**: Returns a success message after the deletion.

5. **GET /categories/fromTask**
   - **Description**: Retrieves all categories that are associated with tasks.
   - **Response**: Returns a set of categories that have associated tasks.

---

### **Task Endpoints (`/tasks`)**

1. **GET /tasks**
   - **Description**: Retrieves all tasks.
   - **Response**: Returns a list of all tasks.

2. **POST /tasks**
   - **Description**: Creates a new task.
   - **Request**: Requires a `TaskDto` object in the request body.
   - **Response**: Returns the created task.

3. **GET /tasks/{id}**
   - **Description**: Retrieves a specific task by its ID.
   - **Request**: Requires the `id` of the task as a path parameter.
   - **Response**: Returns the task with the specified ID.

4. **DELETE /tasks/{id}**
   - **Description**: Deletes a task by its ID.
   - **Request**: Requires the `id` of the task as a path parameter.
   - **Response**: Returns a success message after the deletion.

5. **PUT /tasks/setStatusInProgress/{id}**
   - **Description**: Updates the status of a task to "In Progress".
   - **Request**: Requires the `id` of the task as a path parameter.
   - **Response**: Returns the task with its status updated to "In Progress".

6. **PUT /tasks/setStatusCompleted/{id}**
   - **Description**: Updates the status of a task to "Completed".
   - **Request**: Requires the `id` of the task as a path parameter.
   - **Response**: Returns a success message indicating that the status has been changed to "Completed".

---

## Project Structure

- **controllers**: Contains the controllers responsible for handling HTTP requests.
- **models**: Contains the data models such as `TaskModel` and `CategoryModel`.
- **repositories**: Contains the repositories for database interaction.
- **services**: Contains the business logic, such as task management.
- **application.properties**: Spring Boot configuration file for database and other settings.
