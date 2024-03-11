package tmp.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class UserEntity {
    @Id
    private String username;
    private String password;

    public UserEntity() { }

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
