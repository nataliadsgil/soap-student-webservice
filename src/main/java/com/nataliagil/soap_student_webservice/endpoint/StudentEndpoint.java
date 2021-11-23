/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nataliagil.soap_student_webservice.endpoint;

import com.nataliagil.soap_student_webservice.service.StudentService;
import java.util.Collection;
import java.util.Map;
import localhost.soap_student_webservice.GetAllStudentsResponse;
import localhost.soap_student_webservice.GetStudentRequest;
import localhost.soap_student_webservice.GetStudentResponse;
import localhost.soap_student_webservice.InsertNewStudentRequest;
import localhost.soap_student_webservice.InsertNewStudentResponse;
import localhost.soap_student_webservice.RemoveStudentRequest;
import localhost.soap_student_webservice.RemoveStudentResponse;
import localhost.soap_student_webservice.Student;
import localhost.soap_student_webservice.UpdateStudentRequest;
import localhost.soap_student_webservice.UpdateStudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 *
 * @author natalia
 */
@Endpoint
public class StudentEndpoint {
    @Autowired
    private StudentService studentService;
    
    @PayloadRoot(namespace = "http://localhost/soap-student-webservice", localPart="getAllStudentsRequest")
    @ResponsePayload
    public GetAllStudentsResponse getAllStudentsRequest() {
        GetAllStudentsResponse response = new GetAllStudentsResponse();
        Collection<Student> students = studentService.getAllStudents();
        response.getStudent().addAll(students);
        
        return response;
    }
    
    @PayloadRoot(namespace = "http://localhost/soap-student-webservice", localPart="getStudentRequest")
    @ResponsePayload
    public GetStudentResponse getStudentRequest(@RequestPayload GetStudentRequest request) {
        GetStudentResponse response = new GetStudentResponse();
        Student student = studentService.getStudent(request.getRA());
        response.setStudent(student);
        
        return response;
    }
    
    @PayloadRoot(namespace = "http://localhost/soap-student-webservice", localPart="insertNewStudentRequest")
    @ResponsePayload
    public InsertNewStudentResponse insertNewStudentRequest(@RequestPayload InsertNewStudentRequest request) {
        InsertNewStudentResponse response = new InsertNewStudentResponse();
        Student student = new Student();
        student.setRA(request.getRA());
        student.setCPF(request.getCPF());
        student.setCidade(request.getCidade());
        student.setCurso(request.getCurso());
        student.setNome(request.getNome());
        student.setSemestre(request.getSemestre());
        response.setMessage(studentService.addStudent(student));
        
        return response;
    }
    
    @PayloadRoot(namespace = "http://localhost/soap-student-webservice", localPart="updateStudentRequest")
    @ResponsePayload
    public UpdateStudentResponse updateStudentRequest(@RequestPayload UpdateStudentRequest request) {
        UpdateStudentResponse response = new UpdateStudentResponse();
        Student student = new Student();
        student.setRA(request.getRA());
        student.setCPF(request.getCPF());
        student.setCidade(request.getCidade());
        student.setCurso(request.getCurso());
        student.setNome(request.getNome());
        student.setSemestre(request.getSemestre());
        response.setMessage(studentService.updateStudent(student));
        
        return response;
    }
    
    @PayloadRoot(namespace = "http://localhost/soap-student-webservice", localPart="removeStudentRequest")
    @ResponsePayload
    public RemoveStudentResponse removeStudentRequest(@RequestPayload RemoveStudentRequest request) {
        RemoveStudentResponse response = new RemoveStudentResponse();
        response.setMessage(studentService.removeStudent(request.getRA()));
        
        return response;
    }
}
