package junseok.snr.orm.sample.chapter6;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
public class Team {

    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private String id;
    private String name;
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    public void addMember(Member member) {
        this.members.add(member);
        member.setTeam(this);
    }
}
