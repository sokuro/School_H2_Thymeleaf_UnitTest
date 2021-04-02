package com.spring.school.service;

import com.spring.school.dao.TeacherDao;
import com.spring.school.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService implements TeacherServiceInterface {
    
    @Autowired
    private TeacherDao teacherDao;
    
    @Override
    public void persist(Teacher teacher) {
        teacherDao.save(teacher);
    }
    
    @Override
    public void delete(Teacher teacher) {
        teacherDao.delete(teacher);
    }
    
    @Override
    public Optional<Teacher> findById(Long id) {
        return teacherDao.findById(id);
    }
    
    @Override
    public List<Teacher> findAll() {
        return teacherDao.findAll();
    }
    
    @Override
    public void deleteAll() {
        teacherDao.deleteAll();
    }
}
