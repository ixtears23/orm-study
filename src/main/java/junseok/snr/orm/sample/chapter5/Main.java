package junseok.snr.orm.sample.chapter5;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("snr-orm");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        final Member member3 = new Member("member3", "회원3");
        entityManager.persist(member3);
        final Member member4 = new Member("member4", "회원4");
        entityManager.persist(member4);

        final Team team2 = new Team("team2", "팀2");
        member3.setTeam(team2);
        member4.setTeam(team2);
        entityManager.persist(team2);
        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();

    }
}
