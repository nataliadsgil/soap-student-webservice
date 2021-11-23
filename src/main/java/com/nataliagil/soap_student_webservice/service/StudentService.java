/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nataliagil.soap_student_webservice.service;

import java.util.Collection;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import localhost.soap_student_webservice.Student;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author natalia
 */
@Service
public class StudentService {
    
    private static final Map<String, Student> students = new HashMap<>();
    
    @PostConstruct
    public void initialize() {
                    
        Student natalia = new Student();
        natalia.setNome("Natália");
        natalia.setCurso("Sistemas de Informação");
        natalia.setCidade("Marília");
        natalia.setCPF("130.203.102.11");
        natalia.setRA("123456");
        natalia.setSemestre(8);
        
        Student daniel = new Student();
        daniel.setNome("Daniel");
        daniel.setCurso("Sistemas de Informação");
        daniel.setCidade("Marília");
        daniel.setCPF("542.543.122.20");
        daniel.setRA("987654");
        daniel.setSemestre(8);
        
        Student luiz = new Student();
        luiz.setNome("Luiz");
        luiz.setCurso("Sistemas de Informação");
        luiz.setCidade("Marília");
        luiz.setCPF("874.222.554.18");
        luiz.setRA("456789");
        luiz.setSemestre(8);
        
        Student joao = new Student();
        joao.setNome("João");
        joao.setCurso("Administração");
        joao.setCidade("Marília");
        joao.setCPF("345.234.683.12");
        joao.setRA("44455");
        joao.setSemestre(4);
    
        students.put(natalia.getRA(), natalia);
        students.put(daniel.getRA(), daniel);
        students.put(luiz.getRA(), luiz);
        students.put(joao.getRA(), joao);
        
    }
    
    public Collection<Student> getAllStudents() {
        return students.values();
    }
    
    public Student getStudent(String RA) {
        return students.get(RA);
    }
    
    public String addStudent(Student student) {
        students.put(student.getRA(), student);
        return "Cadastro efetuado com sucesso!";
    }
    
    public String updateStudent(Student student) {
        System.out.println("STUDENT --->" + student.getRA());
        if (students.get(student.getRA()) != null) {
            students.replace(student.getRA(), student);
            
            return "Cadastro atualizado com sucesso!";
        }
        
        return "Não foi possível atualizar o cadastro";
    }
    
    public String removeStudent(String RA) {
        if (students.get(RA) != null) {
            students.remove(RA);
            
            return "Estudante removido com sucesso!";
        }
        
        return "Não foi possível remover o estudante";
    }
}
