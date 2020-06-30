package com.jakub.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jakub.entity.Teacher;
import com.jakub.repository.TeacherRepository;

@Controller
@RequestMapping("/teachers")
public class TeacherController
{
    private final TeacherRepository teacherRepository;
    
    @Autowired
    public TeacherController(TeacherRepository teacherRepository)
    {
        this.teacherRepository = teacherRepository;
    }
    
    @GetMapping("/list")
    public String showUpdateForm(Model model)
    {
        model.addAttribute("teachers", teacherRepository.findAll());
        return "list-teacher";
    }

    @GetMapping("/create")
    public String showAddTeacherForm(Teacher teacher)
    {
        return "add-teacher";
    }

    @PostMapping("/add")
    public String addTeacher(@Valid Teacher teacher, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            return "add-teacher";
        }

        teacherRepository.save(teacher);
        return "redirect:list";
    }

    @GetMapping("/edit/{id}")
    public String schowUpdateForm(@PathVariable("id") Integer id, Model model)
    {
        Teacher teacher = teacherRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid Teacher ID: " + id));

        model.addAttribute("teacher", teacher);
        return "update-teacher";
    }

    @PostMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, @Valid Teacher teacher, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            teacher.setId(id);
            return "update-teacher";
        }

        teacherRepository.save(teacher);
        return showUpdateForm(model);
    }

    @GetMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable("id") Integer id, Model model)
    {
        Teacher teacher = teacherRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid Teacher ID: " + id));

        teacherRepository.delete(teacher);
        return showUpdateForm(model);
    }
}
