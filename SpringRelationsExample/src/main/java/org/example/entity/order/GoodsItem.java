package org.example.entity.order;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@ToString(exclude = {"orders"})
@EqualsAndHashCode(exclude = {"orders"})
@Entity
@Table(name = "goods_items")
public class GoodsItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToMany(mappedBy = "items")
    private Set<Order> orders = new HashSet<>();
}
