package org.yourcompany.yourproject.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import org.yourcompany.yourproject.entities.Salle;
import org.yourcompany.yourproject.entities.Machine;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Load configuration from hibernate.cfg.xml
            Configuration configuration = new Configuration().configure();

            // Explicitly add your annotated entity classes
            configuration.addAnnotatedClass(Salle.class);
            configuration.addAnnotatedClass(Machine.class);

            ServiceRegistry serviceRegistry =
                    new StandardServiceRegistryBuilder()
                            .applySettings(configuration.getProperties())
                            .build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
