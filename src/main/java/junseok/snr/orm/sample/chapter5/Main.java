package junseok.snr.orm.sample.chapter5;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("snr-orm");
    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();

    public static void main(String[] args) {
//        saveTeamWithMember();
//        queryLogicJoin();
//        findTeamWithMember();
//        updateRelation();
//        deleteRelation();
//        biDirection();
        saveToWayAssociation();
        entityManager.close();
        entityManagerFactory.close();
    }

    private static void saveToWayAssociation() {
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        final Team team3 = new Team("team3", "팀3");
        final Member member3 = entityManager.find(Member.class, "member3");
        member3.setTeam(team3);
        team3.getMembers().add(member3);

        transaction.commit();
    }

    private static void biDirection() {
        final Team team1 = entityManager.find(Team.class, "team1");
        List<Member> members = team1.getMembers();
        members.forEach(System.out::println);
    }

    private static void deleteRelation() {
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        final Member member1 = entityManager.find(Member.class, "member1");
        member1.setTeam(null);

        transaction.commit();
    }

    private static void updateRelation() {
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        final Team team2 = new Team("team2", "팀2");
        entityManager.persist(team2);

        final Member member1 = entityManager.find(Member.class, "member1");
        member1.setTeam(team2);

        transaction.commit();
    }

    private static void findTeamWithMember() {
        final Member member1 = entityManager.find(Member.class, "member1");
        final Member member2 = entityManager.find(Member.class, "member2");
        System.out.println("member1.team = " + member1.getTeam());
        System.out.println("member2.team = " + member2.getTeam());
    }

    private static void queryLogicJoin() {
        String jpql = "select m from Member m join m.team t where t.name = :teamName";

        final List<Member> members = entityManager.createQuery(jpql, Member.class)
                .setParameter("teamName", "팀1")
                .getResultList();

        members.forEach(member -> System.out.println("[query] member.username=" + member.getUsername()));
    }


    private static void saveTeamWithMember() {
        final EntityTransaction transaction = entityManager.getTransaction();

        final Team team1 = new Team("team1", "팀1");
        final Member member1 = new Member("member1", "회원1");
        final Member member2 = new Member("member2", "회원2");
        member1.setTeam(team1);
        member2.setTeam(team1);

        transaction.begin();
        entityManager.persist(member1);
        entityManager.persist(member2);
        entityManager.persist(team1);
        transaction.commit();
    }

}
