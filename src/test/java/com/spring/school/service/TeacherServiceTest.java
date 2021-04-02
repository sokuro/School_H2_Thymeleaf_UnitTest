package com.spring.school.service;

import com.spring.school.entity.Teacher;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherServiceTest {

    @Autowired
    TeacherService teacherService;

    @Test
    @DisplayName("Should Persist a created Teacher Object")
    public void persist() {
        Teacher teacher1 = new Teacher("Ugorcak", "bla@bla1.com", "ugorcak@example.com");
        teacherService.persist(teacher1);
    }

    @Test
    @DisplayName("Find all persisted Teacher Objects")
    public void findAllTeachers() {
        List<Teacher> teachers = teacherService.findAll();
        assertFalse(teachers.isEmpty());
    }
}