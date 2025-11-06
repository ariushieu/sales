package com.exam.sales.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtil {
    private static DataSource ds;

    static {
        try {
            Context context = new InitialContext();
            Context envContext = (Context) context.lookup("java:comp/env");
            ds = (DataSource) envContext.lookup("jdbc/db_sales");
        } catch (Exception e) {
            System.err.println("Failed to initialize DataSource. Check your JNDI configuration in context.xml.");
            e.printStackTrace();
        }
    }

public static Connection getConnection() throws SQLException{
        if (ds == null) {
            throw new SQLException("DataSource has not been initialized.");
        }
        return ds.getConnection();
}
}
