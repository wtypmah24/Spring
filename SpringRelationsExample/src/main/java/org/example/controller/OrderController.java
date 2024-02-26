package org.example.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.example.dto.order.OrderCreateRequestDto;
import org.example.dto.order.OrderResponseDto;
import org.example.service.OrderService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Validated
@RestController
@RequestMapping(
        path = "/orders",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public OrderResponseDto getOrder(@PathVariable("id") @Min(0) long id) {
        return orderService.getOrder(id);
    }

    @GetMapping()
    public Set<OrderResponseDto> getOrdersByUserId(@RequestParam("userId") @Min(0) long userId) {
        return orderService.getOrdersByUserId(userId);
    }

    @PostMapping()
    public OrderResponseDto createOrder(@RequestBody @Valid OrderCreateRequestDto candidate) {
        return orderService.saveOrder(candidate, null);
    }

    @PutMapping(path = "/{id}")
    public OrderResponseDto updateOrder(
            @PathVariable("id") @Min(0) long id,
            @RequestBody @Valid OrderCreateRequestDto candidate
    ) {
        return orderService.saveOrder(candidate, id);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") @Min(0) long id) {
        orderService.deleteOrder(id);
    }
}
