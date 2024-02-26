package org.example.entity.statistics;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client_app_statistics")
public class ClientAppStatistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "client_app_name")
    private String clientAppName;
    @Column(name = "client_app_count")
    private long clientAppCount;
}
