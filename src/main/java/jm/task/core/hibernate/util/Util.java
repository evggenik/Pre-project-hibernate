package jm.task.core.hibernate.util;

import jm.task.core.hibernate.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Util {
    // реализуйте настройку соеденения с БД
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                // settings here instead of hibernate.cfg.xml
//                Properties settings = new Properties();
//                settings.load(Util.class.getClassLoader().getResourceAsStream("hibernate.properties"));
//                settings.put(Environment.DRIVER, "com.mysql.cj.hibernate.Driver");
//                settings.put(Environment.URL, "hibernate:mysql://localhost:3306/hibernate_db");
//                settings.put(Environment.USER, "hibernate_user");
//                settings.put(Environment.PASS, "password");
//                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
//                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
//                settings.put(Environment.SHOW_SQL, "true");
//                configuration.setProperties(settings);

                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
