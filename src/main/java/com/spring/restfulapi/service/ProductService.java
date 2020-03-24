package com.spring.restfulapi.service;

import com.spring.restfulapi.entity.Product;
import com.spring.restfulapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return productRepository.saveAll(products);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(int id){
        return productRepository.findById(id).orElse(null);
    }

    public Product getProductByName(String name){
        return productRepository.findByName(name);
    }

    public String deleteProduct(int id){
        productRepository.deleteById(id);
        return "Product Removed ! " + id;
    }

    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);

        if (existingProduct != null){
            existingProduct.setName(product.getName());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setPrice(product.getPrice());
        }

        assert existingProduct != null;
        return productRepository.save(existingProduct);
    }
}
