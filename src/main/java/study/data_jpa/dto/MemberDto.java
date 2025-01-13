package study.data_jpa.dto;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class MemberDto {

    public MemberDto(Long id, String username, String Teamname) {
        this.id = id;
        this.username = username;
        this.Teamname = Teamname;
    }

    @Id
    private Long id;
    private String username;
    private String Teamname;
}
