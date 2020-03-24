package com.spring.restfulapi.controller;

import com.spring.restfulapi.entity.Product;
import com.spring.restfulapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST, headers = "Accept=application/json")
    public Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @RequestMapping(value = "/addProducts", method = RequestMethod.POST, headers = "Accept=application/json")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return productService.saveProducts(products);
    }

    @RequestMapping(value = "/findAllProducts", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Product> findAllProducts(){
        return productService.getProducts();
    }

    @RequestMapping(value = "/findProductById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Product findProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @RequestMapping(value = "/findProductByName/{name}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Product findProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }

    @RequestMapping(value = "/updateProduct", method = RequestMethod.PUT, headers = "Accept=application/json")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public String deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }
}
