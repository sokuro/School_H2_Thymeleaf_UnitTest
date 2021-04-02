package com.spring.school.init;

import com.spring.school.dao.CourseDao;
import com.spring.school.dao.StudentDao;
import com.spring.school.dao.TeacherDao;
import com.spring.school.dao.TeachingClassDao;
import com.spring.school.entity.Course;
import com.spring.school.entity.Student;
import com.spring.school.entity.Teacher;
import com.spring.school.entity.TeachingClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataInit implements ApplicationRunner {
    
    private StudentDao studentDao;
    private TeacherDao teacherDao;
    private CourseDao courseDao;
    private TeachingClassDao teachingClassDao;
    
    @Autowired
    public DataInit(StudentDao studentDao, TeacherDao teacherDao, CourseDao courseDao,
                    TeachingClassDao teachingClassDao) {
        this.studentDao = studentDao;
        this.teacherDao = teacherDao;
        this.courseDao = courseDao;
        this.teachingClassDao = teachingClassDao;
    }
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        long count = studentDao.count();
        
        if (count == 0) {
            // Students
            Student student1 = new Student("Gonzales", 22);
            Student student2 = new Student("Smith", 33);
            Student student3 = new Student("Manzales", 39);
            List<Student> studentList = new ArrayList<>();
            studentList.add(student1);
            studentList.add(student2);
            studentList.add(student3);
            studentDao.saveAll(studentList);
            
            // Teachers
            Teacher teacher1 = new Teacher("Garaj", "bla@bla.com", "garaj@example.com");
            Teacher teacher2 = new Teacher("Znoj", "bla2@bla.com", "znoj@example.com");
            Teacher teacher3 = new Teacher("Marte", "bla3@bla.com", "marte@example.com");
            List<Teacher> teacherList = new ArrayList<>();
            teacherList.add(teacher1);
            teacherList.add(teacher2);
            teacherList.add(teacher3);
            teacherDao.saveAll(teacherList);
            
            // Courses
            Course course1 = new Course("Mathematics", 10, 10, teacher1);
            Course course2 = new Course("Informatics", 5, 8, teacher2);
            Course course3 = new Course("History", 4, 6, teacher3);
            List<Course> courseList = new ArrayList<>();
            courseList.add(course1);
            courseList.add(course2);
            courseList.add(course3);
            courseDao.saveAll(courseList);
            
            // Teaching Classes
            TeachingClass teachingClass1 = new TeachingClass(course1, teacher1, studentList, 2020);
            List<TeachingClass> teachingClassList = new ArrayList<>();
            teachingClassList.add(teachingClass1);
            teachingClassDao.saveAll(teachingClassList);
        }
    }
    
}
