package study.data_jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Item implements Persistable<String> {

    @Id
    private String id;

    public Item(String Id){
        this.id = id;
    }

    @CreatedDate
    private LocalDateTime createDate;

    @Override
    public String getId(){
        return id;
    }

    @Override
    public boolean isNew() {
        return createDate == null;
    }

}
