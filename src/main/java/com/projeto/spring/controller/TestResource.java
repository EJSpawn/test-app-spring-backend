package com.projeto.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
@RequestMapping("/test")
public class TestResource {
    
    @GetMapping("/items")
    public List<Item> getAllItems() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Item 1", 10.0));
        items.add(new Item("Item 2", 20.0));
        items.add(new Item("Item 3", 30.0));
        return items;
    }
    
    @Data
    @AllArgsConstructor
    private class Item {
        private String name;
        private double price;
    }
}
