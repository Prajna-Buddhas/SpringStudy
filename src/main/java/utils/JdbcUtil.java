package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.stream.Stream;

public class JdbcUtil {

    public static Properties jdbcConfig = new Properties();
    public static Connection connection;
    public static PreparedStatement statement;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            InputStream inputStream = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbcConfig.properties");
            if (inputStream != null){
                jdbcConfig.load(inputStream);
                String url = jdbcConfig.getProperty("url");
                String usr = jdbcConfig.getProperty("username");
                String password = jdbcConfig.getProperty("password");
                connection = DriverManager.getConnection(url, usr, password);
            }
            System.out.println(connection);
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet select() throws SQLException {
        String sql = "select * from test";
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
