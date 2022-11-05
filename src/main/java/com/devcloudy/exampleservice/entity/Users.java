package com.devcloudy.exampleservice.entity;

import com.devcloudy.exampleservice.user.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;
    private String photo;
    private String name;
    private String username;
    private String password;
    private String email;
    private UserRole role;
    @Column(name = "enabled")
    private boolean enabled;

    public Users(UUID id, String photo, String name, String username, String password, String email, UserRole role, boolean enabled) {
        this.id = id;
        this.photo = photo;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.enabled = enabled;
    }
}
