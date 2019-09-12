package net.csdn.jdbc.dao;

import net.csdn.jdbc.until.ConfigManage;

import java.sql.*;

public class BaseDao {
    private String driver = ConfigManage.getConfigManage().getValue("driver");
    private String url = ConfigManage.getConfigManage().getValue("url");
    private String username = ConfigManage.getConfigManage().getValue("username");
    private String password = ConfigManage.getConfigManage().getValue("password");

    private Connection conn = null;
    private PreparedStatement ppst = null;
    private ResultSet rs = null;

    /**
     * 获取链接
     */
    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 释放资源
     */
    public void CloseAll(ResultSet rs, PreparedStatement ppst, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ppst != null) {
                ppst.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通用查询
     */
    /*public ResultSet executeQuery() {

    }*/
}
