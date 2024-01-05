package com.example.servingwebcontent.models;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Product {
    private String name;
    private Long id;
    private int price;
    private String description;
    //private HashMap<Integer, Product> similar;
    //private HashMap<Integer, Product> kinds;
    //TODO class Review
    //private HashMap<Integer, Review> reviews;
    //TODO в будущем будет class Seller
    private String seller;
    private int rating;
}
