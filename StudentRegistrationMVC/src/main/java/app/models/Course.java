package app.models;



public class Course {

    private int id ;
    private String course_id;
    private String name ;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Course(int id, String course_id, String name) {
        this.id = id;
        this.course_id = course_id;
        this.name = name;
    }

    public Course(String course_id, String name) {
        this.course_id = course_id;
        this.name = name;
    }

    public Course() {
    }

    public String getCourse_id() {
        return course_id;
    }
    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "Course [id=" + id +"Course Id "+ course_id+ ", course name=" + name  + "]";
    }



}
