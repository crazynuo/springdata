package com.xunuo.dao;

import com.xunuo.domain.Student;
import com.xunuo.util.JDBCUtil;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * jdbc模板方式操作数据库
 */
public class StudentDAOSpringJdbcImpl implements StudentDAO {
    private JdbcTemplate jdbcTemplate;

    public List<Student> query() {

        List<Student> list = new ArrayList<Student>();
        try {

            String sql = "select id, name, age  from student ";
            List<Map<String, Object>> result = (List<Map<String, Object>>)jdbcTemplate.queryForList(sql);

            for (Map<String, Object> stuMap : result) {
                int id = Integer.parseInt(stuMap.get("id").toString());
                String name = stuMap.get("name").toString();
                int age = Integer.parseInt(stuMap.get("age").toString());
                Student s = new Student();
                s.setId(id);
                s.setAge(age);
                s.setName(name);
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return list;
    }

    public void save(Student student) {

    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
