package raExample.util.Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

// thuc hanh tao 1 database va thuc hien truy van trong 1 file
public class UniversityDatabase {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";  // Thay bằng tên người dùng MySQL của bạn
        String password = "123456";  // Thay bằng mật khẩu của bạn

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            // Tạo cơ sở dữ liệu và sử dụng nó
            String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS UniversityDB1;";
            String useDatabaseQuery = "USE UniversityDB1;";
            stmt.executeUpdate(createDatabaseQuery);
            stmt.executeUpdate(useDatabaseQuery);
            System.out.println("Đã tạo và chọn cơ sở dữ liệu UniversityDB.");

            // Tạo bảng Departments
            String createDepartmentsTable = """
                CREATE TABLE IF NOT EXISTS Departments (
                    department_id INT AUTO_INCREMENT PRIMARY KEY,
                    department_name VARCHAR(100) NOT NULL
                );
                """;
            stmt.executeUpdate(createDepartmentsTable); // thuc thi cau lenh

            // Tạo bảng Courses
            String createCoursesTable = """
                CREATE TABLE IF NOT EXISTS Courses (
                    course_id INT AUTO_INCREMENT PRIMARY KEY,
                    course_name VARCHAR(100) NOT NULL,
                    department_id INT,
                    FOREIGN KEY (department_id) REFERENCES Departments(department_id)
                );
                """;
            stmt.executeUpdate(createCoursesTable);

            // Tạo bảng Students
            String createStudentsTable = """
                CREATE TABLE IF NOT EXISTS Students (
                    student_id INT AUTO_INCREMENT PRIMARY KEY,
                    student_name VARCHAR(100) NOT NULL,
                    birthdate DATE NOT NULL,
                    department_id INT,
                    FOREIGN KEY (department_id) REFERENCES Departments(department_id)
                );
                """;
            stmt.executeUpdate(createStudentsTable);

            // Tạo bảng Enrollments
            String createEnrollmentsTable = """
                CREATE TABLE IF NOT EXISTS Enrollments (
                    enrollment_id INT AUTO_INCREMENT PRIMARY KEY,
                    student_id INT,
                    course_id INT,
                    enrollment_date DATE,
                    grade DECIMAL(3, 2),
                    FOREIGN KEY (student_id) REFERENCES Students(student_id),
                    FOREIGN KEY (course_id) REFERENCES Courses(course_id)
                );
                """;
            stmt.executeUpdate(createEnrollmentsTable);

            System.out.println("Đã tạo các bảng.");

            // Thêm dữ liệu vào bảng Departments
            String insertDepartments = """
                INSERT INTO Departments (department_name) VALUES 
                ('Computer Science'), 
                ('Electrical Engineering'), 
                ('Mechanical Engineering');
                """;
            stmt.executeUpdate(insertDepartments);

            // Thêm dữ liệu vào bảng Courses
            String insertCourses = """
                INSERT INTO Courses (course_name, department_id) VALUES 
                ('Data Structures', 1),
                ('Algorithms', 1),
                ('Circuit Design', 2),
                ('Thermodynamics', 3);
                """;
            stmt.executeUpdate(insertCourses);

            // Thêm dữ liệu vào bảng Students
            String insertStudents = """
                INSERT INTO Students (student_name, birthdate, department_id) VALUES 
                ('John Doe', '2000-05-15', 1),
                ('Jane Smith', '1999-08-22', 2),
                ('Mike Johnson', '2001-03-10', 3);
                """;
            stmt.executeUpdate(insertStudents);

            // Thêm dữ liệu vào bảng Enrollments
            String insertEnrollments = """
                INSERT INTO Enrollments (student_id, course_id, enrollment_date, grade) VALUES 
                (1, 1, '2024-09-15', 3.5),
                (1, 2, '2024-09-15', 3.8),
                (2, 3, '2024-09-16', 4.0),
                (3, 4, '2024-09-17', 3.2);
                """;
            stmt.executeUpdate(insertEnrollments);

            System.out.println("Đã thêm dữ liệu vào các bảng.");

            // Truy vấn bảng Students
            String queryStudents = "SELECT * FROM Students;";
            ResultSet resultSet = stmt.executeQuery(queryStudents);

            System.out.println("ResultSet: "+resultSet);

            System.out.println("Danh sách sinh viên:");
            while (resultSet.next()) {
                int studentId = resultSet.getInt("student_id");
                String studentName = resultSet.getString("student_name");
                String birthdate = resultSet.getString("birthdate");
                int departmentId = resultSet.getInt("department_id");

                System.out.printf("ID: %d, Tên: %s, Ngày sinh: %s, Khoa ID: %d%n",
                        studentId, studentName, birthdate, departmentId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
