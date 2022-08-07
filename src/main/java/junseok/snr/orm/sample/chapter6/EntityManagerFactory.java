package junseok.snr.orm.sample.chapter6;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerFactory {
    private static final javax.persistence.EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("snr-orm");
    }

    public static EntityManager create() {
        return entityManagerFactory.createEntityManager();
    }

}
