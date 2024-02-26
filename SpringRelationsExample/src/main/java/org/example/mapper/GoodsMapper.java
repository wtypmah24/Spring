package org.example.mapper;

import org.example.dto.order.GoodsItemDto;
import org.example.entity.order.GoodsItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoodsMapper {
    public GoodsItemDto toGoodsItemDto(GoodsItem item) {
        return new GoodsItemDto(
                item.getId(),
                item.getItemName(),
                item.getDescription(),
                item.getPrice()
        );
    }

    public List<GoodsItemDto> toGoodsItemDtoList(List<GoodsItem> item) {
        return item.stream().map(this::toGoodsItemDto).toList();
    }
}
