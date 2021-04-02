package com.spring.school.entity;


import javax.persistence.*;
import java.util.List;


@Entity
public class TeachingClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public TeachingClass() {

    }

    public TeachingClass(Course course, Teacher teacher, List<Student> students, int year) {
        this.course = course;
        this.teacher = teacher;
        this.students = students;
        this.year = year;
    }

    // n Courses = 1 Class
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_class_course"))
    private Course course;

    // n Teachers = 1 Class
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_class_teacher"))
    private Teacher teacher;

    // n Students = n Classes
    @ManyToMany
    @JoinTable(
            foreignKey = @ForeignKey(name = "fk_class_student"),
            inverseForeignKey = @ForeignKey(name = "fk_student_class")
    )
    private List<Student> students;

    private int year;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
