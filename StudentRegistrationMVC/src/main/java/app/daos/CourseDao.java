package app.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.helpers.DBHelper;
import app.models.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseDao {


    //creating course
    public int createCourse(Course course) {
        int status = 0;
        Connection connection = DBHelper.getInstance().getConnection();
        String query = "INSERT INTO courses (id,course_id,course_name) VALUES (?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, course.getId());
            stmt.setString(2, course.getCourse_id());
            stmt.setString(3, course.getName());
            status = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }


    //list of course - usually use in display
    public List<Course> getAllCourse() {
        ResultSet resultSet;
        List<Course> courses = new ArrayList<>();
        Connection connection = DBHelper.getInstance().getConnection();
        String query = "SELECT * FROM courses";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Course course = new Course();
                course.setId(resultSet.getInt("id"));
                course.setCourse_id(resultSet.getString("course_id"));
                course.setName(resultSet.getString("course_name"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    public Course getCourseById(int courseId){
        ResultSet resultSet;
        Course course= new Course();
        Connection connection = DBHelper.getInstance().getConnection();
        String query= "SELECT * FROM courses WHERE id=?";
        try{
            PreparedStatement stmp= connection.prepareStatement(query);
            stmp.setInt(1,courseId);
            resultSet = stmp.executeQuery();
            while (resultSet.next()){
                course.setId(resultSet.getInt("id"));
                course.setCourse_id(resultSet.getString("course_id"));
                course.setName(resultSet.getString("course_name"));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Course GET ID BY DAO  : "+ course.getId());
        return course;
    }

    public int updateCourse(Course course) {
        int status = 0;
        System.out.println("Id  :  "+ course.getId());
        System.out.println("Course Id : "+ course.getCourse_id());
        System.out.println("Course Name : "+course.getName());
        Connection connection = DBHelper.getInstance().getConnection();
        String query = "UPDATE courses SET course_id=?, course_name=? WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, course.getCourse_id());
            stmt.setString(2, course.getName());
            stmt.setInt(3, course.getId());
            status = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
    public int deleteCourse(int courseId) {
        int status = 0;
        Connection connection = DBHelper.getInstance().getConnection();
        String query = "DELETE FROM courses WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, courseId);
            status = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
    public List<String> getCourses() {
        List<String> courses = new ArrayList<>();
        Connection connection = DBHelper.getInstance().getConnection();
        String query = "SELECT course_name FROM courses";  // Adjust table and column names accordingly
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                String course = resultSet.getString("course_name");
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }
    public String getLatestCourseId() {
        String latestCourseId = "COU1"; // Default value if no courses exist yet
        Connection connection = DBHelper.getInstance().getConnection();
        String query = "SELECT MAX(CAST(SUBSTRING(course_id, 4) AS UNSIGNED)) AS maxCourseNumber FROM courses";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                int maxCourseNumber = resultSet.getInt("maxCourseNumber");
                latestCourseId = "COU" + (maxCourseNumber + 1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return latestCourseId;
    }

}




