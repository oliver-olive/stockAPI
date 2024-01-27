package com.example.stocktradeAPI.controller;


import com.example.stocktradeAPI.entity.Stocks;
import com.example.stocktradeAPI.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class StockController {

    @Autowired
    StockRepository stockRepository;
    String errorMessage = "Method is not allowed for this resource";
    @RequestMapping(value = "/trades", method = RequestMethod.GET)
    public ResponseEntity<List<Stocks>> getStocks(@RequestParam(name = "type", required = false) String type,
                                                  @RequestParam(name = "userId", required = false) Integer userId){
        List<Stocks> stk;
        if(type != null && userId != null){
            stk = stockRepository.findByTypeAndUserId(type, userId);
        }else if(type != null){
            stk = stockRepository.findByType(type);
        }else if(userId != null){
            stk = stockRepository.findByUserId(userId);
        }else {
            stk = stockRepository.findAll();
        }
        return new ResponseEntity<>(stk, HttpStatus.OK);
    }
    @RequestMapping(value = "/trades/", method = RequestMethod.GET)
    public ResponseEntity<List<Stocks>> getStocksWithS(@RequestParam(name = "type", required = false) String type,
                                                  @RequestParam(name = "userId", required = false) Integer userId){
        List<Stocks> stk;
        if(type != null && userId != null){
            stk = stockRepository.findByTypeAndUserId(type, userId);
        }else if(type != null){
            stk = stockRepository.findByType(type);
        }else if(userId != null){
            stk = stockRepository.findByUserId(userId);
        }else {
            stk = stockRepository.findAll();
        }
        return new ResponseEntity<>(stk, HttpStatus.OK);
    }
    @RequestMapping(value = "/trades/{id}", method = RequestMethod.GET)
    public ResponseEntity<Stocks> getStocksById(@PathVariable("id") int id){
        Stocks stk = stockRepository.findById(id);
        return new ResponseEntity<>(stk, HttpStatus.OK);

    }



    @RequestMapping(value = "/trades", method = RequestMethod.POST)
    public ResponseEntity<Stocks> postStocks(@RequestBody Stocks stocks){
        Stocks createdTrade = stockRepository.save(stocks);
        return new ResponseEntity<>(createdTrade, HttpStatus.CREATED);
    }

    @RequestMapping(value = "trades/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteStocks(@PathVariable("id") int id){
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(errorMessage);
    }
    @RequestMapping(value = "trades/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> putStocks(@PathVariable("id") int id){
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(errorMessage);
    }
    @RequestMapping(value = "trades/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<String> patchStocks(@PathVariable("id") int id){
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(errorMessage);
    }
}
