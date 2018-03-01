package com.xunuo.util;

import com.xunuo.domain.Student;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        InputStream inputStream  = JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        String url = properties.getProperty("jdbc.url");
        String user = properties.getProperty("jdbc.user");
        String pwd = properties.getProperty("jdbc.password");
        String driveCLass = properties.getProperty("jdbc.driverClass");
        Class.forName(driveCLass);
        Connection connection = DriverManager.getConnection(url,user,pwd);

        return  connection;
    }

    public static void release(ResultSet rs, Statement statement, Connection connection) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void save(Student s1) {

    }
}
