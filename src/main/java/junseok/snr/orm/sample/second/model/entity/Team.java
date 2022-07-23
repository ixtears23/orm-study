package junseok.snr.orm.sample.second.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@ToString
@Getter @Setter
@NoArgsConstructor
//@Entity
public class Team {

    @Id
    @Column(name = "TEAM_ID")
    private String id;
    private String name;

    public Team(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
