package com.spring.school.controller;

import com.spring.school.entity.Teacher;
import com.spring.school.form.TeacherForm;
import com.spring.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TeacherController {
    
    @Autowired
    private TeacherService teacherService;
    
    @Value("${error.message}")
    private String errorMessage;
    
    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public String getTeachers(Model model) {
        List<Teacher> teachers = teacherService.findAll();
        
        model.addAttribute("teachers", teachers);
        
        return "teachers";
    }
    
    @RequestMapping(value = "/addTeacher", method = RequestMethod.GET)
    public String addTeacherHandleGet(Model model) {

        TeacherForm teacherForm = new TeacherForm();
        
        model.addAttribute("teacherForm", teacherForm);
        
        return "addTeacher";
    }
    
    @RequestMapping(value = "/addTeacher", method = RequestMethod.POST)
    public String addTeacherHandlePost(Model model, @ModelAttribute("teacherForm") TeacherForm teacherForm) {
        
//        Long id = teacherForm.getId();
        String name = teacherForm.getName();
        String pictureURL = teacherForm.getPictureURL();
        String email = teacherForm.getEmail();
        
        if (name != null && name.length() > 0
                && pictureURL != null && pictureURL.length() > 0
                && email != null && email.length() > 0) {
            Teacher teacher = new Teacher();
            teacher.setName(name);
            teacher.setPictureURL(pictureURL);
            teacher.setEmail(email);
            teacherService.persist(teacher);
            
            return "redirect:/teachers";
        }
        
        model.addAttribute("errorMessage", errorMessage);
        return "addTeacher";
    }
}
