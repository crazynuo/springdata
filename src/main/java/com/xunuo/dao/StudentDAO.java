package com.xunuo.dao;

import com.xunuo.domain.Student;

import java.util.List;

public interface StudentDAO {
    public List<Student> query();

    public void save(Student student);
}
