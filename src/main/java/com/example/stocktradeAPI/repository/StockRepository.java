package com.example.stocktradeAPI.repository;

import com.example.stocktradeAPI.entity.Stocks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stocks, Integer> {
    Stocks findById(int id);
    List<Stocks> findByTypeAndUserId(String type, Integer userId);
    List<Stocks> findByType(String type);
    List<Stocks> findByUserId(Integer userId);

}
