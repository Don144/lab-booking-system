package lk.hasi.labbookingsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "password")
    private String password;

    @Column(name = "user_Name")
    private String userName;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "user_id")
    private String userId;
}
