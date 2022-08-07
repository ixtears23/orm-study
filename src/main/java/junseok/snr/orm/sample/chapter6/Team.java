package junseok.snr.orm.sample.chapter6;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TEAM")
public class Team {
    @GeneratedValue
    @Id @Column(name = "TEAM_ID")
    private String id;
    @Column
    private String name;
    @OneToMany(mappedBy = "team")
    private List<Member> members;

}
