package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.stream.Stream;

public class JdbcUtil {

    private static final Properties jdbcConfig = new Properties();
    private static Connection connection;
    private static PreparedStatement statement;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            InputStream inputStream = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbcConfig.properties");
            if (inputStream != null){
                jdbcConfig.load(inputStream);
                String url = null;
                String usr = null;
                String password = null;
                url = jdbcConfig.getProperty("url");
                usr = jdbcConfig.getProperty("username");
                password = jdbcConfig.getProperty("password");
                if (!url.isEmpty() && !usr.isEmpty() && !password.isEmpty()) {
                    connection = DriverManager.getConnection(url, usr, password);
                }
            }
            System.out.println(connection);
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet select(String sql) throws SQLException {
        statement = connection.prepareStatement(sql);
        return statement.executeQuery();
    }

    public static void close(ResultSet rs) throws SQLException {
        if (rs != null && statement != null && connection != null) {
            connection.close();
            statement.close();
            rs.close();
        }
    }
}
