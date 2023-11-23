package app.models;




public class StudentRegister {

    private int id;
    private String student_id;
    private String name;
    private String date;
    private String gender;
    private String phone;
    private String education;
    private String[] courses;
    private String coursesString; // New field to store courses as a readable string

    private String image_path;


    public StudentRegister(String student_id, String name, String date, String gender, String phone, String education, String coursesString) {
        this.student_id = student_id;
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.phone = phone;
        this.education = education;
        this.coursesString = coursesString;
    }

    public StudentRegister(String student_id, String name, String date, String gender, String phone, String education, String[] courses, String coursesString, String image_path) {
        this.student_id = student_id;
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.phone = phone;
        this.education = education;
        this.courses = courses;
        this.coursesString = coursesString;
        this.image_path = image_path;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public StudentRegister(int id, String student_id, String name, String date, String gender, String phone, String education, String[] courses, String coursesString) {
        this.id = id;
        this.student_id = student_id;
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.phone = phone;
        this.education = education;
        this.courses = courses;
        this.coursesString = coursesString;
    }

    public String getCoursesString() {
        return coursesString;
    }

    public void setCoursesString(String coursesString) {
        this.coursesString = coursesString;
    }

    public StudentRegister(String student_id, String name, String date, String gender, String phone, String education, String[] courses, String coursesString) {
        this.student_id = student_id;
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.phone = phone;
        this.education = education;
        this.courses = courses;
        this.coursesString = coursesString;
    }

    public StudentRegister() {
    }

    public StudentRegister(String studentID, String name, String dob, String gender, String phone, String education, String[] courses) {
        this.student_id = studentID;
        this.name = name;
        this.date = dob;
        this.gender = gender;
        this.phone = phone;
        this.education = education;
        this.courses = courses;
    }


    public StudentRegister(int id, String student_id, String name, String dob, String gender, String phone, String education, String[] attend) {
        this.id = id;
        this.student_id = student_id;
        this.name = name;
        this.date = dob;
        this.gender = gender;
        this.phone = phone;
        this.education = education;
        this.courses = attend;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String dob) {
        this.date = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }



}
