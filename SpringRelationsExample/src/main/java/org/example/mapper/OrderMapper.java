package org.example.mapper;

import org.example.dto.order.GoodsItemDto;
import org.example.dto.order.OrderResponseDto;
import org.example.entity.order.GoodsItem;
import org.example.entity.order.Order;
import org.example.entity.user.User;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class OrderMapper {

    public OrderResponseDto toOrderGetResponseDto(Order order, List<GoodsItemDto> goods) {
        return new OrderResponseDto(
                order.getId(),
                order.getOrderDate(),
                order.getUser().getId(),
                goods
        );
    }

    public Order toOrder(@Nullable Long id, User user, List<GoodsItem> items) {
        Order order = new Order();
        order.setId(id);
        order.setOrderDate(LocalDate.now());
        user.addOrder(order);
        items.forEach(order::addItem);
        return order;
    }

}
