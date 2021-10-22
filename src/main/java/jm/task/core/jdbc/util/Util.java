package jm.task.core.jdbc.util;
import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД //jdbc:mysql://localhost:3306/task_1.1.3//

    private static final String URL = "jdbc:mysql://localhost:3306/task_1.1.3";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345678";

        public static Connection getConnection () {
            Connection connection = null;
            try {
                Driver driver = new com.mysql.cj.jdbc.Driver();
                DriverManager.registerDriver(driver);
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println("Соединение установленно");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Ошибка соединения");
            }
            return connection;
        }
    }



















   // public static Connection main(String[] args) throws ClassNotFoundException, SQLException {

        //Connection connection;
//
//        try {
//            //Driver driver = new FabricMySQLDriver();
//            //DriverManager.registerDriver();
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//
//            if (!connection.isClosed()) {
//                System.out.println("Соединение с БД установлено!");
//            }
//            connection.close();
//
//            if (connection.isClosed()) {
//                System.out.println("Соединение с БД закрыто!");
//            }
//
//        } catch (SQLException e) {
//            System.out.println("Не удалось загрузить класс драйвера");
//        }
//    }


//    private static class FabricMySQLDriver implements Driver {
//        @Override
//        public Connection connect(String url, Properties info) throws SQLException {
//            return null;
//        }
//
//        @Override
//        public boolean acceptsURL(String url) throws SQLException {
//            return false;
//        }
//
//        @Override
//        public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
//            return new DriverPropertyInfo[0];
//        }
//
//        @Override
//        public int getMajorVersion() {
//            return 0;
//        }
//
//        @Override
//        public int getMinorVersion() {
//            return 0;
//        }
//
//        @Override
//        public boolean jdbcCompliant() {
//            return false;
//        }
//
//        @Override
//        public Logger getParentLogger() throws SQLFeatureNotSupportedException {
//            return null;
//        }
//
//    }



