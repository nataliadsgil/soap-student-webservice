/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nataliagil.soap_student_webservice.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

/**
 *
 * @author natalia
 */
@EnableWs
@Configuration
public class SoapWebServiceConfig extends WsConfigurerAdapter{
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/soapWS/*");
    }
    
    @Bean
    public XsdSchema studentSchema() {
        return new SimpleXsdSchema(new ClassPathResource("student.xsd"));
    }
    
    @Bean(name = "students")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema studentSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(studentSchema);
        definition.setLocationUri("/soapWS");
        definition.setPortTypeName("StudentService");
        definition.setTargetNamespace("http://localhost/soap-student-webservice");
        
        return definition;
    }
}
