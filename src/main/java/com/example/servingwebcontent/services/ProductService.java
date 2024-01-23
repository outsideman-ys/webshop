package com.example.servingwebcontent.services;

import com.example.servingwebcontent.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private long ID = 0;

    {
        products.add(new Product( ++ID, "Стикеры Мяу-Мяу", 500, "Настоящим кошечкам понравится",
                "Влад", 0 ));
        products.add(new Product( ++ID,"Стикеры Гав-Гав", 500, "Настоящим щенятам понравится",
                "Савелий", 0));
    }

    public List<Product> listProduct() {return products;}

    public void saveProduct(Product product) {
        product.setId(ID);
        products.add(product);
    }

    public void deleteProduct (Long id) {
        products.removeIf(product -> product.getId().equals(id));
    }
}
