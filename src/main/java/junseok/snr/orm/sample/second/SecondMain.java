package junseok.snr.orm.sample.second;

import junseok.snr.orm.sample.second.model.entity.Member;
import junseok.snr.orm.sample.second.model.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SecondMain {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("snr-orm");
    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();


    public static void main(String[] args) {

        final SecondMain secondMain = new SecondMain();
        secondMain.printEntity();
    }

    public void testSave() {
        final EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();

        Team team1 = new Team("team1", "팀1");
        entityManager.persist(team1);

        final Member member1 = new Member("member1", "회원1");
        member1.setTeam(team1);
        entityManager.persist(member1);

        Member member2 = new Member("member2", "회원2");
        member2.setTeam(team1);
        entityManager.persist(member2);

        transaction.commit();
    }

    public void printEntity() {

        final Member memberFind1 = entityManager.find(Member.class, "member1");
        final Member memberFind2 = entityManager.find(Member.class, "member2");

        System.out.println(memberFind1);
        System.out.println(memberFind2);
        System.out.println(memberFind1.getTeam());
        System.out.println(memberFind2.getTeam());
    }
}
