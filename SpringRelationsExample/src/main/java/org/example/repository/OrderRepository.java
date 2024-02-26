package org.example.repository;

import org.example.entity.order.GoodsItem;
import org.example.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Set<Order> findAllByUserId(Long userId);

    Order findOrderByOrderDateAndItemsAndUserId(LocalDate orderDate, List<GoodsItem> items, Long user_id);
}
