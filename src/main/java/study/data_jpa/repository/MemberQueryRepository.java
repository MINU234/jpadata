package study.data_jpa.repository;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import study.data_jpa.entity.Member;

import java.util.List;

@AllArgsConstructor
@Repository
public class MemberQueryRepository {
    private final EntityManager em;

    List<Member> findAllMembers(){
        return em.createQuery("select m from Member m").getResultList();
    }
}
