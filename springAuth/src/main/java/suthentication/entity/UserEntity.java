package suthentication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="User")
@Data
public class UserEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Id
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="userid")
    private String userId;

    @Column(name="password")
    private String password;



}
