package org.example.repository;

import org.example.entity.order.GoodsItem;
import org.example.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsRepository extends JpaRepository<GoodsItem, Long> {

}
