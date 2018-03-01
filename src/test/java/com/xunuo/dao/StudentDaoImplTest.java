package com.xunuo.dao;

import com.xunuo.domain.Student;
import org.junit.Test;

import java.util.List;

public class StudentDaoImplTest {

    @Test
    public void testQuery(){
        StudentDAO sdao = new StudentDaoImpl();
        List<Student> studentList = sdao.query();
        for (Student stu : studentList){
            System.out.println("student   id="+stu.getId()+", age="+stu.getAge()+ ", name=" + stu.getName());
        }
    }
    @Test
    public void testSave(){
        StudentDAO sdao = new StudentDaoImpl();
        Student s1 = new Student();
        s1.setAge(44);
        s1.setName("xunuo");
        sdao.save(s1);
    }

}
