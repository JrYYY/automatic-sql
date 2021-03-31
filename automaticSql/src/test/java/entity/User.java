package entity;

import lombok.Data;
import org.jryyy.autoumatic.bind.Column;
import org.jryyy.autoumatic.bind.Table;

@Data
@Table("User a")
public class User {

    @Column("a.id")
    private int id;

    @Column("a.username")
    private String username;

    @Column("a.password")
    private String password;

}
