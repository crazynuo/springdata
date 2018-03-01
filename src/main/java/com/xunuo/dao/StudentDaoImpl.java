package com.xunuo.dao;

import com.xunuo.domain.Student;
import com.xunuo.util.JDBCUtil;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 传统方式访问数据库
 */
public class StudentDaoImpl implements StudentDAO {

    public List<Student> query() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Student> list = new ArrayList<Student>();
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select id, name, age  from student ";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                Student s = new Student();
                s.setId(id);
                s.setAge(age);
                s.setName(name);
                list.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(resultSet,statement,connection);
        }
        return list;
    }

    public void save(Student student) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "INSERT into student (name, age) values (?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setInt(2, student.getAge());
            statement.executeUpdate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(resultSet,statement,connection);
        }
    }
}
