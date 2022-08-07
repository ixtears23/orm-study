package junseok.snr.orm.sample.chapter6;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MEMBER")
public class Member {
    @GeneratedValue
    @Id @Column(name = "MEMBER_ID")
    private String id;
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;
    @Column
    private String username;
}
