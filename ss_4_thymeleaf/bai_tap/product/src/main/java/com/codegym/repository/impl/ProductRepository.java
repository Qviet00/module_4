package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
       
        productList.add( new Product(1, "XiaoMi", 100, "Còn hàng", "Mi"));
        productList.add( new Product(2, "Iphone", 200, "Hết hàng", "Apple"));
        productList.add( new Product(3, "Galaxy", 300, "Còn hàng", "Samsung"));
        productList.add( new Product(4, "Q-mobile", 400, "Hết hàng", "Q"));
        productList.add( new Product(5, "Realme", 500, "Còn hàng", "Xiaomi"));

    }

    @Override
    public List<Product> findAll(String name) {
        List<Product> product = new ArrayList<>();
        if (name == null) {
            return productList;
        } else {
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getNameOfProduct().contains(name)) {
                    product.add(productList.get(i));
                }
            }
            return product;
        }
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()) {
                productList.remove(i);
            }
        }
    }

    @Override
    public void update(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (product.getId() == productList.get(i).getId()) {
                productList.get(i).setNameOfProduct(product.getNameOfProduct());
                productList.get(i).setPrice(product.getPrice());
                productList.get(i).setDescription(product.getDescription());
                productList.get(i).setMadeIn(product.getMadeIn());
            }
        }
    }

    @Override
    public Product findById(int id) {
        Product product = new Product();
        for (int i = 0; i < productList.size(); i++) {
            if (id == productList.get(i).getId()) {
                product = productList.get(i);
            }
        }
        return product;
    }

    @Override
    public void create(Product product) {
        int id = (int) (Math.random() * 1000);
        product.setId(id);
        productList.add(product);
    }
}
