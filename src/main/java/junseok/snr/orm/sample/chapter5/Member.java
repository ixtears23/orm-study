package junseok.snr.orm.sample.chapter5;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Member {
    private String id;
    private String username;
    private Team team;

    public Member(String id, String username) {
        this.id = id;
        this.username = username;
    }
}
