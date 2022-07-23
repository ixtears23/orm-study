package junseok.snr.orm.sample.chapter5;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Team {
    private String id;
    private String name;

    public Team(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
