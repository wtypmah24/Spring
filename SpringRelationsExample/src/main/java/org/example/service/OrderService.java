package org.example.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.dto.order.OrderCreateRequestDto;
import org.example.dto.order.OrderResponseDto;
import org.example.entity.order.GoodsItem;
import org.example.entity.order.Order;
import org.example.entity.user.User;
import org.example.mapper.GoodsMapper;
import org.example.mapper.OrderMapper;
import org.example.repository.GoodsRepository;
import org.example.repository.OrderRepository;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final GoodsRepository goodsRepository;
    private final OrderMapper orderMapper;
    private final GoodsMapper goodsMapper;

    @Autowired
    public OrderService(
            OrderRepository orderRepository,
            UserRepository userRepository,
            GoodsRepository goodsRepository,
            OrderMapper orderMapper,
            GoodsMapper goodsMapper
    ) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.goodsRepository = goodsRepository;
        this.orderMapper = orderMapper;
        this.goodsMapper = goodsMapper;
    }

    public OrderResponseDto getOrder(long id) {
        Order order = orderRepository.getReferenceById(id);
        return orderMapper.toOrderGetResponseDto(order, goodsMapper.toGoodsItemDtoList(order.getItems()));
    }

    public Set<OrderResponseDto> getOrdersByUserId(long userId) {
        return Optional.ofNullable(orderRepository.findAllByUserId(userId)).orElse(new HashSet<>()).stream()
                .map(o -> orderMapper.toOrderGetResponseDto(o, goodsMapper.toGoodsItemDtoList(o.getItems())))
                .collect(Collectors.toSet());
    }

    @Transactional // этот метод позволяет как сохранять новые, так и обновлять существующие записи БД
    public OrderResponseDto saveOrder(OrderCreateRequestDto candidate, Long id) {
        User user = userRepository.findById(candidate.userId())
                .orElseThrow(() -> new EntityNotFoundException("Cannot find user with id=" + candidate.userId()));
        List<GoodsItem> items = goodsRepository.findAllById(candidate.itemIds());
        Order order = orderMapper.toOrder(id, user, items); // если id==null, то будет создана новая запись в БД, в противном случае - обновлена существующая
        order = orderRepository.saveAndFlush(order);
        return orderMapper.toOrderGetResponseDto(order, goodsMapper.toGoodsItemDtoList(order.getItems()));
    }


    @Transactional
    public void deleteOrder(long id) {
        Optional<Order> order = orderRepository.findById(id);
        order.ifPresent(o -> {
            User user = o.getUser();
            user.removeOrder(o);
            orderRepository.delete(o);
        });
    }
}
