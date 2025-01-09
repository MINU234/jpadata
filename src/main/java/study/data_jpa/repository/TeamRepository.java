package study.data_jpa.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import study.data_jpa.entity.Team;

import java.util.List;
import java.util.Optional;

@Repository
public class TeamRepository {

    @PersistenceContext
    private EntityManager em;

    public Team save(Team team) {
        em.persist(team);
        return team;
    }

    public void delete(Team team) {
        em.remove(team);
    }

    public List<Team> findAll(){
        return em.createQuery("select t from Team t", Team.class)
                .getResultList();
    }

    public Optional<Team> findById(int id) { // 아이디를 이용해 찾게 될때 아이디가 NULL 값일때를 대비하여 Optional을 사용 (널 세이프티랑 비슷한 느낌?)
        Team team = em.find(Team.class, id);
        return Optional.ofNullable(team);
    }

    public long Count(){
        return em.createQuery(
                "select count(t) from Team t",Long.class
        ).getSingleResult();
    }
}
