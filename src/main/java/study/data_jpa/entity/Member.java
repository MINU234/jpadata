package study.data_jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id","username","age"}) //team을 안적는 이유 team과 Member는 연관관계이기 때문에 서로 참조를 하다보면 무한루프가 될 수있다.
public class Member {

    @Id @GeneratedValue
    @Column(name="member_id")
    private Long id;
    private String username;
    private int age;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Member(String username) {
        this.username = username;
    }
    public Member(String username, int age,Team team) {
        this.username = username;
        this.age = age;
        this.team = team;
    }

    public void changeTeam(Team team){
        this.team = team;
        team.getMembers().add(this);
    }


}
