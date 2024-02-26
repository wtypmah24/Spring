package org.example.entity.user;

import jakarta.persistence.*;
import lombok.*;
import org.example.entity.order.Order;
import org.example.entity.user.expert.ExpertGroup;
import org.example.entity.user.registration.Registration;
import org.example.entity.user.settings.Settings;
import org.example.entity.user.status.UserStatus;
import org.example.entity.user.verification.UserVerificationData;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString(exclude = {"orders"})
@EqualsAndHashCode(exclude = {"orders", "registration"})
@Entity
@Table(name = "users")
@SecondaryTable(name = "user_details", pkJoinColumns = @PrimaryKeyJoinColumn(name = "user_id"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "email")
    private String email;

    @Column(name = "phone", table = "user_details")
    private String phone;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private Registration registration;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserVerificationData userVerificationData;

    @Embedded
    private Settings settings;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private UserStatus status;

    @ManyToMany(mappedBy = "users")
    private Set<ExpertGroup> expertGroups = new HashSet<>();

    public void addOrder(Order order) {
        orders.add(order);
        order.setUser(this);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
        order.setUser(null);
    }
}
