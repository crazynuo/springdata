package com.xunuo.dao;


import com.xunuo.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class StudentDAOSpringJdbcImplTest {

    private StudentDAO studentDAO = null;

    private ApplicationContext ctx = null;

    @Before
    public void setUp() {
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        studentDAO = (StudentDAO) ctx.getBean("studentDAO");

    }

    @After
    public void tearDown(){
        ctx = null;

    }
    @Test
    public void testQuery(){
        StudentDAO studentDAO = new StudentDaoImpl();
        List<Student> studentList = studentDAO.query();
        for (Student student : studentList) {
            System.out.println(student.getAge() + "===" + student.getId() + "====" + student.getName());
        }
    }
}
