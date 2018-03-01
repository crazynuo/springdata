package com.xunuo.util;

import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtilTest {
    @Test
    public void testGetConnection() throws IOException, SQLException, ClassNotFoundException {
        Connection con = JDBCUtil.getConnection();
        Assert.assertNotNull(con);
    }
}
