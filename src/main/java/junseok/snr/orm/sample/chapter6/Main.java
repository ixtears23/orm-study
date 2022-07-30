package junseok.snr.orm.sample.chapter6;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("snr-orm");
    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {
        saveMemberWithTeam();
        entityManager.close();
        entityManagerFactory.close();
    }

    private static void saveMemberWithTeam() {
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        final Member member = new Member();
        member.setId("member1");
        member.setUsername("회원1");

        final Team team = new Team();
        team.setId("team1");
        team.setName("팀1");

        member.setTeam(team);

        transaction.commit();
    }
}
