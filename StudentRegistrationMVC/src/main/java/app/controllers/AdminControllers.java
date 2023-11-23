package app.controllers;

import app.daos.CourseDao;
import app.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminControllers {

    @Autowired
    private CourseDao courseDao;

    @GetMapping("/courseRegistrate")
    public String getCourseRegistration(Model model) {

        // Retrieve the latest course ID from the database
        String latestCourseId = courseDao.getLatestCourseId();

        // Add the next course ID to the model
        model.addAttribute("courseId", latestCourseId);

        return "courseRegister";
    }


    @PostMapping("/courseRegistrate")
    public String postCourseRegistration(@RequestParam String courseId, String courseName ){

        System.out.println("Course Id  : "+ courseId);
        System.out.println("Course Name  : "+ courseName);

        Course course= new Course(courseId,courseName);
        courseDao.createCourse(course);


        return "courseDisplay";

    }
}
