package com.xunuo.dao;

import com.xunuo.domain.Student;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface StudentDAOJPA extends Repository<Student, Integer> {
    public List<Student> findByAge(Integer age);
}
