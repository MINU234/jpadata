package study.data_jpa.repository;

import org.springframework.stereotype.Repository;
import study.data_jpa.entity.Member;

import java.util.List;

@Repository
public interface MemberRepositoryCustom {
    List<Member> findMemberCustom();
}
