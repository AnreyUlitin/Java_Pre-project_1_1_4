package jm.task.core.jdbc.util;
import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.*;
import java.util.Properties;

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


        private static SessionFactory sessionFactory;
        public static SessionFactory getSessionFactory() {
            Properties properties = new Properties();
            try {
                properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                properties.setProperty(Environment.HBM2DDL_AUTO, "update");
                properties.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                properties.setProperty(Environment.USER, "root");
                properties.setProperty(Environment.PASS, "12345678");
                properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/task_1.1.3");
                Configuration configuration = new Configuration();
                configuration.setProperties(properties);
                configuration.addAnnotatedClass(User.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                System.out.println("Соединение Session установленно");
            } catch (HibernateException e) {
                e.printStackTrace();
                System.out.println("Ошибка соединения Session");
            }
            return sessionFactory;
        }

    }


//import jm.task.core.jdbc.model.User;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.cfg.Environment;
//import org.hibernate.service.ServiceRegistry;
//
//import java.util.Properties;
//
//public class HibernateUtil {
//
//        private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
//        private static final String DB_URL = "jdbc:mysql://localhost:3306/promote_db?allowPublicKeyRetrieval=true&useSSL=false";
//        private static final String DB_USERNAME = "root";
//        private static final String DB_PASSWORD = "kv93i02W!";
//        private static final String DB_DIALECT = "org.hibernate.dialect.MySQL5Dialect";
//
//    public static SessionFactory getSessionFactory() {
//            SessionFactory sessionFactory;
//            Configuration configuration = new Configuration();
//
//            // Hibernate settings equivalent to hibernate.cfg.xml's properties
//            Properties settings = new Properties();
//            settings.put(Environment.DRIVER, DB_DRIVER);
//            settings.put(Environment.URL, DB_URL);
//            settings.put(Environment.USER, DB_USERNAME);
//            settings.put(Environment.PASS, DB_PASSWORD);
//            settings.put(Environment.DIALECT, DB_DIALECT);
//            settings.put(Environment.SHOW_SQL,"true");
//            settings.put(Environment.HBM2DDL_AUTO,"update");
//
//
//            configuration.addAnnotatedClass(User.class);
//
//            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                    .applySettings(configuration.getProperties()).build();
//
//            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//
//        return sessionFactory;
//    }
//}




