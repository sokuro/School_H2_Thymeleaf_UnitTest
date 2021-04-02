package com.spring.school.dao;


import com.spring.school.entity.TeachingClass;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TeachingClassDao extends JpaRepository<TeachingClass, Long> {
}
