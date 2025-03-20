package org.example.bluemoon.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateUtil {
    //Logger dùng để ghi log
    private static final Logger logger = LoggerFactory.getLogger(HibernateUtil.class);
    //SessionFactory là một class quan trọng trong Hibernate, nó chứa các thông tin cấu hình của Hibernate
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try{
            //tạo đối tượng Configuration để đọc file hibernate.cfg.xml
            Configuration cfg = new Configuration().configure();
            //tạo service registry từ hibernate configuration
            //service registry là một container cho các service
            //service là một thành phần mà hibernate sử dụng để tương tác với các bộ phận khác
            //ví dụ như connection pool, transaction system, logging system, jmx management

            // Đăng ký Entity để Hibernate nhận diện
            cfg.addAnnotatedClass(org.example.bluemoon.model.entity.User.class);
            cfg.addAnnotatedClass(org.example.bluemoon.model.entity.Information.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                    //lấy toàn bộ cấu hình từ file hibernate.cfg.xml và áp dụng cho service registry
                    applySettings(cfg.getProperties()).build();
            //tạo session factory từ service registry
            System.out.println("SessionFactory created successfully!");
            return cfg.buildSessionFactory(serviceRegistry);
        }catch(Exception e){
            logger.error("Initial SessionFactory creation failed.", e);
            throw new RuntimeException("Failed to initialize Hibernate SessionFactory.", e);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
            logger.info("Hibernate SessionFactory closed successfully.");
        }
    }

}
