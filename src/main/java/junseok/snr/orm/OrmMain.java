package junseok.snr.orm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class OrmMain {

    public static void main(String[] args) {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("snr-orm");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            businessLogic(entityManager);
            transaction.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        entityManagerFactory.close();
    }

    public static void businessLogic(EntityManager entityManager) {
        final String id = "junseok3";
        final Member member = new Member();
        member.setId(id);
        member.setUserName("준석");
        member.setAge(28);

        entityManager.persist(member);

        member.setAge(26);

        final Member member1 = entityManager.find(Member.class, id);
        System.out.println(member1);

        final List<Member> members = entityManager.createQuery("select m from Member m", Member.class).getResultList();
        System.out.println(members);

        entityManager.remove(member);

        entityManager.persist(member);
        System.out.println(entityManager.find(Member.class, id));
    }
}
