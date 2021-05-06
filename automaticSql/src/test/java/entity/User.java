package entity;

import lombok.Data;
import org.jryyy.autoumatic.annotations.Column;
import org.jryyy.autoumatic.annotations.Order;
import org.jryyy.autoumatic.annotations.Table;
import org.jryyy.autoumatic.entity.BaseEntity;

@Data
@Table("User a")
public class User extends BaseEntity {

    @Order
    @Column("a.id")
    private int aa;

    @Column("a.username")
    private String username;

    @Column("a.password")
    private String password;

}
