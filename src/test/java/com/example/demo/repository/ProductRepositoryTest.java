package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() {
        //create product
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");

        //save product
        Product savedObject = productRepository.save(product);


        //display product information
        System.out.println(savedObject.getId());
        System.out.println(savedObject.toString());
    }

    @Test
    void updateUsingSaveMethod() {

        //find or retrieve an entity form database
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        //update entity information

        product.setName("updated product 1");
        product.setDescription("updated product 1 desc");

        //save updated entity
        productRepository.save(product);


    }

    @Test
    void findByIdMethod() {
        Long id = 1L;

        Product product = productRepository.findById(id).get();

    }

    @Test
    void saveAllMethod(){
        //create product
        Product product4 = new Product();
        product4.setName("product 4");
        product4.setDescription("product 2 description");
        product4.setSku("101ABCD");
        product4.setPrice(new BigDecimal(200));
        product4.setActive(true);
        product4.setImageUrl("product2.png");

        //create product
        Product product5 = new Product();
        product5.setName("product 5");
        product5.setDescription("product 3 description");
        product5.setSku("102ABCDE");
        product5.setPrice(new BigDecimal(200));
        product5.setActive(true);
        product5.setImageUrl("product3.png");

        productRepository.saveAll(List.of(product4,product5));

    }

    @Test
    void findAllMethod(){
        List<Product> products= productRepository.findAll();
        System.out.println("======================");
        products.forEach(product -> System.out.println(product.getName()));
        System.out.println("======================");
    }

    @Test
    void deleteByIdMethod(){
        long id = 1L;

        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod(){

        //find an entity by id
        long id=3L;
        Product product=productRepository.findById(id).get();

        //delete (entity)
        productRepository.delete(product);

    }

    @Test
    void deleteAllMethod(){
       // productRepository.deleteAll();

        Product product=productRepository.findById(14L).get();
        Product product2=productRepository.findById(15L).get();

        productRepository.deleteAll(List.of(product,product2));

    }

    @Test
    void countMethod(){
        long count = productRepository.count();
        System.out.println("==============");
        System.out.println("| count = " + count+"  |");
        System.out.println("==============");
    }



}