package org.example.entity.user.status;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.user.User;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users_status")
@Data
@NoArgsConstructor
public class UserStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "is_vip")
    private boolean isVip;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<User> users = new HashSet<>();
}
