package com.spring.school.dao;


import com.spring.school.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherDao extends JpaRepository<Teacher, Long> {

    List<Teacher> findByNameContaining(String name);
}
