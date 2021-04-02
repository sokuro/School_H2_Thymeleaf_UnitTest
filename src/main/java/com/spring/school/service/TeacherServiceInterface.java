package com.spring.school.service;

import com.spring.school.entity.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherServiceInterface {
    
    void persist(Teacher teacher);
    
    void delete(Teacher teacher);
    
    Optional<Teacher> findById(Long id);
    
    List<Teacher> findAll();
    
    void deleteAll();
}
